package br.com.uniCad.model.dao.beans;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import br.com.uniCad.exceptions.DoesntHaveInheritence;
import br.com.uniCad.model.beans.AbstractBean;
import br.com.uniCad.model.beans.AtendimentUnity;
import br.com.uniCad.model.dao.auxiliarData.AbstractDaoAuxiliar;
import br.com.uniCad.model.dao.auxiliarData.DaoAuxiliarAtendimentUnityToMedics;
import br.com.uniCad.utils.deserializers.AtendimentUnityDeserializer;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import org.springframework.dao.DeadlockLoserDataAccessException;

public class AtendimentUnityDao extends AbstractDaoBean<AtendimentUnity> {

	public AtendimentUnityDao() {
		super(AtendimentUnity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "unidade_atendimento";
	}

	@Override
	protected AbstractDeserializer<AtendimentUnity> getDeserializer() {
		// TODO Auto-generated method stub
		return new AtendimentUnityDeserializer();
	}

	@Override
	public Map<String, String> getMapColumnToProperty() {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("endereco", "address");
		map.put("nome", "name");
		map.put("tipo", "unityType");
		
		return map;
	}

	@Override
	protected int insertInheritance(AbstractBean bean){
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
	protected void deleRelatedTables(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		final AbstractDaoAuxiliar daoAuxiliar = this.getDaoAuxiliar();
		daoAuxiliar.deleteRelatedData(id);
	}

	@Override
	protected AbstractDaoAuxiliar getDaoAuxiliar() {
		// TODO Auto-generated method stub
		return new DaoAuxiliarAtendimentUnityToMedics();
	}

	@Override
	protected void updateInheritance(AbstractBean bean) {
		// TODO Auto-generated method stub
		
	}

}
