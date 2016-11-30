package br.com.uniCad.controllers.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.model.beans.SusProfessional;
import br.com.uniCad.model.dao.beans.AbstractDaoBean;
import br.com.uniCad.model.dao.beans.SusProfessionalDao;

@Controller
@RequestMapping("/professional")
public class ControllerRestSusProfessional extends AbstractControllerRest<SusProfessional> {
	@Override
	protected AbstractDaoBean getDao() {
		// TODO Auto-generated method stub
		return new SusProfessionalDao();
	}

}
