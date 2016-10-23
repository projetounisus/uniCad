package br.com.uniCad.utils.deserializers;

import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.beans.AbstractBean;

public abstract class Deserializer<T extends AbstractBean>{
	abstract public List<T> fromDataBaseResult(Result<Record> result);
	abstract public T fromDataBaseRecord(Record record);
}
