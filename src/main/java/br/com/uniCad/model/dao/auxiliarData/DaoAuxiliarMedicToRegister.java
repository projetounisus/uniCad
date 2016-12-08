package br.com.uniCad.model.dao.auxiliarData;

import br.com.uniCad.model.beans.MedicRegister;
import br.com.uniCad.model.beans.SusProfessional;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.MedicRegisterDeserializer;

public class DaoAuxiliarMedicToRegister extends AbstractDaoAuxiliar<MedicRegister> {

	public DaoAuxiliarMedicToRegister() {
		super(SusProfessional.class, MedicRegister.class);
		// TODO Auto-generated constructor stub
		
		this.currentRelationshipType = RelationshipType.oneToMany;
	}

	@Override
	protected String getRelatedTableName() {
		// TODO Auto-generated method stub
		return "registro";
	}

	@Override
	protected String getAuxiliarTableName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AbstractDeserializer<MedicRegister> getRelatedDeserializer() {
		// TODO Auto-generated method stub
		return new MedicRegisterDeserializer();
	}

	@Override
	protected String getCurrentForeignKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getRelatedForeignKey() {
		// TODO Auto-generated method stub
		return "profissional_responsavel";
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "medico";
	}
	
}
