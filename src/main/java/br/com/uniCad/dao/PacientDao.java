package br.com.uniCad.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.uniCad.beans.AbstractBean;
import br.com.uniCad.beans.Pacient;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.PacientDeserializer;

public class PacientDao extends AbstractDao<Pacient>{

	public PacientDao() {
		super(Pacient.class);
	}

	@Override
	protected String getTableName() {
		return "usuario_comum";
	}

	@Override
	protected AbstractDeserializer<Pacient> getDeserializer() {
		return new PacientDeserializer();
	}

	@Override
	public Map<String, String> getMapColumnToProperty() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("numero_cns", "cns");
		map.put("estado_atual", "currentMedicStatus");
		
		return map;
	}

	@Override
	protected int insertInheritance(AbstractBean bean) {
		UserDao userDao = new UserDao();
		int id = userDao.insert(bean);

		return id;
	}

	@Override
	protected boolean hasInheritance() {
		return true;
	}

}
