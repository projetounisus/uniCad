package br.com.uniCad.utils.deserializers;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.model.beans.RegisterType;

public class RegisterTypeDeserializer extends AbstractDeserializer<RegisterType> {

	@Override
	public List<RegisterType> fromDataBaseResult(Result<Record> result) {
		List<RegisterType> deserializedData = new ArrayList<RegisterType>();
		
		for(Record current : result){
			deserializedData.add(fromDataBaseRecord(current));
		}
		
		return deserializedData;
	}

	@Override
	public RegisterType fromDataBaseRecord(Record record) {
		// TODO Auto-generated method stub
		
		String id = record.get("id").toString();
		String name = record.get("nome").toString();
		String description = record.get("descricao").toString();
		
		RegisterType registerType = new RegisterType(Integer.parseInt(id), name, description);
		
		return registerType;
	}

}
