<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/app/favorBoard.js"></script>

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
        <!-- end of wrapper slide bar -->
    </div>
		
<!-- ****************************start content ******************************************** -->			
			<label class="areaConvert uptofont"> Favorite Quotes </label>
					
			<div class="panel-default">
				<div class="panel-body" >
										
				<div class="row rowmasony">
   					
   					<c:forEach var="favorBoard" items ="${favorBoardList }">
									<c:if test="${useId==favorBoard.user.id && favorBoard.statusFavor==true}">
   						
   					 <div class="panel panel-default" id="forFade">
   					 	<div class="panel-heading bPanelColor">
   					 		<div class="row">  	
									<div class="col-md-10 bColorText">	
													
 										<p data-popover="true" data-html=true data-content="<a href='${pageContext.request.contextPath}/afterConvert.html?id=${favorBoard.board.id}' target='blank' >
									<img src='img/f3.png' width='20' height='20'></a>">${favorBoard.board.detailPost}</p>	
 										
 																				
 									</div>
 									<div class="col-md-2">	 										 											
 											<a href="javascript:void(0)" class="deleteFavor" data-id="${favorBoard.id }" data-toggle="tooltip" data-placement="left"  title="Delete" >
 											<img src="<c:url value="/img/x.png"/>"  width="20" height="20"/></a><p></p>
 											<%-- <a href="${pageContext.request.contextPath}/afterFavor.html?id=${favorBoard.id}" data-id="${favorBoard.id}" class="board-id-for-canvas" data-toggle="tooltip" data-placement="left" title="Share" > 
 											<img src="<c:url value="/img/f.png"/>"  width="20" height="20"/></a>  --%>										
 									</div> 								
 								</div>	
   					 	</div>
 						
 							<div class="panel-body bPanelColor">
 							
 								<strong><a href="${pageContext.request.contextPath }/quoteOfUser.html?id=${favorBoard.board.user.id}" class="quoteofUser bColorTextUser" data-id="${favorBoard.board.user.id}">
 									${favorBoard.board.user.firstname} ${favorBoard.board.user.lastname }</a> </strong>					
 																		
 									<%-- <strong>${board.user.firstname} ${board.user.lastname }</strong> --%>
									<span class="text-muted"></span>
 			 								
 							<!-- end of Panel-body -->
 							</div>
 							<div class="panel-footer bPanelColor">
 							<strong class="bTextTopic">Topic:</strong>
 							<a href="${pageContext.request.contextPath }/categoriesOfQuotes.html?id=${favorBoard.board.categories.id}" class="quoteofUser bColorText" data-id="${favorBoard.board.categories.id}">
 									${favorBoard.board.categories.categoriesName}</a> 
 							</div> 							
 						</div>
					
   						</c:if>
   					</c:forEach>				
				</div>				
				</div>
			</div>	
      </div>   
    <!-- end of main row -->  
    </div>	
	<a href="#" class="scrollToTop "></a>
	
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
