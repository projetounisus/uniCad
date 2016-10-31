package br.com.uniCad.utils;

import br.com.uniCad.beans.AbstractBean;
import br.com.uniCad.beans.Address;
import br.com.uniCad.beans.AtendimentUnity;
import br.com.uniCad.beans.Login;
import br.com.uniCad.beans.Speciality;
import br.com.uniCad.beans.SusProfessional;
import br.com.uniCad.beans.User;
import br.com.uniCad.dao.AddressDao;
import br.com.uniCad.dao.AtendimentUnityDao;
import br.com.uniCad.dao.AbstractDao;
import br.com.uniCad.dao.LoginDao;
import br.com.uniCad.dao.SpecialityDao;
import br.com.uniCad.dao.SusProfessionalDao;
import br.com.uniCad.dao.UserDao;

//FIXME: substtituir pela injeção de dependencias do Spring
public class Mapper {
	static public AbstractDao beanToDao(AbstractBean bean){
		
		AbstractDao dao = beanClassToDao(bean.getClass());
		
		return dao;
	}
	
	static public AbstractDao beanClassToDao(Class clazz){
		AbstractDao dao;
		
		if(clazz == Address.class)
			dao = new AddressDao();
		else if(clazz == Login.class)
			dao = new LoginDao();
		else if(clazz == User.class)
			dao = new UserDao();	
		else if(clazz == SusProfessional.class)
			dao = new SusProfessionalDao();
		else if(clazz == AtendimentUnity.class)
			dao = new AtendimentUnityDao();
		else if(clazz == Speciality.class)
			dao = new SpecialityDao();
		else	
			dao = null;
		
		return dao;
	}
}
