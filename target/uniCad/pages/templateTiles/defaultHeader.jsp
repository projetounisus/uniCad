<%@ page language="java" contentType="text/html; charset=ISO-8859-15" pageEncoding="ISO-8859-15"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>

<input type="hidden" id="userId" value="${userId}"/>

<div class="mdl-layout--fixed-header" ng-controller="templateHeaderCtrl">
      <header class="custom-header mdl-layout__header mdl-layout__header--waterfall">
        
        <div class="mdl-layout-spacer"></div>
        
        <div class="mdl-layout__header-row">
          <span class="mdl-layout-title">UniCad</span>
          <span class="mdl-layout__tab">{{user.login.userName}}</span>
        </div>
      </header>
</div>

