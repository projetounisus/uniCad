package br.com.uniCad.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.uniCad.model.beans.AbstractBean;
import br.com.uniCad.model.dao.AbstractDao;
import br.com.uniCad.model.dao.MedicRegisterDao;
import br.com.uniCad.model.dao.PacientDao;
import br.com.uniCad.model.dao.UserDao;

//TODO: analizar pacote melhor para etse controller
@Controller
@RequestMapping("/medicRegisters")
public class RegisterPacientController {
	
	@RequestMapping(value = "/historic/", method = RequestMethod.GET)
	public ResponseEntity<?> getPacientRegisters(@RequestParam String paramValue, @RequestParam int paramType){
		HashMap<String, Object> params = new HashMap<String, Object>();
		
		AbstractDao relationedPacientDao;
		
		switch(paramType){
			case 1:
					relationedPacientDao = new UserDao();
					params.put("cpf", paramValue);
				break;
			case 2:
				//TODO: implementar nova coluna RG		
				return null;
			case 3:
					relationedPacientDao = new PacientDao();
					params.put("numero_cns", paramValue);
				break;
			default:
				return null;
				
		}
		
		List<AbstractBean> resultListFiltered = relationedPacientDao.getWithCustomParamSearch(params);
		AbstractBean pacient = resultListFiltered.get(0);
		MedicRegisterDao medicRegisterDao = new MedicRegisterDao();
		
		HashMap columnsToValues = new HashMap();
		columnsToValues.put("paciente", pacient.getId());
		List<AbstractBean> registersByUser = medicRegisterDao.getWithCustomParamSearch(columnsToValues);
		
		return new ResponseEntity<Object>(registersByUser, HttpStatus.OK);
	}
}
