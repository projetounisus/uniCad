package br.com.uniCad.controllers.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.model.beans.SusProfessional;
import br.com.uniCad.model.dao.AbstractDao;
import br.com.uniCad.model.dao.SusProfessionalDao;

@Controller
@RequestMapping("/professional")
public class ControllerRestSusProfessional extends AbstractControllerRest<SusProfessional> {
	@Override
	protected AbstractDao getDao() {
		// TODO Auto-generated method stub
		return new SusProfessionalDao();
	}

}
