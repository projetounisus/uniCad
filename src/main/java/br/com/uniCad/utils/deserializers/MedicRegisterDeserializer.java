package br.com.uniCad.utils.deserializers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.beans.Address;
import br.com.uniCad.beans.AtendimentUnity;
import br.com.uniCad.beans.MedicRegister;
import br.com.uniCad.beans.Pacient;
import br.com.uniCad.beans.SusProfessional;
import br.com.uniCad.dao.AddressDao;
import br.com.uniCad.dao.AtendimentUnityDao;
import br.com.uniCad.dao.PacientDao;
import br.com.uniCad.dao.SusProfessionalDao;

public class MedicRegisterDeserializer extends AbstractDeserializer<MedicRegister>{

	@Override
	public List<MedicRegister> fromDataBaseResult(Result<Record> result) {
		List<MedicRegister> deserializedData = new ArrayList<MedicRegister>();
		
		for(Record current : result){
			deserializedData.add(fromDataBaseRecord(current));
		}
		
		return deserializedData;
	}

	@Override
	public MedicRegister fromDataBaseRecord(Record record) {
		// TODO Auto-generated method stub
		
		try {
			AddressDao addressDao = new AddressDao();
			PacientDao pacientDao = new PacientDao();
			AtendimentUnityDao atendimentUnityDao = new AtendimentUnityDao();
			SusProfessionalDao susProfessionalDao = new SusProfessionalDao();
			
			String id = record.get("id").toString();
			String addressId = record.get("local_ocorrencia").toString();
			String atendimentUnityId = record.get("uni_atendimento").toString();
			String medicId = record.get("responsaveis").toString();
			String pacientId = record.get("paciente").toString();
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			Address address = (Address)addressDao.getById(Integer.parseInt(addressId));
			AtendimentUnity atendimentUnity = (AtendimentUnity)atendimentUnityDao.getById(Integer.parseInt(atendimentUnityId));
			SusProfessional medic = (SusProfessional)susProfessionalDao.getById(Integer.parseInt(medicId));
			Pacient pacient = (Pacient)pacientDao.getById(Integer.parseInt(pacientId));
			java.util.Date beginDate = simpleDateFormat.parse(record.get("dt-inicio").toString());
			java.util.Date endDate = simpleDateFormat.parse(record.get("dt-fim").toString());
			// TODO inserir a coluna de descriação no banco para obter aqui
			//String description = record.get("descricao").toString();
			
			MedicRegister medicRegister = new MedicRegister(Integer.parseInt(id), address, beginDate, endDate, null, atendimentUnity, pacient, medic);
			
			return medicRegister;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}

}
