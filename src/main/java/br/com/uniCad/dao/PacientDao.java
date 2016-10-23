package br.com.uniCad.dao;

import java.util.Map;

import br.com.uniCad.beans.AbstractBean;
import br.com.uniCad.beans.Pacient;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;

public class PacientDao extends AbstractDao<Pacient>{

	public PacientDao() {
		super(Pacient.class);
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "usuario_comum";
	}

	@Override
	protected AbstractDeserializer<Pacient> getDeserializer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getMapColumnToProperty() {
		// TODO Auto-generated method stub
		return null;
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
