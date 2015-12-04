<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/app/login.js"></script>

<div class="container ">
			
<div class="row tapdownlog" style="background-color: #d1baaa;">
	<div class="col-md-1">
		<img src="<c:url value="/img/bg-inside-logo.png"/>"  width="280" height="121" class="pic-inside-logo"/>	
	</div>					
		<div class="col-md-6" id="col-tapdown-login">
						<label style="color: #866651; font-size: 40px; margin-left:170px;" class="label-login">SIGN IN</label>			
				<form class="form-horizontal" action='<c:url value='j_spring_security_check' />' method="POST">
								
								<div class="form-group ">
									<!-- <label for="username" style="color: #866651; font-size: 40px; margin-top:25px;" class="label-login">Username</label> -->
									<div>
										<input type="text" class="form-control" id="username" 
											name="j_username" placeholder="Username" Style="font-size:25px; margin-top: 70px;"class="input-xlarge">
									</div>
								</div>
								
								<div class="form-group">
									<!-- <label for="password" style="color: #866651; font-size: 40px;" class="label-login">Password</label> -->
									<div>
										<input type="password" class="form-control" id="password" Style="font-size:25px; margin-top: 30px;"
												name="j_password" placeholder="Password" class="input-xlarge">
								</div>
								</div>
								<div class="form-group">
									<div  id="button-center-login">
										<button class="btn buttonLogin">Login</button>
										<a class="buttonLogin" data-toggle="modal" data-target="#complete-dialog" href="">SIGN UP</a>
										<p class="Line-or-text" >_____ or _____</p>
										<fb:login-button perms=""  size="large" class="fb-button" autologoutlink="true">SIGN IN WITH FACEBOOK</fb:login-button>
  					                      <div id="status">
									</div>
								</div>
							
						</form>
							<div class="form-group">
								<div id="button-center-login">
					<form class="form-horizontal" onsubmit="return checkForm(this);" action="saveuser.html"  method="post">
						<div id="complete-dialog" class="modal fade" tabindex="-1">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">×</button>
										<h4 class="modal-title">Sign up</h4>
									</div>
										<div class="modal-body">
											<input type="hidden" id="Enabled" name="Enabled" value="1" /> 
											<input type="hidden" id="role_id" name="role_id" value="2" />
											<div class="form-group">
												
													<input type="text" class="form-control" id="firstname"
															name="firstname" required
															placeholder="first name" /> <label class="help-block help-inline"></label>
										
													<input type="text" class="form-control" id="lastname"
															name="lastname" required placeholder="lastname" /> <label
															class="help-block help-inline"></label>
																		
												    <input type="text" class="uname form-control" name="username" required placeholder="username" required />
												    <label class="help-block help-inline"></label>
												    <span class="status"></span>
 
										
												 	<input type="password" id="password" placeholder="password must have 6 characters containing uppercase and lowercase letters" 
												 			name="password" maxlength=10 minlength=4 class="text form-control" required/>
												   
												 	 
													<input type="password" id="c_pass" class="text form-control" maxlength=10 minlength=4 
															name="your_c_pass" placeholder="confirm password" onblur="confirmPass()" required />
											</div>
										</div>
											<div class="modal-footer">
												<div class="form-actions" >
													<button class="btn btn-success" type="submit">Sign up</button>
													<button class="btn btn-danger" type="reset">reset</button>
												</div>
											</div>
								</div>
							</div>
						<!-- end of dialog modal -->
						</div>
					</form>
									</div>
							</div>
					 <!-- <fb:login-button scope="public_profile,email"  autologoutlink="true"  onlogin="checkLoginState();"></fb:login-button> -->	
					 
					 </div>
					 
					</div>	
						<div class="col-md-5 " >
								<img src="<c:url value="/img/steav.png"/>" class="img-responsive pic-steav" alt="Cinque Terre" width="400" height="500"  />
						</div>
					
				
</div>		


<!-- ***************************** check username already to user ********************************** -->

<style type="text/css">
.flable {
    color: gray;
}

.status {
    font-family: verdana;
    font-size: 12px;
}

.uname {
    color: blue;
}
</style>