package br.com.uniCad.model.dao.beans;

import java.util.HashMap;
import java.util.Map;

import br.com.uniCad.exceptions.DoesntHaveInheritence;
import br.com.uniCad.model.beans.AbstractBean;
import br.com.uniCad.model.beans.RegisterType;
import br.com.uniCad.model.dao.auxiliarData.AbstractDaoAuxiliar;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.RegisterTypeDeserializer;

public class RegisterTypeDao extends AbstractDaoBean<RegisterType> {

	public RegisterTypeDao() {
		super(RegisterType.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "tipo_registro";
	}

	@Override
	protected AbstractDeserializer<RegisterType> getDeserializer() {
		// TODO Auto-generated method stub
		return new RegisterTypeDeserializer();
	}

	@Override
	public Map<String, String> getMapColumnToProperty() {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("nome", "name");
		map.put("descricao", "description");
		
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
	protected void deleRelatedTables(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected AbstractDaoAuxiliar getDaoAuxiliar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void updateInheritance(AbstractBean bean) {
		// TODO Auto-generated method stub
		
	}

}
