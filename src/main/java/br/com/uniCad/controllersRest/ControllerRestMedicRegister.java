package br.com.uniCad.controllersRest;

import br.com.uniCad.beans.MedicRegister;
import br.com.uniCad.dao.AbstractDao;
import br.com.uniCad.dao.MedicRegisterDao;

public class ControllerRestMedicRegister extends AbstractControllerRest<MedicRegister> {

	@Override
	protected AbstractDao getDao() {
		// TODO Auto-generated method stub
		return new MedicRegisterDao();
	}

}
