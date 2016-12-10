package br.com.uniCad.model.dao.beans;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import br.com.uniCad.model.beans.AbstractBean;
import br.com.uniCad.model.beans.Professional;
import br.com.uniCad.model.dao.auxiliarData.AbstractDaoAuxiliar;
import br.com.uniCad.model.dao.auxiliarData.DaoAuxiliarMedicToRegister;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.ProfessionalDeserializer;

public class SusProfessionalDao extends AbstractDaoBean<Professional> {

	public SusProfessionalDao() {
		super(Professional.class);
	}

	@Override
	protected String getTableName() {
		return "profissional_sus";
	}

	@Override
	protected AbstractDeserializer<Professional> getDeserializer() {
		return new ProfessionalDeserializer();
	}

	@Override
	public Map<String, String> getMapColumnToProperty() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("unidade_atendimento", "atendimentUnity");

		return map;
	}

	@Override
	protected int insertInheritance(AbstractBean bean) {
		UserDao userDao = new UserDao();
		int id = userDao.insert(bean);
		
		return id;
	}

	protected void deleteInheritance(AbstractBean bean) {
		final MedicDao medicDao = new MedicDao();
		medicDao.delete(bean.getId());
	}

	@Override
	protected boolean hasInheritance() {
		return true;
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
		return new DaoAuxiliarMedicToRegister();
	}

	@Override
	protected void updateInheritance(AbstractBean bean) {
		// TODO Auto-generated method stub
		final UserDao userDao = new UserDao();
		userDao.update(bean);
	}

	@Override
	protected void insertRelatedTables(AbstractBean bean) {
		// TODO Auto-generated method stub
		
	}

}
