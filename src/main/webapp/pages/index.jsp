<%@ page language="java" contentType="text/html; charset=ISO-8859-15" pageEncoding="ISO-8859-15"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>UniCad</title>
	<tiles:insertAttribute name="head"/>
</head>
<body ng-app="app" style="overflow: auto">
	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="content"/>

	<div ng-view>
	</div>
</body>
</html>