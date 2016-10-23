package br.com.uniCad.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.uniCad.beans.AbstractBean;
import br.com.uniCad.beans.SusProfessional;
import br.com.uniCad.utils.deserializers.Deserializer;
import br.com.uniCad.utils.deserializers.SusProfessionalDeserializer;

public class SusProfessionalDao extends Dao<SusProfessional> {

	public SusProfessionalDao() {
		super(SusProfessional.class);
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "profissional_sus";
	}

	@Override
	protected Deserializer<SusProfessional> getDeserializer() {
		// TODO Auto-generated method stub
		return new SusProfessionalDeserializer();
	}

	@Override
	public Map<String, String> getMapColumnToProperty() {
		// TODO Auto-generated method stub
//		UserDao userDao = new UserDao();
//		Map<String, String> userMap = userDao.getMapColumnToProperty();
//		
		Map<String, String> map = new HashMap<String, String>();
//		map.putAll(userMap);
		map.put("unidade_atendimento", "atendimentUnity");
		map.put("crm", "crm");
		
		return map;
	}

	@Override
	protected int insertInheritance(AbstractBean bean) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		int id = userDao.insert(bean);
		
		return id;
	}

	@Override
	protected boolean hasInheritance() {
		// TODO Auto-generated method stub
		return true;
	}

}
