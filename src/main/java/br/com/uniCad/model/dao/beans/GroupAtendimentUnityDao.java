package br.com.uniCad.model.dao.beans;

import java.util.HashMap;
import java.util.Map;

import br.com.uniCad.exceptions.DoesntHaveInheritence;
import br.com.uniCad.model.beans.AbstractBean;
import br.com.uniCad.model.beans.GroupAtendimentUnity;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.GroupAtendimentUnityDeserializer;

public class GroupAtendimentUnityDao extends AbstractDaoBean<GroupAtendimentUnity>{

	public GroupAtendimentUnityDao() {
		super(GroupAtendimentUnity.class);
	}

	@Override
	protected AbstractDeserializer<GroupAtendimentUnity> getDeserializer() {
		// TODO Auto-generated method stub
		return new GroupAtendimentUnityDeserializer();
	}

	@Override
	public Map<String, String> getMapColumnToProperty() {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("nome", "name");
		return map;
	}

	@Override
	protected int insertInheritance(AbstractBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void deleteInheritance(AbstractBean bean) throws DoesntHaveInheritence {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean hasInheritance() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "rede_unidade_atendimento";
	}

}
