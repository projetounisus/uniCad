package br.com.uniCad.controllers.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.model.beans.AtendimentUnity;
import br.com.uniCad.model.dao.beans.AbstractDaoBean;
import br.com.uniCad.model.dao.beans.AtendimentUnityDao;

@Controller
@RequestMapping("/unity")
public class ControllerRestAtendimentUnity extends AbstractControllerRest<AtendimentUnity>{

	@Override
	protected AbstractDaoBean getDao() {
		// TODO Auto-generated method stub
		return new AtendimentUnityDao();
	}

}
