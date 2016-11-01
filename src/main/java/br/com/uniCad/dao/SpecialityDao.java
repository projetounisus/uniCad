package br.com.uniCad.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.uniCad.beans.AbstractBean;
import br.com.uniCad.beans.Speciality;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.SpecialityDeserializer;

public class SpecialityDao extends AbstractDao<Speciality> {

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

	@Override
	protected boolean hasInheritance() {
		return false;
	}

}
