package br.com.uniCad.utils.deserializers;

import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.model.beans.AbstractBean;

public abstract class AbstractDeserializer<T extends AbstractBean>{
	abstract public List<T> fromDataBaseResult(Result<Record> result);
	abstract public T fromDataBaseRecord(Record record);
}
