package br.com.uniCad.controllers.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.model.beans.MedicRegister;
import br.com.uniCad.model.dao.AbstractDao;
import br.com.uniCad.model.dao.MedicRegisterDao;

@Controller
@RequestMapping("/medicRegister")
public class ControllerRestMedicRegister extends AbstractControllerRest<MedicRegister> {

	@Override
	protected AbstractDao getDao() {
		// TODO Auto-generated method stub
		return new MedicRegisterDao();
	}

}
