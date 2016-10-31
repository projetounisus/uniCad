package br.com.uniCad.controllersRest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.beans.Medic;
import br.com.uniCad.controllers.AbstractControllerRest;
import br.com.uniCad.dao.AbstractDao;
import br.com.uniCad.dao.MedicDao;

@Controller
@RequestMapping("/medic")
public class ControllerRestMedic extends AbstractControllerRest<Medic>{

	@Override
	protected AbstractDao getDao() {
		// TODO Auto-generated method stub
		return new MedicDao();
	}

}
