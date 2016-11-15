package br.com.uniCad.model.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.uniCad.model.beans.AbstractBean;
import br.com.uniCad.model.beans.SusProfessional;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.SusProfessionalDeserializer;

public class SusProfessionalDao extends AbstractDao<SusProfessional> {

	public SusProfessionalDao() {
		super(SusProfessional.class);
	}

	@Override
	protected String getTableName() {
		return "profissional_sus";
	}

	@Override
	protected AbstractDeserializer<SusProfessional> getDeserializer() {
		return new SusProfessionalDeserializer();
	}

	@Override
	public Map<String, String> getMapColumnToProperty() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("unidade_atendimento", "atendimentUnity");

		return map;
	}

	@Override
	protected int insertInheritance(AbstractBean bean) {
		UserDao userDao = new UserDao();
		int id = userDao.insert(bean);
		
		return id;
	}

	protected void deleteInheritance(AbstractBean bean) {

	}

	@Override
	protected boolean hasInheritance() {
		return true;
	}

}
