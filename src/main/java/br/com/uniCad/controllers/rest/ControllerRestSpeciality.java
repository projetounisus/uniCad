package br.com.uniCad.controllers.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.model.beans.Speciality;
import br.com.uniCad.model.dao.AbstractDao;
import br.com.uniCad.model.dao.SpecialityDao;

@Controller
@RequestMapping("/speciality")
public class ControllerRestSpeciality extends AbstractControllerRest<Speciality>{

	@Override
	protected AbstractDao getDao() {
		return new SpecialityDao();
	}

}
