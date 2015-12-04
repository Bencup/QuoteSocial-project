<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form class="form-horizontal" onsubmit="return checkForm(this);"
	action="saveuserface.html" method="post">
<div class="container " >
			
<div class="row tapdownlog" style="background-color: #d1baaa;">
	<div class="col-md-1">
		<img src="<c:url value="/img/bg-inside-logo.png"/>"  width="280" height="121" class="pic-inside-logo"/>	
	</div>					
		<div class="col-md-6" id="col-tapdown-login">
						<label style="color: #866651; font-size: 40px; margin-left:170px;" class="label-login">SIGN UP</label>	
						
								<input type="hidden" id="Enabled" name="Enabled" value="1" /> <input
				type="hidden" id="role_id" name="role_id" value="2" />	
								
								<div class="form-group ">
									<div>
										<input type="text" class="form-control" id="first-name" 
											name="firstname" placeholder="First Name" Style="font-size:20px; margin-top: 40px;"class="input-xlarge">
									</div>
								</div>
								
								<div class="form-group">									
									<div>
										<input type="text" class="form-control" id="last-name" Style="font-size:20px; margin-top: 10px;"
												name="lastname" placeholder="Last Name" class="input-xlarge">
									</div>
								</div>
								
								<div class="form-group">
									<div>
										<input type="text" class="form-control" id="user-name" Style="font-size:20px; margin-top: 10px;"
												name="username" placeholder="Username" class="input-xlarge">
									</div>
								</div>
								
								<div class="form-group">
									<!-- <label for="password" style="color: #866651; font-size: 40px;" class="label-login">Password</label> -->
									<div>
										<input type="password" class="form-control" id="password" Style="font-size:20px; margin-top: 10px;"
												name="password" placeholder="New Password" class="input-xlarge">
								</div>
								</div>
								
								<div class="form-group">									
									<div>
										<input type="password" class="form-control" Style="font-size:20px; margin-top: 10px;"
												name="your_c_pass" placeholder="Confirm Password" class="input-xlarge">
									</div>
								</div>
								
								<div class="form-actions">
									<div  id="button-center-login">
										<button class="btn" type="submit" Style="font-size:20px; color: #7f5638;  margin-left:100px;">SIGN UP</button>
										<button class="btn" type="reset" Style="font-size:20px; color: #7f5638;">RESET</button>										
										<p class="Line-or-text" ></p>  					                    
									</div>
				 
					 			</div>
					 
					</div>	
						<div class="col-md-5 " >
								<img src="<c:url value="/img/albert.png"/>" class="img-responsive pic-steav" alt="Cinque Terre" width="400" height="500"  />
						</div>
					
				
		</div>		
	</div>
</form>

<script type="text/javascript">

  function checkForm(form)
  {
    if(form.username.value == "") {
      alert("Error: Username cannot be blank!");
      form.username.focus();
      return false;
    }
    re = /^\w+$/;

    if(form.password.value != "" && form.password.value == form.c_pass.value) {
      if(form.password.value.length < 6) {
        alert("Error: Password must contain at least six characters!");
        form.password.focus();
        return false;
      }
      if(form.password.value == form.username.value) {
        alert("Error: Password must be different from Username!");
        form.password.focus();
        return false;
      }
      re = /[0-9]/;
      if(!re.test(form.password.value)) {
        alert("Error: password must contain at least one number (0-9)!");
        form.password.focus();
        return false;
      }
      re = /[a-z]/;
      if(!re.test(form.password.value)) {
        alert("Error: password must contain at least one lowercase letter (a-z)!");
        form.password.focus();
        return false;
      }
      re = /[A-Z]/;
      if(!re.test(form.password.value)) {
        alert("Error: password must contain at least one uppercase letter (A-Z)!");
        form.password.focus();
        return false;
      }
      re = /^\w+$/;
      if(!re.test(form.password.value)) {
        alert("Error: password must contain only letters, numbers and underscores!");
        form.username.focus();
        return false;
      }
    } else {
      alert("Error: Please check that you've entered and confirmed your password!");
      form.password.focus();
      return false;
    }

    alert("You entered a valid password: " + form.password.value);
    return true;
  }

</script>

