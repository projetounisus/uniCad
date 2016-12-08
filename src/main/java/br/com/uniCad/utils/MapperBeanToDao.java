package br.com.uniCad.utils;

import br.com.uniCad.model.beans.AbstractBean;
import br.com.uniCad.model.beans.Address;
import br.com.uniCad.model.beans.AtendimentUnity;
import br.com.uniCad.model.beans.CurrentMedicStatus;
import br.com.uniCad.model.beans.Login;
import br.com.uniCad.model.beans.Medic;
import br.com.uniCad.model.beans.MedicRegister;
import br.com.uniCad.model.beans.Pacient;
import br.com.uniCad.model.beans.Speciality;
import br.com.uniCad.model.beans.SusProfessional;
import br.com.uniCad.model.beans.User;
import br.com.uniCad.model.dao.beans.AbstractDaoBean;
import br.com.uniCad.model.dao.beans.AddressDao;
import br.com.uniCad.model.dao.beans.AtendimentUnityDao;
import br.com.uniCad.model.dao.beans.CurrentMedicStatusDao;
import br.com.uniCad.model.dao.beans.LoginDao;
import br.com.uniCad.model.dao.beans.MedicDao;
import br.com.uniCad.model.dao.beans.MedicRegisterDao;
import br.com.uniCad.model.dao.beans.PacientDao;
import br.com.uniCad.model.dao.beans.SpecialityDao;
import br.com.uniCad.model.dao.beans.SusProfessionalDao;
import br.com.uniCad.model.dao.beans.UserDao;

//FIXME: substtituir pela inje��o de dependencias do Spring
public class MapperBeanToDao {
	static public AbstractDaoBean beanToDao(AbstractBean bean){
		
		AbstractDaoBean dao = beanClassToDao(bean.getClass());
		
		return dao;
	}
	
	static public AbstractDaoBean beanClassToDao(Class clazz){
		AbstractDaoBean dao;
		
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
		else if(clazz == MedicRegister.class)
			dao = new MedicRegisterDao();
		else if(clazz == Medic.class)
			dao = new MedicDao();
		else	
			dao = null;
		
		return dao;
	}

	
}
