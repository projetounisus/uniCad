package br.com.uniCad.model.dao.auxiliarData;

import br.com.uniCad.model.beans.Medic;
import br.com.uniCad.model.beans.Speciality;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.SpecialityDeserializer;

public class DaoAuxiliarMedicToSpeciality extends AbstractDaoAuxiliar<Speciality> {

	public DaoAuxiliarMedicToSpeciality() {
		super(Medic.class, Speciality.class);
		// TODO Auto-generated constructor stub
		this.currentRelationshipType = RelationshipType.manyToMany;
	}

	@Override
	protected String getRelatedTableName() {
		// TODO Auto-generated method stub
		return "especialidade";
	}

	@Override
	protected String getAuxiliarTableName() {
		// TODO Auto-generated method stub
		return "especialidade_x_medico";
	}

	@Override
	protected AbstractDeserializer<Speciality> getRelatedDeserializer() {
		// TODO Auto-generated method stub
		return new SpecialityDeserializer();
	}

	@Override
	protected String getCurrentForeignKey() {
		// TODO Auto-generated method stub
		return "medico";
	};

	@Override
	protected String getRelatedForeignKey() {
		// TODO Auto-generated method stub
		return "especialidade";
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "medico";
	}

	@Override
	protected String getRelatedFieldName() {
		// TODO Auto-generated method stub
		return "speciality";
	}
	
}
