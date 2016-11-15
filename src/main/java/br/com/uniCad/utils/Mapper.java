package br.com.uniCad.utils;

import br.com.uniCad.model.beans.AbstractBean;
import br.com.uniCad.model.beans.Address;
import br.com.uniCad.model.beans.AtendimentUnity;
import br.com.uniCad.model.beans.CurrentMedicStatus;
import br.com.uniCad.model.beans.Login;
import br.com.uniCad.model.beans.Pacient;
import br.com.uniCad.model.beans.Speciality;
import br.com.uniCad.model.beans.SusProfessional;
import br.com.uniCad.model.beans.User;
import br.com.uniCad.model.dao.AbstractDao;
import br.com.uniCad.model.dao.AddressDao;
import br.com.uniCad.model.dao.AtendimentUnityDao;
import br.com.uniCad.model.dao.CurrentMedicStatusDao;
import br.com.uniCad.model.dao.LoginDao;
import br.com.uniCad.model.dao.PacientDao;
import br.com.uniCad.model.dao.SpecialityDao;
import br.com.uniCad.model.dao.SusProfessionalDao;
import br.com.uniCad.model.dao.UserDao;

//FIXME: substtituir pela inje��o de dependencias do Spring
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
		else if(clazz == Pacient.class)
			dao = new PacientDao();
		else if(clazz == CurrentMedicStatus.class)
			dao = new CurrentMedicStatusDao();
		else
			dao = null;
		
		return dao;
	}
}
