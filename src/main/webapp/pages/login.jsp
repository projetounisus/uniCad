<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
    
<link href="<c:url value="/assets/css/pages/form.css"/>" rel="stylesheet" type="text/css"/>

<div class="centered-div">
	<h2>UniCad</h2>
	<form method="post" action="login">
		<input type="text" name="userName" placeholder="nome do usuário"/>
		<input type="password" name="userPassword" placeholder="senha" />
		<button type="submit" class="btn btn-primary btn-block btn-large">Logar</button>
		<span class="alert-text"><h4>${respostaLogin}</h4></span>
	</form>
</div>
-