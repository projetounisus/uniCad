package br.com.uniCad.model.dao.auxiliarData;

import br.com.uniCad.model.beans.AtendimentUnity;
import br.com.uniCad.model.beans.GroupAtendimentUnity;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.AtendimentUnityDeserializer;

public class DaoAuxiliarGroupUnityToUnity extends AbstractDaoAuxiliar<AtendimentUnity>{

	public DaoAuxiliarGroupUnityToUnity() {
		super(GroupAtendimentUnity.class, AtendimentUnity.class);
		// TODO Auto-generated constructor stub
		
		this.currentRelationshipType = RelationshipType.oneToMany;
	}

	@Override
	protected String getRelatedTableName() {
		// TODO Auto-generated method stub
		return  "unidade_atendimento";
	}

	@Override
	protected String getAuxiliarTableName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AbstractDeserializer<AtendimentUnity> getRelatedDeserializer() {
		// TODO Auto-generated method stub
		return new AtendimentUnityDeserializer();
	}

	@Override
	protected String getCurrentForeignKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getRelatedForeignKey() {
		// TODO Auto-generated method stub
		return "rede_unidade_atendimento";
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "rede_unidade_atendimento";
	}

	@Override
	protected String getRelatedFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

}
