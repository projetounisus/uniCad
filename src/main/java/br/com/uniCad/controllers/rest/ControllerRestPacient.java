package br.com.uniCad.controllers.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.model.beans.Pacient;
import br.com.uniCad.model.dao.AbstractDao;
import br.com.uniCad.model.dao.PacientDao;

@Controller
@RequestMapping("/pacient")
public class ControllerRestPacient extends AbstractControllerRest<Pacient> {

	@Override
	protected AbstractDao getDao() {
		// TODO Auto-generated method stub
		return new PacientDao();
	}
	
}
