package br.com.uniCad.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.uniCad.beans.AbstractBean;
import br.com.uniCad.beans.Medic;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.MedicDeserializer;

public class MedicDao extends AbstractDao<Medic>{

	public MedicDao() {
		super(Medic.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "medico";
	}

	@Override
	protected AbstractDeserializer<Medic> getDeserializer() {
		// TODO Auto-generated method stub
		return new MedicDeserializer();
	}

	@Override
	public Map<String, String> getMapColumnToProperty() {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("especialidade", "speciality");
		return map;
	}

	@Override
	protected int insertInheritance(AbstractBean bean) {
		// TODO Auto-generated method stub
		SusProfessionalDao susProfessionalDao = new SusProfessionalDao();
		int id = susProfessionalDao.insert(bean);
		
		return id;
	}

	@Override
	protected boolean hasInheritance() {
		// TODO Auto-generated method stub
		return true;
	}

}
