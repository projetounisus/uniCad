package br.com.uniCad.utils.deserializers;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.constants.Constants.AtendimentUnityType;
import br.com.uniCad.model.beans.Address;
import br.com.uniCad.model.beans.AtendimentUnity;
import br.com.uniCad.model.beans.GroupAtendimentUnity;
import br.com.uniCad.model.beans.Medic;
import br.com.uniCad.model.beans.Professional;
import br.com.uniCad.model.dao.auxiliarData.DaoAuxiliarAtendimentUnityToMedics;
import br.com.uniCad.model.dao.beans.AddressDao;
import br.com.uniCad.model.dao.beans.GroupAtendimentUnityDao;

public class AtendimentUnityDeserializer extends AbstractDeserializer<AtendimentUnity> {

	@Override
	public List<AtendimentUnity> fromDataBaseResult(Result<Record> result) {
		// TODO Auto-generated method stub
		List<AtendimentUnity> deserializedData = new ArrayList<AtendimentUnity>();
		
		for(Record current : result){
			deserializedData.add(fromDataBaseRecord(current));
		}
		
		return deserializedData;
	}

	@Override
	public AtendimentUnity fromDataBaseRecord(Record record) {
		// TODO Auto-generated method stub
		String id = record.get("id").toString();
		String name = (String)record.get("nome");
		String addressId = record.get("endereco").toString();
		String type = record.get("tipo").toString();
		final Object idGroup = record.get("rede_unidade_atendimento");
		
		
		AddressDao addressDao = new AddressDao();
		Address address = (Address) addressDao.getById(Integer.parseInt(addressId));
		
		final GroupAtendimentUnityDao groupAtendimentUnityDao = new GroupAtendimentUnityDao();
		
		final DaoAuxiliarAtendimentUnityToMedics daoAuxilixar = new DaoAuxiliarAtendimentUnityToMedics();
		
		List<Professional> medics = new ArrayList<Professional>();
			
		AtendimentUnity atendimentUnity = new AtendimentUnity(Integer.parseInt(id), 
				address,
				name, 
				type,
				medics,
				idGroup != null ? 
					(GroupAtendimentUnity) groupAtendimentUnityDao.getById(Integer.parseInt(idGroup.toString())): 
					new GroupAtendimentUnity());
		
		return atendimentUnity;
	}

}
