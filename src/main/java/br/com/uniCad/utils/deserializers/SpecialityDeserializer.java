package br.com.uniCad.utils.deserializers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.model.beans.AbstractBean;
import br.com.uniCad.model.beans.RegisterType;
import br.com.uniCad.model.beans.Speciality;
import br.com.uniCad.model.dao.RegisterTypeDao;

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
		//String TypeRegisterId = record.get("tipo_registro").toString();
		
		RegisterTypeDao registerDao = new RegisterTypeDao();
		//RegisterType registerType = (RegisterType) registerDao.getById(Integer.parseInt(TypeRegisterId));
		RegisterType registerType = new RegisterType();
		
		Speciality speciality = new Speciality(
				Integer.parseInt(strId),
				name,
				description,
				Arrays.asList(registerType));
		
		return speciality;
	}

}
