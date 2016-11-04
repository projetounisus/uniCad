package br.com.uniCad.controllersRest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.beans.AtendimentUnity;
import br.com.uniCad.controllers.AbstractControllerRest;
import br.com.uniCad.dao.AtendimentUnityDao;
import br.com.uniCad.dao.AbstractDao;

@Controller
@RequestMapping("/unity")
public class ControllerRestAtendimentUnity extends AbstractControllerRest<AtendimentUnity>{

	@Override
	protected AbstractDao getDao() {
		// TODO Auto-generated method stub
		return new AtendimentUnityDao();
	}

}
