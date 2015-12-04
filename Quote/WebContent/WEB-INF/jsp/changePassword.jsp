<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container table-tapdown">
		
		<section>
		<ol><ol><ol><ol>
			<h1>Change Password</h1>
			<div class="panel panel panel-default ">
				<div class="panel-body">
								<p></p>
				<div class="row">
						
							<fieldset class="col-lg-4 col-lg-offset-4">
								<div class="form-group ">
									<label for="username">new password</label>
									<div>
										<input type="text" class="form-control" id="password"
											name="password" placeholder="new password" class="input-xlarge">
									</div>
								</div>
								
								<div class="form-group">
									<label for="password">confirm password</label>
									<div>
										<input type="password" class="form-control" id="password"
												name="j_password" placeholder="password" class="input-xlarge">
									</div>
								</div>
								
								<div class="form-group">
									<div>
										<button class="btn btn-success">Login</button>
									</div>
								</div>
							</fieldset>			
									
					<!-- end of row -->
					</div>	
						
									
				</div>
			</div>
		</ol></ol></ol></ol>
		</section>

</div>
	
	<!-- dialog modal for profile -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  					<div class="modal-dialog" role="document">
    					<div class="modal-content">
      						<div class="modal-header">
       							 <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      								  <h4 class="modal-title glyphicon glyphicon-user" id="myModalLabel">  Profile</h4>
     					 	</div>
     							 <div class="modal-body">
     							 		<div class="row">    
     							 		<div class="col-lg-4">
											<div class="thumbnail">
												<img src="<c:url value="/img/avator.png"/>" />
											</div>
										</div> 							 
       									<p class="col-lg-8 ">  First Name : <span>  ${firstName}</span></p>
       									<p class="col-lg-8 ">  Last Name : <span>  ${lastName}</span></p>
       									<p class="col-lg-8 ">  username : <span>  ${userName}</span></p>
       									</div>
       									
       							 </div>
     							 <div class="modal-footer">
        							
      							</div>
  					  </div>
 				 </div>
			</div>




