package br.com.uniCad.utils.deserializers;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.model.beans.CurrentMedicStatus;
import br.com.uniCad.model.beans.Pacient;
import br.com.uniCad.model.beans.User;
import br.com.uniCad.model.dao.beans.CurrentMedicStatusDao;
import br.com.uniCad.model.dao.beans.UserDao;

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
		String idStr = record.get("id").toString();
		String currentStatusIdStr = record.get("estado_atual").toString();
		String cns = record.get("numero_cns").toString();
		
		UserDao userDao = new UserDao();
		User partialBean = (User)userDao.getById(Integer.parseInt(idStr));
		
		CurrentMedicStatusDao currentMedicStatusDao = new CurrentMedicStatusDao();
		CurrentMedicStatus currentMedicStatus = (CurrentMedicStatus)currentMedicStatusDao.getById(Integer.parseInt(currentStatusIdStr));
		
		Pacient pacient = new Pacient(Integer.parseInt(idStr), 
				partialBean.getCompleteName(), 
				partialBean.getTelephone(), 
				partialBean.getBirthDate(), 
				partialBean.getAddress(),
				partialBean.getLogin(),
				cns,
				currentMedicStatus,
				partialBean.getGenre());
		
		return pacient;
	}

}
