package br.com.uniCad.model.dao.auxiliarData;

import static org.jooq.impl.DSL.table;
import static org.jooq.impl.DSL.field;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.impl.DSL;

import br.com.uniCad.model.beans.AbstractBean;
import br.com.uniCad.model.dao.AbstractDao;
import br.com.uniCad.model.dao.beans.AbstractDaoBean;
import br.com.uniCad.utils.MapperBeanToDao;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;

/*
 * Anotações:
 * A classe no momento visa somente obter dados a partir de uma das tabelas do relacionamento
 * - getTableName (herdado): obtem o nome da tabela da qual partirá a pesquisa
 * - getRelatedTableName : obtem o nome da tabela relacionada, da qual se obterá os dados, a reposta
 * da consulta virá desta tabela
 * - getAuxiliarTableName: caso o relacionamento seja de muitos para muitos
 * - getRelatedForeignKey: obtem a foerignKey na tabela com a cardinalidade muitos
 * - getCurrentForeignKey: funciona somente em relação de muito para muitos, onde obtem a chave estrangeira relacionada
 * a tabela da qual partira a pesquisa na terceira tabela, nesse caso, getRelatedForeignKey indicará a foreign key da tabela relacionada
 * também na terceira tabela 
 * */

public abstract class AbstractDaoAuxiliar<T extends AbstractBean> extends AbstractDao {
	
	public AbstractDaoAuxiliar(Class<?> currentBeanClass, Class<?> relatedBeanClass) {
		super(currentBeanClass);
		
		this.relatedByClass = relatedBeanClass;
		
		this.relatedTableName = this.getRelatedTableName();
		this.tableName = this.getTableName();
		
		this.currentTable = table(tableName);
		this.relatedTable = table(relatedTableName);
		
		this.currentForeignKey = field(this.getCurrentForeignKey());
		this.joinedForeignKey = field(this.getRelatedForeignKey());
	}

	public enum RelationshipType{
		oneToMany,
		manyToMany
	}
	
	protected RelationshipType currentRelationshipType;
	private Class<?> relatedByClass;
	
	public List<T> getSelfRelatedData(int id) throws Exception{
		Connection connection = this.getConnection();
		DSLContext query = DSL.using(connection, SQLDialect.MYSQL);
		
		AbstractDeserializer<T> deserializer = this.getRelatedDeserializer();
		
		switch (this.currentRelationshipType) {
			case oneToMany:
				
				Result<Record> resultOneToMany = query.select()
				.from(this.relatedTable)
				.where(this.joinedForeignKey.equal(id))
				.fetch();
				
				List<T> beansOneToMany = (List<T>)deserializer.fromDataBaseResult(resultOneToMany);
				
				return beansOneToMany;
				
			case manyToMany:
				//TODO: Implementar join de tabelas corretamente
				// Obs: usar equal e não equals para comparação de chaves 
				
				Table<Record> auxiliarTable = table(this.getAuxiliarTableName());
				
				Result<Record> firstJoin = query.select()
				.from(auxiliarTable)
				.where(currentForeignKey.equal(id)).fetch();
				
				List<Integer> relatedKeys = this.getRelatedKeys(firstJoin);
				
				Result<Record> resultManyToMany = query.select()
				.from(relatedTable)
				.where(field("id").in(relatedKeys)).fetch();
				
				List<T> beansManyToMany = (List<T>)deserializer.fromDataBaseResult(resultManyToMany);
				
				return beansManyToMany;
			
			default:
				throw new Exception();
		}
		
	}
	
	public void deleteRelatedData(int id) throws ClassNotFoundException, SQLException{
		Connection connection = getConnection();
		DSLContext query = DSL.using(connection, SQLDialect.MYSQL);
		
		switch(this.currentRelationshipType){
			case oneToMany:
					final Result<Record1<Object>> relatedIds = query.select(field("id"))
					.from(this.relatedTableName)
					.where(joinedForeignKey.equal(id))
					.fetch();
				
					AbstractDaoBean beanClassToDao = MapperBeanToDao.beanClassToDao(this.relatedByClass);
					
					for(Record1<Object> currentIdRecord : relatedIds){
						final String currentIdStr = currentIdRecord.get("id").toString();
						final int currentId = Integer.parseInt(currentIdStr);
						
						beanClassToDao.delete(currentId);
					}
					
				break;
			case manyToMany:
					Table<Record> auxiliarTable = table(this.getAuxiliarTableName());
				
					query.delete(auxiliarTable)
					.where(currentForeignKey.equal(id))
					.execute();
				break;
			default:
				break;
		}
	}
	
