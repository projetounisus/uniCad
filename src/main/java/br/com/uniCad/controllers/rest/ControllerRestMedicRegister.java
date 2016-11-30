package br.com.uniCad.controllers.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.model.beans.MedicRegister;
import br.com.uniCad.model.dao.beans.AbstractDaoBean;
import br.com.uniCad.model.dao.beans.MedicRegisterDao;

@Controller
@RequestMapping("/medicRegister")
public class ControllerRestMedicRegister extends AbstractControllerRest<MedicRegister> {

	@Override
	protected AbstractDaoBean getDao() {
		// TODO Auto-generated method stub
		return new MedicRegisterDao();
	}

}
