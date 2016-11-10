<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page isELIgnored="false" %>

<div ng-controller="restCtrl">
	<div ng-model=<tiles:put name="beanName" type="string"/> >
		<div ng-repeat="bean in beans" class="mdl-card mdl-card__supporting-text mdl-shadow--2dp list-card">
			<tiles:insertAttribute  name="card-list"/>

			<div class="row-list-buttons">
						<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored"><i class="material-icons">create</i></button>
						<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored" ng-click="delete(user)"><i class="material-icons">delete</i></button>
			</div>
		</div>

		<button class="mdl-button mdl-button--fab mdl-button--colored mdl-shadow--4dp mdl-color--accent add-bean" id="add" data-target="#create-form" data-toggle="modal">
	            <i class="material-icons" role="presentation">add</i>
	            <span class="visuallyhidden">Add</span>
	  	<span class="mdl-button__ripple-container"><span class="mdl-ripple"></span></span></button>

	  	<div class="modal fade" id="create-form" role="dialog">
		    <div class="modal-dialog">
		    
		      	<div class="modal-content">
					
					<tiles:insertAttribute name="form-content"/>	      
		      
			       	<div class="modal-footer">
			          <button type="button" class="btn btn-default btn-primary" data-dismiss="modal" ng-click="createOrAdd(currentUser)">Criar</button>
			          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
			        </div>
	        	</div>
	  		</div>
	  	</div> 
  	</div>
</div>