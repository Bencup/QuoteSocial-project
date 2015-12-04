<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h4><a href="<c:url value="/connect"/>">Connections</a></h4>

<h4><a href="<c:url value="/twitter"/>">Twitter</a></h4>

<ul class="menu">
	<li><a href="<c:url value="/twitter"/>">User Profile</a></li>
	<li><a href="<c:url value="/twitter/timeline"/>">Timeline</a></li>
	<li><a href="<c:url value="/twitter/friends"/>">Friends</a></li>
	<li><a href="<c:url value="/twitter/followers"/>">Followers</a></li>
	<li><a href="<c:url value="/twitter/messages"/>">Messages</a></li>
	<li><a href="<c:url value="/twitter/trends"/>">Trends</a></li>
</ul>


<h4><a href="<c:url value="/facebook"/>">Facebook</a></h4>

<ul class="menu">
	<li><a href="<c:url value="/facebook"/>">User Profile</a></li>
	<li><a href="<c:url value="/facebook/feed"/>">Feed</a></li>
	<li><a href="<c:url value="/facebook/friends"/>">Friends</a></li>
	<li><a href="<c:url value="/facebook/albums"/>">Albums</a></li>
</ul>


<h4><a href="<c:url value="/linkedin"/>">LinkedIn</a></h4>

<ul class="menu">
	<li><a href="<c:url value="/linkedin"/>">User Profile</a></li>
</ul>
