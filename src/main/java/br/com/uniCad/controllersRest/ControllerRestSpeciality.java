package br.com.uniCad.controllersRest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.beans.Speciality;
import br.com.uniCad.dao.AbstractDao;
import br.com.uniCad.dao.SpecialityDao;

@Controller
@RequestMapping("/speciality")
public class ControllerRestSpeciality extends AbstractControllerRest<Speciality>{

	@Override
	protected AbstractDao getDao() {
		return new SpecialityDao();
	}

}
