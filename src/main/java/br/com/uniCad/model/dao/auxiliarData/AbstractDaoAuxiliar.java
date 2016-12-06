package br.com.uniCad.model.dao.auxiliarData;

import static org.jooq.impl.DSL.table;
import static org.jooq.impl.DSL.field;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.impl.DSL;

import br.com.uniCad.model.beans.AbstractBean;
import br.com.uniCad.model.dao.AbstractDao;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;


public abstract class AbstractDaoAuxiliar<T extends AbstractBean> extends AbstractDao {
	
	public AbstractDaoAuxiliar(Class<?> currentBeanClass, Class<?> relatedBeanClass) {
		super(currentBeanClass);
		
		this.relatedByClass = relatedBeanClass;
	}

	public enum RelationshipType{
		oneToMany,
		manyToMany
	}
	
	protected RelationshipType currentRelationshipType;
	private Class<?> relatedByClass;
	
	public List<T> getSelfRelationedData(int id) throws Exception{
		Connection connection = this.getConnection();
		DSLContext query = DSL.using(connection, SQLDialect.MYSQL);
		
		String relatedTableName = this.getRelatedTableName();
		Table<Record> currentTable = table(this.getTableName());
		Table<Record> relatedTable = table(relatedTableName);
		
		Field<Object> currentForeignKey = field(this.getCurrentForeignKey());
		Field<Object> joinedForeignKey = field(this.getJoinedForeignKey());
		
		AbstractDeserializer<T> deserializer = this.getRelatedDeserializer();
		
		switch (this.currentRelationshipType) {
		case oneToMany:
			
			field(this.getCurrentForeignKey());
//			
//			Result<Record> resultOneToMany = query.select()
//			.from(relatedTable)
//			.innerJoin(currentTable)
//			.on(field("id").equal(currentTable.field("id")))
//			.fetch();
			
			Result<Record> resultOneToMany = query.select()
			.from(relatedTable)
			.where(joinedForeignKey.equal(id))
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
	
	private List<Integer> getRelatedKeys(Result<Record> indexes){
		List<Integer> indexesList = new ArrayList<Integer>();
		
		for(Record currentIndexRecord : indexes){
			Object currentIndex = currentIndexRecord.get(getJoinedForeignKey());
			
			indexesList.add(Integer.parseInt(currentIndex.toString()));
		}
		
		return indexesList;
	}
	
	protected abstract String getRelatedTableName();
	protected abstract String getAuxiliarTableName();
	protected abstract AbstractDeserializer<T> getRelatedDeserializer();
	
	protected abstract String getCurrentForeignKey();
	protected abstract String getJoinedForeignKey();
}
