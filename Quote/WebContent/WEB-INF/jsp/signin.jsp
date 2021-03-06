
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="signin" action="<c:url value='/signin/authenticate' />" method="post">
	<div class="formInfo table-tapdown2">
  		<c:if test="${param.error eq 'bad_credentials'}">
  		<div class="error">
  			Your sign in information was incorrect.
  			Please try again or <a href="<c:url value="/signup.html" />">sign up</a>.
  		</div>
 	 	</c:if>
  		<c:if test="${param.error eq 'multiple_users'}">
  		<div class="error">
  			Multiple local accounts are connected to the provider account.
  			Try again with a different provider or with your username and password.
  		</div>
 	 	</c:if>
	</div>
	<fieldset>
		<label for="login">Username</label>
		<input id="login" name="j_username"  type="text" size="25" <c:if test="${not empty signinErrorMessage}">value="${SPRING_SECURITY_LAST_USERNAME}"</c:if> />
		<label for="password">Password</label>
		<input id="password" name="j_password" type="password" size="25" />	
	</fieldset>
	<button type="submit">Sign In</button>
	
	<p>Some test user/password pairs you may use are:</p>
	
	
	<p>Or you can <a href="<c:url value="/signup.html"/>">signup</a> with a new account.</p>
</form>

	<h3>Sign in via a provider:</h3>
	<p>(Uses SocialAuthenticationFilter)</p>

	<!-- TWITTER SIGNIN -->
    <p><a href="<c:url value="/signup.html"/>"><img src="<c:url value="/img/login-button-twitter.png"/>" border="0"/></a></p>

	<!-- FACEBOOK SIGNIN -->
    <p><a href="<c:url value="/signup.html"/>"><img src="<c:url value="/img/fb_login.png"/>" border="0"/></a><br/></p>
 
		