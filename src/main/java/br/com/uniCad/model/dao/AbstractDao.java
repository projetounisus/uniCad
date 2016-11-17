package br.com.uniCad.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.Map.Entry;

import br.com.uniCad.exceptions.DoesntHaveInheritence;
import br.com.uniCad.model.beans.AbstractBean;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.SQLDialect;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.conf.ObjectFactory;
import org.jooq.impl.DSL;

import org.jooq.Record;
import org.jooq.Result;

import static org.jooq.impl.DSL.table;
import static org.jooq.impl.DSL.field;

import br.com.uniCad.constants.Constants;
import br.com.uniCad.utils.Mapper;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;

public abstract class AbstractDao<T extends AbstractBean> implements Crud<AbstractBean> {
	public AbstractDao(Class<?> currentBeanClass){
		this.currentClassBean = currentBeanClass;
	}
	
	private Class<?> currentClassBean;
	static private Connection connection;
	
	// TODO: porque est� p�blico? 
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		if(connection == null)
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(Constants.connectionString, Constants.userNameDataBase, Constants.userPasswordDataBase);
		}
		return connection;
	}
	
	private int getLastIndexInserted() throws ClassNotFoundException, SQLException{
		Connection currentConnection = getConnection();
		
		PreparedStatement preparedStatement = currentConnection.prepareStatement("SELECT max(id) 'id' FROM " + getTableName());
		ResultSet result = preparedStatement.executeQuery();
		result.first();
		return result.getInt("id");
	}
	
	public int insert(AbstractBean bean) {
		// TODO Auto-generated method stub
		try {
			Connection currentConnection = getConnection();
			DSLContext query = DSL.using(currentConnection, SQLDialect.MYSQL);
			
			int beanId = bean.getId();
			
			// Casa haja heran�a, insere os dados do bean em todas as "super-tabelas"
			if(this.hasInheritance())
				beanId = this.insertInheritance(bean);
			
			Map<String, String> mapColumnToProperty = this.getMapColumnToProperty();
			Collection<Field<?>> columns = new ArrayList<Field<?>>();
			List<Object> values = new ArrayList<Object>();
			
			columns.add(field("id"));
			values.add(beanId);
			
			for(Entry<String, String> currentColumnPropPair : mapColumnToProperty.entrySet()){
				String columnName = currentColumnPropPair.getKey();
				String propertyName = currentColumnPropPair.getValue();
				
				java.lang.reflect.Field declaredField = this.currentClassBean.getDeclaredField(propertyName);
				
				declaredField.setAccessible(true);
				Object propValue = declaredField.get(bean);
				
				// tratando chave estrangeira
				if(propValue instanceof AbstractBean){
					AbstractBean beanPropValue = (AbstractBean)propValue;
					
					//Caso n�o haja linha refrenciada, insere na tabela referenciada
					if(beanPropValue.getId() ==  0)
					{
						AbstractDao foreignKeyDao = Mapper.beanToDao(beanPropValue);
						propValue = foreignKeyDao.insert(beanPropValue); //TODO: isto � reatribui��o, consertar
					}
					else //Casa haja linha referenciada, user seu Id
					{
						propValue = beanPropValue.getId();
					}
				}
				
				columns.add(field(columnName));
				values.add(propValue);
			}
			
			query.insertInto(table(getTableName())).columns(columns).values(values).returning().execute();
			
			int id = getLastIndexInserted();
			return id;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;
	}
	
	public void update(AbstractBean bean) {
		// TODO Auto-generated method stub
		
		try {
			Connection currentConnection = getConnection();
			DSLContext query = DSL.using(currentConnection, SQLDialect.MYSQL);

			Map<String, String> mapColumnToProperty = this.getMapColumnToProperty();

			Map<Field<?>, Object> fieldObjectHashMap = new HashMap<Field<?>, Object>();

			for(Entry<String, String> currentMap :mapColumnToProperty.entrySet())
			{
				java.lang.reflect.Field declaredField = this.currentClassBean.getDeclaredField(currentMap.getValue());
				declaredField.setAccessible(true);
				Object value = declaredField.get(bean);

				String currentColumn = currentMap.getKey();
				
				if(value instanceof AbstractBean)
				{
					this.update((AbstractBean)value);
					continue;
				}

				fieldObjectHashMap.put(field(currentColumn), value);
			}

			Field<Object> idField = field("id");
			
			query.update(table(getTableName()))
			.set(fieldObjectHashMap)
			.where(idField.equal(bean.getId()))
			.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<AbstractBean> list() {
		try {
			Connection currentConnection = getConnection();
			DSLContext query = DSL.using(currentConnection, SQLDialect.MYSQL);
			
			Result<Record> result = query.select().from(table(getTableName())).fetch();
			
			AbstractDeserializer<T> deserializer = this.getDeserializer();
			List<T> deserializedResult = deserializer.fromDataBaseResult(result);
			
			return (List<AbstractBean>) deserializedResult;
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public AbstractBean getById(int id) {
		Connection currentConnection;
		try {
			currentConnection = getConnection();
			DSLContext query = DSL.using(currentConnection, SQLDialect.MYSQL);
			
			Field<Object> field = field("id");
			Result<Record> result = query.select().from(table(getTableName())).where(field.equal(id)).fetch();
			
			Record record = result.get(0);
			
			AbstractDeserializer<T> deserializer = this.getDeserializer();
			T deserializedRecord = deserializer.fromDataBaseRecord(record);
			
			return deserializedRecord;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//TODO: reduzir esta repetição de código
	public AbstractBean getByName(String name){
		Connection currentConnection;
		try {
			currentConnection = getConnection();
			DSLContext query = DSL.using(currentConnection, SQLDialect.MYSQL);
			
			Field<Object> field = field("name");
			Result<Record> result = query.select().from(table(getTableName())).where(field.equal(name)).fetch();
			
			Record record = result.get(0);
			
			AbstractDeserializer<T> deserializer = this.getDeserializer();
			T deserializedRecord = deserializer.fromDataBaseRecord(record);
			
			return deserializedRecord;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	// Ou faço um join para trazer os ids relacionados a ele, ou tenho de receber o objeto inteiro
	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			AbstractBean currentBean = this.getById(id);

			Connection currentConnection = getConnection();
			DSLContext query = DSL.using(currentConnection, SQLDialect.MYSQL);

			if(this.hasInheritance()){
				this.deleteInheritance(currentBean);
			}

			query.delete(table(this.getTableName())).where(field("id").equal(id)).execute();

			Map<String, String> mapColumnToProperty = this.getMapColumnToProperty();

			for(Entry<String, String> currentEntry : mapColumnToProperty.entrySet()){
				String property = currentEntry.getValue();

				java.lang.reflect.Field declaredField = this.currentClassBean.getDeclaredField(property);

				declaredField.setAccessible(true);
				Object propValue = declaredField.get(currentBean);

				// tratando chave estrangeira
				if(propValue instanceof AbstractBean){
					AbstractBean foreignBean = (AbstractBean)declaredField.get(currentBean);

					AbstractDao abstractDao = Mapper.beanToDao(foreignBean);
					abstractDao.delete(foreignBean.getId());
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (DoesntHaveInheritence doesntHaveInheritence) {
			doesntHaveInheritence.printStackTrace();
		}

	}
	
	//TODO: ver se � poss�vel deslocar esta fun��o para a AbstractBean de forma est�tica 
	protected abstract String getTableName();
	protected abstract AbstractDeserializer<T> getDeserializer();
	public abstract Map<String, String> getMapColumnToProperty();
	// TODO: esses métodos podem acessar o this?
	protected abstract int insertInheritance(AbstractBean bean);
	protected abstract void deleteInheritance(AbstractBean bean) throws DoesntHaveInheritence;
	protected abstract boolean hasInheritance();
	

}
