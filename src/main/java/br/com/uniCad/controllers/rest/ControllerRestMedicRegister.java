package br.com.uniCad.controllers.rest;

import br.com.uniCad.model.beans.MedicRegister;
import br.com.uniCad.model.dao.AbstractDao;
import br.com.uniCad.model.dao.MedicRegisterDao;

public class ControllerRestMedicRegister extends AbstractControllerRest<MedicRegister> {

	@Override
	protected AbstractDao getDao() {
		// TODO Auto-generated method stub
		return new MedicRegisterDao();
	}

}
