package br.com.uniCad.controllers.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.model.beans.Speciality;
import br.com.uniCad.model.dao.beans.AbstractDaoBean;
import br.com.uniCad.model.dao.beans.SpecialityDao;

@Controller
@RequestMapping("/speciality")
public class ControllerRestSpeciality extends AbstractControllerRest<Speciality>{

	@Override
	protected AbstractDaoBean getDao() {
		return new SpecialityDao();
	}

}
