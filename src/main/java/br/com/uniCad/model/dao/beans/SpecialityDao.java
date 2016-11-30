package br.com.uniCad.model.dao.beans;

import java.util.HashMap;
import java.util.Map;

import br.com.uniCad.exceptions.DoesntHaveInheritence;
import br.com.uniCad.model.beans.AbstractBean;
import br.com.uniCad.model.beans.Speciality;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.SpecialityDeserializer;

public class SpecialityDao extends AbstractDaoBean<Speciality> {

	public SpecialityDao() {
		super(Speciality.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getTableName() {
		return "especialidade";
	}

	@Override
	protected AbstractDeserializer<Speciality> getDeserializer() {
		// TODO Auto-generated method stub
		return new SpecialityDeserializer();
	}

	@Override
	public Map<String, String> getMapColumnToProperty() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("nome", "name");
		map.put("descricao", "description");
		return map;
	}

	@Override
	protected int insertInheritance(AbstractBean bean) {
		return 0;
	}

	protected void deleteInheritance(AbstractBean bean) throws DoesntHaveInheritence {
		throw new DoesntHaveInheritence();
	}

	@Override
	protected boolean hasInheritance() {
		return false;
	}

}
