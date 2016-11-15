package br.com.uniCad.controllers.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.model.beans.AtendimentUnity;
import br.com.uniCad.model.dao.AbstractDao;
import br.com.uniCad.model.dao.AtendimentUnityDao;

@Controller
@RequestMapping("/unity")
public class ControllerRestAtendimentUnity extends AbstractControllerRest<AtendimentUnity>{

	@Override
	protected AbstractDao getDao() {
		// TODO Auto-generated method stub
		return new AtendimentUnityDao();
	}

}
