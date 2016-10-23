<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<script src="<c:url value="/assets/js/3rdParty/handlebars-v4.0.5.js"/>"
	type="text/javascript"></script>

<script src="<c:url value="/assets/js/pages/mainPage.js"/>"
	type="text/javascript"></script>

<link href="<c:url value="/assets/css/pages/mainPage.css"/>"
	rel="stylesheet" type="text/css" />

<div class="centered-div-horizontal">
	<div>
		<h3>Registros Recentes</h3>
	</div>
	
	<div id="registerListContainer" class="register-list-container">

		<script id="registersList" type="text/x-handlebars-template">
          {{#each register}}
            <div class="box box-primary register-container">
              <h3><span>{{nome}}</span></h3>
              <div>
                <span><h4>Responsáveis</h4></span>
                <div>
                  {{#each profissionaisResponsaveis}}
                    <span>{{this}}</span>
                  {{/each}}
                </div>

                <span><h4>Pacientes</h4></span>
                <div>
                  {{#each pacientes}}
                    <span>{{this}}</span>
                  {{/each}}
                </div>
              </div>
            </div>
          {{/	each}}
		</script>
	</div>

</div>
