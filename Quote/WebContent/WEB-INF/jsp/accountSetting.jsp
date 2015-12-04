<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row convert-tapdown container-narrow" id="bg-colorConvert">
<div class="col-md-3"></div>
	<div class="col-md-5">
		<div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
        <a href="${pageContext.request.contextPath}/convert.html"><img id="logo" src="<c:url value="/img/logo2.png"/>"  width="120" height="80"/></a><p></p>
        <a class="posWrapper"><img src="img/avator.png" class="img-circle" alt="Cinque Terre" width="170" height="170"></a>
            <ul class="sidebar-nav" id="nav-left-tapdown">
                
            	<li class="posWrapper2">            		
            		<label class="label-rigt-menu"> ${userName}</label>     		
            	</li>
                <li>
                     <a href="" data-toggle="modal" data-target="#myModal" id="front-size-a" class="posWrapper3">
                     <img src="img/user-icon.png" class="img-rounded" width="15" height="15">  View Profile</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/accountSetting.html" id="front-size-a" class="posWrapper3"> 
                    <img src="img/setting.png" class="img-circle" alt="Cinque Terre" width="15" height="15"> Account Setting</a>
                </li>
                <li>
                    <a href="<c:url value="/j_spring_security_logout"/>" id="front-size-a" class="posWrapper3">
                    <img src="img/logout.png" class="img-circle" alt="Cinque Terre" width="15" height="15">  Log Out</a>
                </li>
            </ul>
        </div>
    </div>
		
		<form class="form-horizontal" onsubmit="return checkForm(this);" action="editUser.html" method="post">		
			<label class="areaConvert uptofont"> Account Setting</label>
				<input type="hidden" value="${userId}" name="id" />
				<input type="hidden" value="2" name="roleId" />
				<input type="hidden" value="${userName}" name="username" />
				<input type="hidden" id="Enabled" name="Enabled" value="1" />	
					<p class="fc1">First name</p>
						<input type="text" class="form-control" id="firstname"
								name="firstname" required value="${firstName}"
								placeholder="first name" /> <label class="help-block help-inline"></label>
					<p class="fc1">Last name</p>
						<input type="text" class="form-control" id="lastname"
								name="lastname" required placeholder="lastname" value="${lastName}" /> <label
								class="help-block help-inline"></label>
					<p class="fc1">User Name</p>
						<input type="text" class="form-control"  disabled=""
								required placeholder="user name" value="${userName}" required /> <label
								class="help-block help-inline"></label>
					<p class="fc1">New Password</p>
						<input type="password" class="form-control" name="password" value="${password }"
								placeholder="new password" />
					<p class="fc1">Confirm Password</p>	
						<input type="password" class="form-control" name="c_pass"
								 placeholder="password" />
					<div class="form-actions" >
						<button class="btn btn-info glyphicon glyphicon-saved " type="submit" > เรียบร้อย</button>
					</div>
		</form>
      </div>
      
      <div class="col-md-4"></div>
      
    </div>					

<!-- dialog modal for profile -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content modalC1">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title glyphicon glyphicon-user" id="myModalLabel">
					Profile</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-lg-4">
						<div class="thumbnail">
							<img src="<c:url value="/img/avator.png"/>" />
						</div>
					</div>
					<p class="col-lg-8 ">
						First Name : <span> ${firstName}</span>
					</p>
					<p class="col-lg-8 ">
						Last Name : <span> ${lastName}</span>
					</p>
					<p class="col-lg-8 ">
						username : <span> ${userName}</span>
					</p>
				</div>

			</div>
			<div class="modal-footer"></div>
		</div>
	</div>
</div>