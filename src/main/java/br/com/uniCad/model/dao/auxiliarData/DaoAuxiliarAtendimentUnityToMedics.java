package br.com.uniCad.model.dao.auxiliarData;

import br.com.uniCad.model.beans.AtendimentUnity;
import br.com.uniCad.model.beans.Professional;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.ProfessionalDeserializer;

public class DaoAuxiliarAtendimentUnityToMedics extends AbstractDaoAuxiliar<Professional> {

	public DaoAuxiliarAtendimentUnityToMedics() {
		super(AtendimentUnity.class, Professional.class);
		// TODO Auto-generated constructor stub
		this.currentRelationshipType = RelationshipType.oneToMany;
	}

	@Override
	protected String getRelatedTableName() {
		// TODO Auto-generated method stub
		return "profissional_sus";
	}

	@Override
	protected String getAuxiliarTableName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AbstractDeserializer<Professional> getRelatedDeserializer() {
		// TODO Auto-generated method stub
		return new ProfessionalDeserializer();
	}

	@Override
	protected String getCurrentForeignKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getRelatedForeignKey() {
		// TODO Auto-generated method stub
		return "unidade_atendimento";
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "unidade_atendimento";
	}

	@Override
	protected String getRelatedFieldName() {
		// TODO Auto-generated method stub
		return "";
	}
	
	
}
