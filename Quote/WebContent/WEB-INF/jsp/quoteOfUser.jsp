<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US" scope="session"/> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 


<script type="text/javascript"	src="${pageContext.request.contextPath}/js/app/board.js"></script>
<div class="row convert-tapdown container-narrow" id="bg-colorConvert">
<div class="col-md-3"></div>
	<div class="col-md-9">
		<div id="wrapper" class="bgBrown">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
        <a href="${pageContext.request.contextPath}/board.html"><img id="logo" src="<c:url value="/img/logo2.png"/>"  width="120" height="75"/></a><p></p>
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
		
  <!-- *************************************content in body this here ************************************************************ -->	
			
			<label class="areaConvert uptofont"></label><p></p>					
 			
			<div class="panel-default">
				<div class="panel-body" >
										
				<div class="row rowmasony">
				
				<c:forEach var="boardDto" items="${boardDtoList}">
					<c:if test="${boardDto.user.id == userIdformboard.id}">	
   					 
   					 <div class="panel panel-default">
 						<div class="panel-heading bPanelColor">
 						<div class="row">  	
									<div class="col-md-10 bColorText">		
																
									<p data-popover="true" data-html=true data-content="<a href='${pageContext.request.contextPath}/afterConvert.html?id=${boardDto.id}' target='blank' >
									<img src='img/f3.png' width='20' height='20'></a>">${boardDto.detailBoard}</p>	
									<%-- <c:if test="${board.creditAuthor.creditAuthorName != null}"> Author: ${board.creditAuthor.creditAuthorName} </c:if> --%>				
		
 									</div>
 									<div class="col-md-2">	
 									
 									<input type="hidden" id="cate-name" value="${boardDto.categories.categoriesName}"/>	
 									<input type="hidden" value="${boardDto.id}" name="boardId" /> 
 									<input type="hidden" value="${userId}" name="userId" id="name-id-favor"/>
									<%-- <a href="javascript:void(0)" class="favorQuote" data-id="${board.id }" data-toggle="tooltip" data-placement="left" title="Favorite" >
 									<img onclick="diffImage(this)" src="<c:url value="/img/star.png"/>"  width="20" height="20"/></a><p></p> --%>
 									
 									
 									<c:if test="${boardDto.statusFavor==false}"> 									
 									<a href="javascript:void(0)" class="unFavorQuote" data-id="${boardDto.id }">
 									<img onclick="diffImage(this)" src="<c:url value="/img/star.png"/>"  width="20" height="20"/></a>
 									</c:if>
 									
 									<c:if test="${boardDto.statusFavor==true}">
 									
 									<a href="javascript:void(0)" class="unFavorQuote" data-id="${boardDto.id }">
 									<img onclick="diffImage(this)" src="<c:url value="/img/star2.png"/>"  width="20" height="20"/></a>
 									</c:if>
 							    									
 									 										
 									</div> 								
 								</div>	
						</div>
 							<div class="panel-body bPanelColor">	
 									
 									<strong><a href="${pageContext.request.contextPath }/quoteOfUser.html?id=${boardDto.user.id}" class="quoteofUser bColorTextUser" data-id="${boardDto.user.id}">
 									${boardDto.user.firstname} ${boardDto.user.lastname }</a> </strong>								
 									
 									
 									<%-- <strong>${board.user.firstname} ${board.user.lastname }</strong> --%>
									<span class="text-muted">commented   
									<abbr class="timeago" title=" <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"  value="${boardDto.createDate.time}"/> "></abbr>
									</span>	
									<p></p>																				
	
 							<!-- end of Panel-body -->
 							</div>
 							<div class="panel-footer bPanelColor">
 								<strong class="bTextTopic">Topic:</strong> 									
 									<a href="${pageContext.request.contextPath }/categoriesOfQuotes.html?id=${boardDto.categories.id}" class="quoteofUser bColorText" data-id="${boardDto.categories.id}" >
 									${boardDto.categories.categoriesName}</a>		 							
								<!-- <div class="fb-share-button" data-href="http://nextzy.me/" data-layout="button"></div> -->				
								<%-- <canvas id="canvas" width="430" height="260"  class="size-canvas canvas" style="border:1px solid black;"></canvas> --%> 														 								
 							</div> 								
 						</div>
 						</c:if>
					</c:forEach>   
   					
   					<%-- <c:forEach var="board" items="${boardList}">
   					 
   					 <div class="panel panel-default">
 						<div class="panel-heading bPanelColor">
 						<div class="row">  	
									<div class="col-md-10 bColorText">		
																
									<p data-popover="true" data-html=true data-content="<a href='${pageContext.request.contextPath}/afterConvert.html?id=${board.id}' target='blank' >
									<img src='img/f3.png' width='20' height='20'></a>">${board.detailPost}</p>	
									<c:if test="${board.creditAuthor.creditAuthorName != null}"> Author: ${board.creditAuthor.creditAuthorName} </c:if>				
		
 									</div>
 									<div class="col-md-2">	
 									
 									<input type="hidden" id="cate-name" value="${board.categories.categoriesName}"/>	
 									<input type="hidden" value="${board.id}" name="boardId" /> 
 									<input type="hidden" value="${userId}" name="userId" id="name-id-favor"/>
									<a href="javascript:void(0)" class="favorQuote" data-id="${board.id }" data-toggle="tooltip" data-placement="left" title="Favorite" >
 									<img onclick="diffImage(this)" src="<c:url value="/img/star.png"/>"  width="20" height="20"/></a><p></p>
 									
 									
 									<c:if test="${favorBoard}"></c:if>
 									
 									<a href="javascript:void(0)" class="unFavorQuote" data-id="${board.id }">
 									<img onclick="diffImage(this)" src="<c:url value="/img/star.png"/>"  width="20" height="20"/></a>
 							    									
 									 										
 									</div> 								
 								</div>	
						</div>
 							<div class="panel-body bPanelColor">	
 									
 									<strong><a href="${pageContext.request.contextPath }/quoteOfUser.html?id=${board.user.id}" class="quoteofUser bColorTextUser" data-id="${board.user.id}">
 									${board.user.firstname} ${board.user.lastname }</a> </strong>								
 									
 									
 									<strong>${board.user.firstname} ${board.user.lastname }</strong>
									<span class="text-muted">commented   
									<abbr class="timeago" title=" <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"  value="${board.createDate.time}"/> "></abbr>
									</span>	
									<p></p>					 															
																								

										
 								
 								<!-- dialog for edit -->
								<form class="form-horizontal" action="editMyQuoteFromBoard.html" method="post">
									<input type="hidden" value="${board.id}" name="id" />
									<input type="hidden" value="${board.user.id}" name="user_id" />
									<input type="hidden" value="${board.categories.id }" name="categoriesId" />
									<input type="hidden" value="${board.creditAuthor.id }" name="creditAuthorId" />
									<input type="hidden" value="${board.statusBoard.id }" name="statusBoardId" />
									<input type="hidden" value="${board.createDate }" name="createDate" id="createDate"/>
									<div id="edit-${board.id}" class="modal fade" tabindex="-1">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">×</button>
													<h4 class="modal-title"></h4>
												</div>
													<div class="modal-body">							
							<div class="form-group">
								<label  for="name">Edit Your Quote</label>
									<div class="controls">
										<input type="text" class="form-control photos" id="detailPost" value="${board.detailPost}" name="detailPost"  required/>
											<label class="help-block help-inline"></label>
									</div>
							</div>
																		
													</div>
													<div class="modal-footer">
													
													<div class="form-actions">
														<button class="btn btn-success glyphicon glyphicon-saved" type="submit"> เรียบร้อย</button>
														</div>	
												
											</div>
											</div>
										</div>
									<!-- end of dailog for edit -->
									</div>
								</form>	
 								
 							<!-- end of Panel-body -->
 							</div>
 							<div class="panel-footer bPanelColor">
 								<strong class="bTextTopic">Topic:</strong> 									
 									<a href="${pageContext.request.contextPath }/categoriesOfQuotes.html?id=${board.categories.id}" class="quoteofUser bColorText" data-id="${board.categories.id}" >
 									${board.categories.categoriesName}</a>		 							
								<!-- <div class="fb-share-button" data-href="http://nextzy.me/" data-layout="button"></div> -->				
								<canvas id="canvas" width="430" height="260"  class="size-canvas canvas" style="border:1px solid black;"></canvas> 														 								
 							</div> 								
 						</div>
					</c:forEach>    --%> 					 
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