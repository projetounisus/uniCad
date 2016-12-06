package br.com.uniCad.utils.deserializers;

import java.util.List;
import java.util.Map;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.model.beans.AbstractBean;

public abstract class AbstractDeserializer<T extends AbstractBean>{
	public AbstractDeserializer(){
		
	}
	
	public AbstractDeserializer(Map<String, String> mapColumnToString){
		this.mapColumnToProperty = mapColumnToString;
	}
	
	private Map<String, String> mapColumnToProperty;
	
	abstract public List<T> fromDataBaseResult(Result<Record> result);
	abstract public T fromDataBaseRecord(Record record);
	
	public Map<String, String> getMapColumnToProperty(){
		return this.mapColumnToProperty;
	}
}
