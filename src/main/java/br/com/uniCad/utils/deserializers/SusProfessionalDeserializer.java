package br.com.uniCad.utils.deserializers;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.beans.AtendimentUnity;
import br.com.uniCad.beans.SusProfessional;
import br.com.uniCad.beans.User;
import br.com.uniCad.dao.AtendimentUnityDao;
import br.com.uniCad.dao.UserDao;

public class SusProfessionalDeserializer extends AbstractDeserializer<SusProfessional> {

	@Override
	public List<SusProfessional> fromDataBaseResult(Result<Record> result) {
		List<SusProfessional> deserializedData = new ArrayList<SusProfessional>();
		
		for(Record current : result){
			deserializedData.add(fromDataBaseRecord(current));
		}
		
		return deserializedData;
	}

	@Override
	public SusProfessional fromDataBaseRecord(Record record) {
		String id = record.get("id").toString();
		String atendimentUnityId = record.get("unidade_atendimento").toString();
		
		UserDao userDao = new UserDao();
		User partialBean = (User)userDao.getById(Integer.parseInt((String)id));
		
		AtendimentUnityDao atendimentUnityDao = new AtendimentUnityDao();
		AtendimentUnity antendimentUnity = (AtendimentUnity)atendimentUnityDao.getById(Integer.parseInt(atendimentUnityId));
		
		SusProfessional susProfessional = new SusProfessional(
				Integer.parseInt(id), 
				partialBean.getCompleteName(),
				partialBean.getTelephone(), 
				partialBean.getBirthDate(), 
				partialBean.getAddress(), 
				partialBean.getLogin(), 
				antendimentUnity);
		
		return susProfessional;
	}

}
