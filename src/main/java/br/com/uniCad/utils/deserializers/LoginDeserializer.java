package br.com.uniCad.utils.deserializers;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.model.beans.Address;
import br.com.uniCad.model.beans.Login;

public class LoginDeserializer extends AbstractDeserializer<Login> {

	@Override
	public List<Login> fromDataBaseResult(Result<Record> result) {
		// TODO Auto-generated method stub
		List<Login> deserializedData = new ArrayList<Login>();
		
		for(Record current : result){
			deserializedData.add(fromDataBaseRecord(current));
		}
		
		return deserializedData;
	}

	@Override
	public Login fromDataBaseRecord(Record record) {
		Object id = record.get("id");
		
		Login login = new Login(Integer.parseInt(id.toString()), 
				record.get("nome_usuario").toString(),
				record.get("senha_usuario").toString());
		
		return login;
	}

}
