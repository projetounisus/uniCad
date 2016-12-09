package br.com.uniCad.controllers.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.uniCad.model.beans.AbstractBean;
import br.com.uniCad.model.dao.beans.AbstractDaoBean;

public abstract class AbstractControllerRest<T extends AbstractBean> {
	protected abstract AbstractDaoBean getDao();
	//TODO: implementar dee forma correta

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<T>> list(){
		AbstractDaoBean dao = getDao();
		List<T> result = dao.list();
		
		ResponseEntity<List<T>> responseEntity = new ResponseEntity(result, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	 public ResponseEntity insert(@RequestBody T bean){
		 AbstractDaoBean dao = getDao();
		 dao.insert(bean);
		 
		 return new ResponseEntity<T>(bean, HttpStatus.OK);
	 }

	 @RequestMapping(value = "/update", method = RequestMethod.POST)
	 public ResponseEntity<?> update(@RequestBody T bean){

		 AbstractDaoBean dao = getDao();
		 dao.update(bean);

		 return new ResponseEntity(bean, HttpStatus.OK);
	 }

	 @RequestMapping(value ="/delete", method = RequestMethod.POST)
	 public ResponseEntity delete(@RequestParam(value = "id", required = true) int id){
		 AbstractDaoBean dao = this.getDao();
		 dao.delete(id);

		 return new ResponseEntity(HttpStatus.MULTI_STATUS.OK);
	 }
}
