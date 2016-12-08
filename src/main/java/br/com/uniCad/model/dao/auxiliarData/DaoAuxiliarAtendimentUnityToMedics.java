package br.com.uniCad.model.dao.auxiliarData;

import br.com.uniCad.model.beans.AtendimentUnity;
import br.com.uniCad.model.beans.SusProfessional;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.SusProfessionalDeserializer;

public class DaoAuxiliarAtendimentUnityToMedics extends AbstractDaoAuxiliar<SusProfessional> {

	public DaoAuxiliarAtendimentUnityToMedics() {
		super(AtendimentUnity.class, SusProfessional.class);
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
	protected AbstractDeserializer<SusProfessional> getRelatedDeserializer() {
		// TODO Auto-generated method stub
		return new SusProfessionalDeserializer();
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

}
