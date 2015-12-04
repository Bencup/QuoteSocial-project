<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/app/user.js"></script>

<div class="row convert-tapdown container-narrow" id="bg-colorConvert">
<div class="col-md-3"></div>
	<div class="col-md-9">
		<div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
        <a href="${pageContext.request.contextPath}/convert.html"><img id="logo" src="<c:url value="/img/logo2.png"/>"  width="120" height="75"/></a><p></p>
        <a class="posWrapper"><img src="img/avator.png" class="img-circle" alt="Cinque Terre" width="170" height="170"></a>
            <ul class="sidebar-nav" id="nav-left-tapdown">
                
            	<li class="posWrapper2">            		
            		<label class="label-rigt-menu"> ${userName}</label>     		
            	</li>
                <li>
                     <a href="" data-toggle="modal" data-target="#myModal" id="front-size-a" class="posWrapper3">
                     <img src="img/user-icon.png" class="img-rounded" width="20" height="20">  View Profile</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/accountSetting.html" id="front-size-a" class="posWrapper3"> 
                    <img src="img/setting.png" class="img-circle" alt="Cinque Terre" width="20" height="20"> Account Setting</a>
                </li>
                <li>
                    <a href="<c:url value="/j_spring_security_logout"/>" id="front-size-a" class="posWrapper3">
                    <img src="img/logout.png" class="img-circle" alt="Cinque Terre" width="20" height="20">  Log Out</a>
                </li>
            </ul>
        </div>
    </div>	
			
			<label  class="areaConvert uptofont"> Management User</label>		
						
			<table class="table">
		<thead>
			<tr class="uBgTable">				
				<td></td>
				<!-- <th scope="col">id</th> -->
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Username ${user.username }</th>
				<th scope="col">Status</th>
				<th scope="col"></th>
			</tr>
		</thead>
		
		<tbody>

			<c:forEach var="user" items="${userList}">
				<tr class="success" >
					<td></td>
					<%-- <td>${user.id}</td> --%>
					<td >${user.firstname}</td>
					<td>${user.lastname}</td>
					<td>${user.username}</td>
					<td>${user.role.roleName}</td>


					<td class = "u-center"><button class="btn btn-success ok " data-toggle="modal"
							data-target="#show-${user.id }">show</button>
							
						<div id="show-${user.id }" class="modal fade" tabindex="-1">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">×</button>
										<h4 class="modal-title">Detail of User</h4>
									</div>
									<div class="modal-body">
										<p>
										<div class="form-group">
											<label>FIRST NAME : </label> ${user.firstname}
										</div>
										<div class="form-group">
											<label>LAST NAME : </label> ${user.lastname}
										</div>
										<div class="form-group">
											<label>USER NAME : </label> ${user.username}
										</div>

										<div class="form-group">
											<label>STATUS : </label> ${user.role.roleName}
										</div>
										</p>
									</div>
								</div>
							</div>
						</div>
					 <a	href=""	class="btn btn-primary editUser" data-toggle="modal" data-id="${user.id}" 
						data-target="#edit-${user.id }">edit</a> <a
						href="javascript:void(0);" class="btn btn-danger btn-deleteuser ok"
						data-id="${user.id}">delete </a></td>
						
						
						<!-- dialog edit user	 -->	
						<form class="form-horizontal" action="editUser.html" method="post">	
							<input type="hidden" value="${user.id}" name="id" />
							<input type="hidden" value="${user.role.id}" name="roleId" />
							<input type="hidden" value="${user.username}" name="username" />
							<input type="hidden" value="${user.password}" name="password" />
							<input type="hidden" id="Enabled" name="Enabled" value="1" />
						<div id="edit-${user.id}" class="modal fade" tabindex="-1">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">×</button>
										<h4 class="modal-title">แก้ไขรายชื่อผู้ใช้</h4>
									</div>
										<div class="modal-body">
										     <div class="form-group">
													<label>First name</label>
													<input type="text" class="form-control" id="firstname"
															name="firstname" required value="${user.firstname }"
															placeholder="first name" /> <label class="help-block help-inline"></label>
													<label>Last name</label>
													<input type="text" class="form-control" id="lastname"
															name="lastname" required placeholder="lastname" value="${user.lastname}" /> <label
															class="help-block help-inline"></label>
													<label>username</label>
													<input type="text" class="form-control"  disabled=""
															 required placeholder="user name" value="${user.username}" required /> <label
															class="help-block help-inline"></label>
		 	
											</div>
										</div>
											<div class="modal-footer">
												<div class="form-actions" >
													<button class="btn btn-success glyphicon glyphicon-saved" type="submit"> เรียบร้อย</button>
												</div>
											</div>
								</div>
							</div>
						</div>	
						</form>

				</tr>
			</c:forEach>
		</tbody>
	</table>
      </div>      
   </div>	
<!-- dialog modal view profile -->
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