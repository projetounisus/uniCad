package br.com.uniCad.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.uniCad.beans.AbstractBean;
import br.com.uniCad.beans.AtendimentUnity;
import br.com.uniCad.utils.deserializers.AtendimentUnityDeserializer;
import br.com.uniCad.utils.deserializers.Deserializer;

public class AtendimentUnityDao extends Dao<AtendimentUnity> {

	public AtendimentUnityDao() {
		super(AtendimentUnity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "unidade_atendimento";
	}

	@Override
	protected Deserializer<AtendimentUnity> getDeserializer() {
		// TODO Auto-generated method stub
		return new AtendimentUnityDeserializer();
	}

	@Override
	public Map<String, String> getMapColumnToProperty() {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("endereco", "address");
		map.put("nome", "name");
		map.put("tipo", "type");
		
		return map;
	}

	@Override
	protected int insertInheritance(AbstractBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected boolean hasInheritance() {
		// TODO Auto-generated method stub
		return false;
	}

}
