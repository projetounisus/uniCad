package br.com.uniCad.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.uniCad.beans.AbstractBean;
import br.com.uniCad.beans.MedicRegister;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.MedicRegisterDeserializer;

public class MedicRegisterDao extends AbstractDao<MedicRegister> {

	public MedicRegisterDao() {
		super(MedicRegister.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "registro";
	}

	@Override
	protected AbstractDeserializer<MedicRegister> getDeserializer() {
		// TODO Auto-generated method stub
		return new MedicRegisterDeserializer();
	}

	@Override
	public Map<String, String> getMapColumnToProperty() {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("local_ocorrencia", "atendimentUnity");
		map.put("responsible", "responsaveis");
		map.put("paciente", "pacient");
		map.put("dt_inicio", "beginDate");
		map.put("endDate", "dt_fim");
		map.put("uni_atendimento", "atendimentUnity");
		map.put("local_ocorrencia", "registerLocal");
		
		return map;
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
