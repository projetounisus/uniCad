package br.com.uniCad.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.uniCad.beans.AbstractBean;
import br.com.uniCad.dao.AbstractDao;

public abstract class AbstractControllerRest<T extends AbstractBean> {
	protected abstract AbstractDao getDao();
	
	@RequestMapping(name = "/", method = RequestMethod.GET)
	public ResponseEntity<List<T>> list(){
		AbstractDao dao = getDao();
		List<T> result = dao.list();
		
		ResponseEntity<List<T>> responseEntity = new ResponseEntity(result, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(name = "/", method = RequestMethod.POST)
	 public ResponseEntity insert(@RequestBody T bean){
		 AbstractDao dao = getDao();
		 
		 dao.insert(bean);
		 
		 return new ResponseEntity<T>(HttpStatus.OK);
	 }

	 @RequestMapping(name = "/", method = RequestMethod.PUT)
	 public ResponseEntity<?> update(@RequestBody T bean){
		//TODO: implementar esta jeringonça

		 return null;
	 }
}
