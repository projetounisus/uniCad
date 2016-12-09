<%@ page language="java" contentType="text/html; charset=ISO-8859-15" pageEncoding="ISO-8859-15"%>

<input type="hidden" id="userId" value="${userId}"/>

<div class="mdl-layout--fixed-header" ng-controller="templateHeaderCtrl">
      <header class="custom-header mdl-layout__header mdl-layout__header--waterfall">
        
        <div class="mdl-layout-spacer"></div>
        
        <div class="mdl-layout__header-row">
          <span class="mdl-layout-title">UniCad</span>
          <span class="mdl-layout__tab user-header">{{user.login.userName}}</span>
          
          <span class="mdl-layout-title">{{loggedUser}}</span>
        </div>
        
      </header>
</div>

