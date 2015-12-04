<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>

<head>
<meta charset="utf-8">

<title><tiles:insertAttribute name="title" /></title>
 <link type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> 

<link type="text/css"	href="${pageContext.request.contextPath}/css/material-fullpalette.css"	rel="stylesheet" />
<link type="text/css"	href="${pageContext.request.contextPath}/css/material-fullpalette.min.css"	rel="stylesheet" />
<link type="text/css"	href="${pageContext.request.contextPath}/css/material.css"	rel="stylesheet" />
<link type="text/css"	href="${pageContext.request.contextPath}/css/material.min.css"	rel="stylesheet" />
<link type="text/css"	href="${pageContext.request.contextPath}/css/ripples.css"	rel="stylesheet" />
<link type="text/css"	href="${pageContext.request.contextPath}/css/ripples.min.css"	rel="stylesheet" />
<link type="text/css"	href="${pageContext.request.contextPath}/css/roboto.css"	rel="stylesheet" />
<link type="text/css"	href="${pageContext.request.contextPath}/css/roboto.min.css"	rel="stylesheet" />
<link type="text/css"	href="${pageContext.request.contextPath}/css/custom.css"	rel="stylesheet" />
<link type="text/css"	href="${pageContext.request.contextPath}/css/spectrum.css"	rel="stylesheet" />
<link type="text/css"	href="${pageContext.request.contextPath}/css/simple-sidebar.css"	rel="stylesheet" />
<link type="text/css"	href="${pageContext.request.contextPath}/css/introjs.css"	rel="stylesheet" />
<link type="text/css"	href="${pageContext.request.contextPath}/css/sweetalert.css"	rel="stylesheet" />
	
	
	
	<script type="text/javascript"	src="${pageContext.request.contextPath}/js/material.js"></script>
	<script type="text/javascript"	src="${pageContext.request.contextPath}/js/material.min.js"></script>
	<script type="text/javascript"	src="${pageContext.request.contextPath}/js/ripples.js"></script>
	<script type="text/javascript"	src="${pageContext.request.contextPath}/js/ripples.min.js"></script>
	<script type="text/javascript"	src="${pageContext.request.contextPath}/js/spectrum.js"></script>
	<script type="text/javascript"	src="${pageContext.request.contextPath}/js/intro.js"></script>
	<script type="text/javascript"	src="${pageContext.request.contextPath}/js/customStyle.js"></script>
	<script type="text/javascript"	src="${pageContext.request.contextPath}/js/base64binary.js"></script>
	<script type="text/javascript"	src="${pageContext.request.contextPath}/js/bootbox.min.js"></script>
	<script type="text/javascript"	src="${pageContext.request.contextPath}/js/sweetalert.min.js"></script>
</head>

<body onLoad="drawCanvas();" id="index">
	
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	
	
	<script type="text/javascript">
	$(document).ready(function() {
		$.material.init();	
	});
	
	</script>
</body>
</html>