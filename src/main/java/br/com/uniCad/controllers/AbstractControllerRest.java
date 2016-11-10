package br.com.uniCad.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.uniCad.beans.AbstractBean;
import br.com.uniCad.dao.AbstractDao;

public abstract class AbstractControllerRest<T extends AbstractBean> {
	protected abstract AbstractDao getDao();
	//TODO: implementar dee forma correta

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<T>> list(){
		AbstractDao dao = getDao();
		List<T> result = dao.list();
		
		ResponseEntity<List<T>> responseEntity = new ResponseEntity(result, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	 public ResponseEntity insert(@RequestBody T bean){
		 AbstractDao dao = getDao();
		 
		 dao.insert(bean);
		 
		 return new ResponseEntity<T>(bean, HttpStatus.OK);
	 }

	 @RequestMapping(value = "/update", method = RequestMethod.PUT)
	 public ResponseEntity<?> update(@RequestBody T bean){
		//TODO: implementar esta jeringonça

		 return null;
	 }

	 @RequestMapping(value ="/delete", method = RequestMethod.POST)
	 public ResponseEntity delete(@RequestParam(value = "id", required = true) int id){
		 AbstractDao dao = this.getDao();
		 dao.delete(id);

		 return new ResponseEntity(HttpStatus.MULTI_STATUS.OK);
	 }
}
