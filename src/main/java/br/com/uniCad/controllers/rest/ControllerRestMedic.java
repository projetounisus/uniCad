package br.com.uniCad.controllers.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.model.beans.Medic;
import br.com.uniCad.model.dao.beans.AbstractDaoBean;
import br.com.uniCad.model.dao.beans.MedicDao;

@Controller
@RequestMapping("/medic")
public class ControllerRestMedic extends AbstractControllerRest<Medic>{

	@Override
	protected AbstractDaoBean getDao() {
		// TODO Auto-generated method stub
		return new MedicDao();
	}

}
