package br.com.uniCad.controllers.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.model.beans.User;
import br.com.uniCad.model.dao.beans.AbstractDaoBean;
import br.com.uniCad.model.dao.beans.UserDao;

@Controller
@RequestMapping("/user")
public class ControllerRestUser extends AbstractControllerRest<User>{

	@Override
	protected AbstractDaoBean getDao() {
		// TODO Auto-generated method stub
		return new UserDao();
	}
	
}
