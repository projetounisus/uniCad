package br.com.uniCad.utils.deserializers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.model.beans.Medic;
import br.com.uniCad.model.beans.Speciality;
import br.com.uniCad.model.beans.SusProfessional;
import br.com.uniCad.model.dao.auxiliarData.DaoAuxiliarMedicToSpeciality;
import br.com.uniCad.model.dao.beans.SpecialityDao;
import br.com.uniCad.model.dao.beans.SusProfessionalDao;

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
		// TODO Verificar se � poss�vel obter todos os dados utilizando somente um n�vel acima na heran�a
		SusProfessionalDao susProfessionalDao = new SusProfessionalDao();
		SpecialityDao specialityDao = new SpecialityDao();
		
		String idStr = record.get("id").toString();
		String crm = record.get("crm").toString();
		
		SusProfessional partialProfessionalBean = (SusProfessional)susProfessionalDao.getById(Integer.parseInt(idStr));
		
		DaoAuxiliarMedicToSpeciality daoAuxiliarMedicToSpeciality = new DaoAuxiliarMedicToSpeciality();
		List<Speciality> specialitiesList = Arrays.asList(new Speciality());
		
		try {
			specialitiesList =  daoAuxiliarMedicToSpeciality.getSelfRelatedData(Integer.parseInt(idStr));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Medic medic = new Medic(Integer.parseInt(idStr), 
				partialProfessionalBean.getCompleteName(),
				partialProfessionalBean.getTelephone(),
				partialProfessionalBean.getBirthDate(),
				partialProfessionalBean.getAddress(),
				partialProfessionalBean.getLogin(),
				partialProfessionalBean.getAtendimentUnity(),
				crm,
				specialitiesList,
				partialProfessionalBean.getGenre());
		
		return medic;
	}

}
