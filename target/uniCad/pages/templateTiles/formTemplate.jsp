<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page isELIgnored="false" %>

<script src="<c:url value="/assets/js/pages/templates/form.js"/>" type="text/javascript"></script>

<link href="<c:url value="/assets/css/pages/templates/formStyle.css"/>"
	rel="stylesheet" type="text/css" />

<input type="hidden" value="${idObjeto}" id="idObjeto"/>
<input type="hidden" value="${nomeObjeto}" id="nomeObjeto"/>

<div class = "box row">	
	<h2><span>${tituloForm}</span></h2>
	<tiles:insertAttribute name="formFields" value="${formFields}"/>
	<button type="button" id="confirmForm" class="btn btn-primary btn-block btn-large col-md-2">OK</button>
</div>