	public void updateRelatedData(AbstractBean bean) throws ClassNotFoundException, SQLException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		Connection connection = getConnection();
		DSLContext query = DSL.using(connection, SQLDialect.MYSQL);
		
		switch(this.currentRelationshipType){
			case oneToMany:
				
				final java.lang.reflect.Field relatedOneToManyField = this.relatedByClass.getField(this.getRelatedFieldName());
				final AbstractDaoBean relatedDaoOneToMany = MapperBeanToDao.beanClassToDao(this.relatedByClass);
				final List<AbstractBean> listRelatedOneToManyBean = (List<AbstractBean>)relatedOneToManyField.get(bean);
				
				for(AbstractBean currentRelatedBean: listRelatedOneToManyBean)
				{
					relatedDaoOneToMany.update(currentRelatedBean);
				}
				
				break;
			case manyToMany:
				
				//TODO: implementar...
				
				break;
		}
	}
	
	public void insertRelatedData(AbstractBean bean) throws ClassNotFoundException, SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Connection connection = getConnection();
		DSLContext query = DSL.using(connection, SQLDialect.MYSQL);
		
		switch(this.currentRelationshipType){
		case oneToMany:
				final AbstractDaoBean relatedDao = MapperBeanToDao.beanClassToDao(this.relatedByClass);
				final Map<String, String> mapColumnToProperty = relatedDao.getMapColumnToProperty();
				
				Collection<Field<?>> columnsOneToMany = new ArrayList<Field<?>>();
				List<Object> values = new ArrayList<Object>();
				
				for(Entry<String, String> currentColumnToProperty : mapColumnToProperty.entrySet()){
					final String column = currentColumnToProperty.getKey();
					final String value = currentColumnToProperty.getValue();
					
					columnsOneToMany.add(field(column));
					values.add(value);
				}
				
				query.insertInto(this.relatedTable)
				.columns(columnsOneToMany)
				.values(values)
				.execute();
			
			break;
		case manyToMany:
			
			final String relatedFieldName = this.getRelatedFieldName();
			final java.lang.reflect.Field relatedManyToManyField = bean.getClass().getDeclaredField(relatedFieldName);
			relatedManyToManyField.setAccessible(true);
			
			final List<AbstractBean> listRelatedManyToMany = (List<AbstractBean>)relatedManyToManyField.get(bean);
			
			final Table<Record> auxiliarTable = table(this.getAuxiliarTableName());
			
			final List<Field<Object>> columnsManyToMany = Arrays.asList(this.currentForeignKey, this.joinedForeignKey);
			
			for(AbstractBean currentRelatedBean : listRelatedManyToMany){
				query.insertInto(auxiliarTable)
				.columns(columnsManyToMany)
				.values(bean.getId(), currentRelatedBean.getId())
				.execute();
			}
			
			break;
		}
	}
	
	private List<Integer> getRelatedKeys(Result<Record> indexes){
		List<Integer> indexesList = new ArrayList<Integer>();
		
		for(Record currentIndexRecord : indexes){
			Object currentIndex = currentIndexRecord.get(getRelatedForeignKey());
			
			indexesList.add(Integer.parseInt(currentIndex.toString()));
		}
		
		return indexesList;
	}
	
	protected abstract String getRelatedTableName();
	protected abstract String getAuxiliarTableName();
	protected abstract AbstractDeserializer<T> getRelatedDeserializer();
	
	protected abstract String getCurrentForeignKey();
	protected abstract String getRelatedForeignKey();
	
	protected abstract String getRelatedFieldName();
	
	private String relatedTableName;
	private String tableName;
	
	private Table<Record> currentTable;
	private Table<Record> relatedTable;
	
	private Field<Object> currentForeignKey;
	private Field<Object> joinedForeignKey;
}
