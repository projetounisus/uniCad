package br.com.uniCad.controllersRest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.beans.Pacient;
import br.com.uniCad.controllers.AbstractControllerRest;
import br.com.uniCad.dao.AbstractDao;
import br.com.uniCad.dao.PacientDao;

@Controller
@RequestMapping("/pacient")
public class ControllerRestPacient extends AbstractControllerRest<Pacient> {

	@Override
	protected AbstractDao getDao() {
		// TODO Auto-generated method stub
		return new PacientDao();
	}
	
}
