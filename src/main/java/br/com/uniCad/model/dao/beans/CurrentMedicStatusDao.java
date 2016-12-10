package br.com.uniCad.model.dao.beans;

import java.util.HashMap;
import java.util.Map;

import br.com.uniCad.exceptions.DoesntHaveInheritence;
import br.com.uniCad.model.beans.AbstractBean;
import br.com.uniCad.model.beans.CurrentMedicStatus;
import br.com.uniCad.model.dao.auxiliarData.AbstractDaoAuxiliar;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.CurrentMedicStatusDeserializer;

public class CurrentMedicStatusDao extends AbstractDaoBean<CurrentMedicStatus>{

	public CurrentMedicStatusDao() {
		super(CurrentMedicStatus.class);
	}

	@Override
	protected String getTableName() {
		return "dados_medicos_auxiliares";
	}

	@Override
	protected AbstractDeserializer<CurrentMedicStatus> getDeserializer() {
		return new CurrentMedicStatusDeserializer();
	}

	@Override
	public Map<String, String> getMapColumnToProperty() {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("tipo_sanguineo", "bloodType");
		map.put("peso", "weight");
		map.put("altura", "height");
		map.put("alergia", "allergies");
		map.put("tratamentos_atuais", "currentTreatment");
		
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

	@Override
	protected void insertRelatedTables(AbstractBean bean) {
		// TODO Auto-generated method stub
		
	}

}
