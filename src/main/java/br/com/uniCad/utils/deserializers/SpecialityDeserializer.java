package br.com.uniCad.utils.deserializers;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.beans.Speciality;

public class SpecialityDeserializer extends AbstractDeserializer<Speciality>{

	@Override
	public List<Speciality> fromDataBaseResult(Result<Record> result) {
		List<Speciality> deserializedData = new ArrayList<Speciality>();
		
		for(Record current : result){
			deserializedData.add(fromDataBaseRecord(current));
		}
		
		return deserializedData;
	}

	@Override
	public Speciality fromDataBaseRecord(Record record) {
		// TODO Auto-generated method stub
		String strId = record.get("id").toString();
		String name = record.get("nome").toString();
		String description = record.get("descricao").toString();		
		
		Speciality speciality = new Speciality(Integer.parseInt(strId),
				name,
				description);
		
		return speciality;
	}

}
