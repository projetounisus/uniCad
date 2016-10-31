package br.com.uniCad.utils.deserializers;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.beans.Medic;
import br.com.uniCad.beans.Speciality;
import br.com.uniCad.beans.SusProfessional;
import br.com.uniCad.dao.SpecialityDao;
import br.com.uniCad.dao.SusProfessionalDao;

public class MedicDeserializer extends AbstractDeserializer<Medic>{

	@Override
	public List<Medic> fromDataBaseResult(Result<Record> result) {
		final List<Medic> deserialized = new ArrayList<Medic>();
		
		for(Record current : result){
			deserialized.add(this.fromDataBaseRecord(current));
		}
		
		return deserialized;
	}

	@Override
	public Medic fromDataBaseRecord(Record record) {
		// TODO Verificar se é possível obter todos os dados utilizando somente um nível acima na herança
		SusProfessionalDao susProfessionalDao = new SusProfessionalDao();
		SpecialityDao specialityDao = new SpecialityDao();
		
		String idStr = record.get("id").toString();
		String specialityIdStr = record.get("especialidade").toString();
		
		SusProfessional partialProfessionalBean = (SusProfessional)susProfessionalDao.getById(Integer.parseInt(idStr));
		Speciality speciality = (Speciality)specialityDao.getById(Integer.parseInt(specialityIdStr));
		
		Medic medic = new Medic(Integer.parseInt(idStr), 
				partialProfessionalBean.getCompleteName(),
				partialProfessionalBean.getTelephone(),
				partialProfessionalBean.getBirthDate(),
				partialProfessionalBean.getAddress(),
				partialProfessionalBean.getLogin(),
				partialProfessionalBean.getAtendimentUnity(),
				partialProfessionalBean.getCrm(),
				speciality);
		
		return medic;
	}

}
