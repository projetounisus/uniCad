package br.com.uniCad.controllers.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.model.beans.User;
import br.com.uniCad.model.dao.AbstractDao;
import br.com.uniCad.model.dao.UserDao;

@Controller
@RequestMapping("/user")
public class ControllerRestUser extends AbstractControllerRest<User>{

	@Override
	protected AbstractDao getDao() {
		// TODO Auto-generated method stub
		return new UserDao();
	}
	
}
