package br.com.uniCad.controllersRest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.uniCad.beans.User;
import br.com.uniCad.dao.AbstractDao;
import br.com.uniCad.dao.UserDao;

@Controller
@RequestMapping("/user")
public class ControllerRestUser extends AbstractControllerRest<User>{

	@Override
	protected AbstractDao getDao() {
		// TODO Auto-generated method stub
		return new UserDao();
	}
	
}
