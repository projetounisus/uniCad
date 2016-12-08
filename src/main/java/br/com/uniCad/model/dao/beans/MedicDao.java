package br.com.uniCad.model.dao.beans;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import br.com.uniCad.exceptions.DoesntHaveInheritence;
import br.com.uniCad.model.beans.AbstractBean;
import br.com.uniCad.model.beans.Medic;
import br.com.uniCad.model.dao.auxiliarData.AbstractDaoAuxiliar;
import br.com.uniCad.model.dao.auxiliarData.DaoAuxiliarMedicToSpeciality;
import br.com.uniCad.utils.deserializers.AbstractDeserializer;
import br.com.uniCad.utils.deserializers.MedicDeserializer;

public class MedicDao extends AbstractDaoBean<Medic>{

	public MedicDao() {
		super(Medic.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "medico";
	}

	@Override
	protected AbstractDeserializer<Medic> getDeserializer() {
		// TODO Auto-generated method stub
		return new MedicDeserializer();
	}

	@Override
	public Map<String, String> getMapColumnToProperty() {
		Map<String, String> map = new HashMap<String, String>();
		//TODO: implemenatar mapeamento de muitos para muitos
		//map.put("especialidade", "speciality");
		map.put("crm", "crm");
		return map;
	}

	@Override
	protected int insertInheritance(AbstractBean bean) {
		// TODO Auto-generated method stub
		SusProfessionalDao susProfessionalDao = new SusProfessionalDao();
		int id = susProfessionalDao.insert(bean);
		
		return id;
	}

	protected void deleteInheritance(AbstractBean bean) {

	}

	@Override
	protected boolean hasInheritance() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void deleRelatedTables(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		AbstractDaoAuxiliar daoAuxiliar = this.getDaoAuxiliar();
		daoAuxiliar.deleteRelatedData(id);
		
	}

	@Override
	protected AbstractDaoAuxiliar getDaoAuxiliar() {
		// TODO Auto-generated method stub
		return new DaoAuxiliarMedicToSpeciality();
	}

}
