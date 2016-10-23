package br.com.uniCad.controllersRest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.beans.User;
import br.com.uniCad.controllers.AbstractControllerRest;
import br.com.uniCad.dao.Dao;
import br.com.uniCad.dao.UserDao;

@Controller
@RequestMapping("/user")
public class ControllerRestUser extends AbstractControllerRest<User>{

	@Override
	protected Dao getDao() {
		// TODO Auto-generated method stub
		return new UserDao();
	}
	
}
