package br.com.uniCad.model.dao.beans;

import java.util.HashMap;
import java.util.Map;

import br.com.uniCad.exceptions.DoesntHaveInheritence;
import br.com.uniCad.model.beans.AbstractBean;
import br.com.uniCad.model.beans.Pacient;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.PacientDeserializer;

public class PacientDao extends AbstractDaoBean<Pacient>{

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

	protected void deleteInheritance(AbstractBean bean) {

	}

	@Override
	protected boolean hasInheritance() {
		return true;
	}

}
