package br.com.uniCad.utils.deserializers;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import br.com.uniCad.model.beans.AtendimentUnity;
import br.com.uniCad.model.beans.GroupAtendimentUnity;
import br.com.uniCad.model.dao.auxiliarData.DaoAuxiliarGroupUnityToUnity;

public class GroupAtendimentUnityDeserializer extends AbstractDeserializer<GroupAtendimentUnity>{

	@Override
	public List<GroupAtendimentUnity> fromDataBaseResult(Result<Record> result) {
		// TODO Auto-generated method stub
		List<GroupAtendimentUnity> deserializedData = new ArrayList<GroupAtendimentUnity>();
		
		for(Record current : result){
			deserializedData.add(fromDataBaseRecord(current));
		}
		
		return deserializedData;
	}

	@Override
	public GroupAtendimentUnity fromDataBaseRecord(Record record) {
		// TODO Auto-generated method stub
		String name = record.get("nome").toString();
		String idStr = record.get("id").toString();
		int id = Integer.parseInt(idStr);
		
		List<AtendimentUnity> atendimtUnityList = new ArrayList<AtendimentUnity>();
		
		DaoAuxiliarGroupUnityToUnity daoGroupUnityToUnity = new DaoAuxiliarGroupUnityToUnity();
		try {
			atendimtUnityList = daoGroupUnityToUnity.getSelfRelatedData(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GroupAtendimentUnity groupAtendimentUnity = new GroupAtendimentUnity(id,
				name,
				atendimtUnityList);
		
		return groupAtendimentUnity;
	}
	
}
