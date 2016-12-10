package br.com.uniCad.utils.deserializers;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.model.beans.AtendimentUnity;
import br.com.uniCad.model.beans.Professional;
import br.com.uniCad.model.beans.User;
import br.com.uniCad.model.dao.beans.AtendimentUnityDao;
import br.com.uniCad.model.dao.beans.UserDao;

public class ProfessionalDeserializer extends AbstractDeserializer<Professional> {

	@Override
	public List<Professional> fromDataBaseResult(Result<Record> result) {
		List<Professional> deserializedData = new ArrayList<Professional>();
		
		for(Record current : result){
			deserializedData.add(fromDataBaseRecord(current));
		}
		
		return deserializedData;
	}

	@Override
	public Professional fromDataBaseRecord(Record record) {
		String id = record.get("id").toString();
		String atendimentUnityId = record.get("unidade_atendimento").toString();
		
		UserDao userDao = new UserDao();
		User partialBean = (User)userDao.getById(Integer.parseInt((String)id));
		
		AtendimentUnityDao atendimentUnityDao = new AtendimentUnityDao();
		AtendimentUnity antendimentUnity = (AtendimentUnity)atendimentUnityDao.getById(Integer.parseInt(atendimentUnityId));
		
		Professional susProfessional = new Professional(
				Integer.parseInt(id), 
				partialBean.getCompleteName(),
				partialBean.getTelephone(), 
				partialBean.getBirthDate(), 
				partialBean.getAddress(), 
				partialBean.getLogin(), 
				antendimentUnity,
				partialBean.getGenre());
		
		return susProfessional;
	}

}
