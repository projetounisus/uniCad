package br.com.uniCad.controllers.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.model.beans.GroupAtendimentUnity;
import br.com.uniCad.model.dao.beans.AbstractDaoBean;
import br.com.uniCad.model.dao.beans.GroupAtendimentUnityDao;

@Controller
@RequestMapping("/group-atendiment-unity")
public class ControllerRestGroupAtendimentUnity extends AbstractControllerRest<GroupAtendimentUnity> {

	@Override
	protected AbstractDaoBean getDao() {
		// TODO Auto-generated method stub
		return new GroupAtendimentUnityDao();
	}

}
