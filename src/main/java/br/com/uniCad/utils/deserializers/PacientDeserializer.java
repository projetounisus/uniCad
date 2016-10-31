package br.com.uniCad.utils.deserializers;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.beans.MedicRegister;
import br.com.uniCad.beans.Pacient;

public class PacientDeserializer extends AbstractDeserializer<Pacient> {

	@Override
	public List<Pacient> fromDataBaseResult(Result<Record> result) {
		List<Pacient> deserializedData = new ArrayList<Pacient>();
		
		for(Record current : result){
			deserializedData.add(fromDataBaseRecord(current));
		}
		
		return deserializedData;
	}

	@Override
	public Pacient fromDataBaseRecord(Record record) {
		// TODO Auto-generated method stub
		return null;
	}

}
