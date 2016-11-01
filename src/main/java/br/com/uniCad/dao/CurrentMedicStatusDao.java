package br.com.uniCad.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.uniCad.beans.AbstractBean;
import br.com.uniCad.beans.CurrentMedicStatus;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.CurrentMedicStatusDeserializer;

public class CurrentMedicStatusDao extends AbstractDao<CurrentMedicStatus>{

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

	@Override
	protected boolean hasInheritance() {
		return false;
	}

}
