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
import br.com.uniCad.model.beans.MedicRegister;
import br.com.uniCad.model.beans.Pacient;
import br.com.uniCad.model.beans.User;
import br.com.uniCad.model.dao.AbstractDao;
import br.com.uniCad.model.dao.MedicRegisterDao;
import br.com.uniCad.model.dao.PacientDao;
import br.com.uniCad.model.dao.UserDao;

//TODO: analizar pacote melhor para etse controller
@Controller
@RequestMapping("/medicRegisters")
public class RegisterPacientController {
	
	public class RegisterPacientDto{
		public User pacient;
		public List<MedicRegister> registers;
		
		public User getPacient() {
			return pacient;
		}
		public void setPacient(User pacient) {
			this.pacient = pacient;
		}
		public List<MedicRegister> getRegisters() {
			return registers;
		}
		public void setRegisters(List<MedicRegister> registers) {
			this.registers = registers;
		}
		
		public RegisterPacientDto(User pacient, List<MedicRegister> registers) {
			super();
			this.pacient = pacient;
			this.registers = registers;
		}
	}
	
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
		List<MedicRegister> registersByUser = medicRegisterDao.getWithCustomParamSearch(columnsToValues);
		
		RegisterPacientDto responseDto = new RegisterPacientDto((User)pacient, registersByUser);
		
		return new ResponseEntity<Object>(responseDto, HttpStatus.OK);
	}
}
