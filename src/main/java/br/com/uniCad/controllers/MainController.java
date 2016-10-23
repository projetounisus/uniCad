package br.com.uniCad.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.uniCad.beans.Login;
import br.com.uniCad.beans.User;
import br.com.uniCad.dao.LoginDao;
import br.com.uniCad.dao.UserDao;

@Controller
@RequestMapping
public class MainController {
	@RequestMapping("/")
	public ModelAndView paginaLogin(HttpSession sessao){
		Object usuario = sessao.getAttribute("user");
		
		if(usuario == null)
			return new ModelAndView("login");
		
		ModelAndView mainPage = new ModelAndView("mainPage");
		//ModelAndView mainPage = ModelAndViewUtils.construirModeloPadronizado(mainPaegeModel);
		return mainPage;
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView logarUsuario(@RequestParam String userName, @RequestParam String userPassword, HttpSession sessao){
		LoginDao loginDao = new LoginDao();
		Login loginByName;
		
		try{
			loginByName = (Login)loginDao.getByUserName(userName);
		
			String userPasswordFromBase = loginByName.getUserPassword();
			
			if(userPasswordFromBase.equals(userPassword)){
				UserDao userDao = new UserDao();
				User usuario = userDao.getUserByLogin(loginByName);
				
				sessao.setAttribute("user", usuario);
				ModelAndView respostaLoginEfetuado = new ModelAndView("redirect:/");
				return respostaLoginEfetuado;
			}
			
			ModelAndView respostaLoginFalhou = new ModelAndView();
			respostaLoginFalhou.addObject("respostaLogin", "usuário ou senha incorretos");
			return respostaLoginFalhou;
		
		}catch(Exception e){
			// TODO: Não deve ser devolvido na resposta do login, 
			// deve ser tratado pelo handler de exceção global
			
			ModelAndView respostaLoginFalhou = new ModelAndView();
			respostaLoginFalhou.addObject("respostaLogin", e.getMessage());  
			return respostaLoginFalhou;
		}
	}
}
