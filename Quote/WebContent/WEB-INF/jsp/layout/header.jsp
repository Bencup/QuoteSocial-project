<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="navbar-fixed-top navbar-default fixnavbarwidth color-tap-nav">
	
	<div class="navbar-header ">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-responsive-collapse ">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
			
			<%-- <img id="logo" src="<c:url value="/img/Logo.png"/>" /> --%>
		
	</div>

	<div class="navbar-collapse collapse navbar-responsive-collapse ">
		<ul class="nav navbar-nav navbar-right ">
			<sec:authorize access="isAuthenticated()">
			
				<li><a href="${pageContext.request.contextPath}/board.html" class="navfontcolor">Board</a></li>

				<li><a href="${pageContext.request.contextPath}/convert.html" class="navfontcolor">Make Quotes</a></li>				

				<li><a href="${pageContext.request.contextPath}/myQuote.html" class="navfontcolor">My Quotes</a></li>
				
				<li><a href="${pageContext.request.contextPath}/favorBoard.html" class="navfontcolor">Favorite</a></li>

			
						
				<li><%-- <div class="btn-group">
					    <a href="javascript:void(0)" class="btn btn-success "><sec:authentication property="principal.username" /></a>
    					<a href="" data-target="#" class="btn btn-success dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></a>
    						<ul class="dropdown-menu">
      							<li><a href="" class="glyphicon glyphicon-user" data-toggle="modal" data-target="#myModal">  ViewProfile</a></li>
      							<li><a href="${pageContext.request.contextPath}/accountSetting.html" class="glyphicon glyphicon-cog"> AccountSettings</a></li>
        						<li><a class="btn btn-danger btnLogout glyphicon glyphicon-log-out"	href="<c:url value="/j_spring_security_logout"/>">  ออกจากระบบ</a></li>        						
    						</ul>
					</div>  --%>
				</li>		
												
					
				
				<sec:authorize access="hasAnyRole('ROLE_ADMIN')">		

				<li><a href="${pageContext.request.contextPath}/user.html" class="navfontcolor">User</a></li>	
	
				</sec:authorize>		
				<li><a class="btn disabled"	href="#"></a>	</li>
		
			</sec:authorize>				
		</ul>				
	<!-- end of nav-bar-right1 -->
	</div>
	<!-- end of nav-bar -->
</div>

<!-- active menu -->
<!-- <script>
	$(function() {
		function stripTrailingSlash(str) {
			if (str.substr(-1) == '/') {
				return str.substr(0, str.length - 1);
			}
			return str;
		}

		var url = window.location.pathname;
		var activePage = stripTrailingSlash(url);

		$('.nav li a').each(function() {
			var currentPage = stripTrailingSlash($(this).attr('href'));

			if (activePage == currentPage) {
				$(this).parent().addClass('active');
			}
		});
	});
	
</script> -->
<!-- active navbar ใช้คู่กับ  CSS -->
<script>
$("a[href*='" + location.pathname + "']").addClass("current");
</script>