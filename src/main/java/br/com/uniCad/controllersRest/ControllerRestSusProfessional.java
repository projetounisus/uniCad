package br.com.uniCad.controllersRest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.beans.SusProfessional;
import br.com.uniCad.controllers.AbstractControllerRest;
import br.com.uniCad.dao.AbstractDao;
import br.com.uniCad.dao.SusProfessionalDao;

@Controller
@RequestMapping("/professional")
public class ControllerRestSusProfessional extends AbstractControllerRest<SusProfessional> {
	@Override
	protected AbstractDao getDao() {
		// TODO Auto-generated method stub
		return new SusProfessionalDao();
	}

}
