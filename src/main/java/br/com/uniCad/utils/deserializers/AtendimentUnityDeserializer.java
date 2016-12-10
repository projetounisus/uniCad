package br.com.uniCad.utils.deserializers;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.constants.Constants.AtendimentUnityType;
import br.com.uniCad.model.beans.Address;
import br.com.uniCad.model.beans.AtendimentUnity;
import br.com.uniCad.model.beans.Medic;
import br.com.uniCad.model.beans.Professional;
import br.com.uniCad.model.dao.auxiliarData.DaoAuxiliarAtendimentUnityToMedics;
import br.com.uniCad.model.dao.beans.AddressDao;

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
		
		AddressDao addressDao = new AddressDao();
		Address address = (Address) addressDao.getById(Integer.parseInt(addressId));
		
		final DaoAuxiliarAtendimentUnityToMedics daoAuxilixar = new DaoAuxiliarAtendimentUnityToMedics();
		
		List<Professional> medics = new ArrayList<Professional>();
		
//		try {
//			medics = daoAuxilixar.getSelfRelatedData(Integer.parseInt(id));
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		AtendimentUnity atendimentUnity = new AtendimentUnity(Integer.parseInt(id), 
				address,
				name, 
				type,
				medics);
		
		return atendimentUnity;
	}

}
