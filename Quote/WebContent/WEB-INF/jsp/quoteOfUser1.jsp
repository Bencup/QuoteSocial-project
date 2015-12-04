<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row convert-tapdown container-narrow" id="bg-colorConvert">
<div class="col-md-3"></div>
	<div class="col-md-9">
		<div id="wrapper">

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
		
			
			<label class="areaConvert uptofont"> Quotes Social </label><p></p>				
			<%-- <input type="text" value="${userIdformboard.id}" name="userId" /> --%>
<!-- *************************************** start in content in body ********************************************	 -->
			<div class="panel-default">
				<div class="panel-body" >										
				<div class="row rowmasony">
   				
   					<c:forEach var="boardDto" items="${boardDtoList}">
   						<c:if test="${boardDto.user.id == userIdformboard.id}">	
   					 <div class="panel panel-default">
 						<div class="panel-heading bPanelColor">
 						<div class="row">  	
									<div class="col-md-10 bColorText" id="textCanvas">						
 										${boardDto.detailBoard}
 									</div>
 									<div class="col-md-2">	
 									
 									<input type="hidden" id="cate-name" value="${boardDto.categories.categoriesName}"/>	
 									<input type="hidden" value="${boardDto.id}" name="boardId" /> 
 									<input type="hidden" value="${userId}" name="userId" id="name-id-favor"/>
									
									<c:if test="${boardDto.statusFavor==false}"> 									
 									<a href="javascript:void(0)" class="unFavorQuote" data-id="${boardDto.id }">
 									<img onclick="diffImage(this)" src="<c:url value="/img/star.png"/>"  width="20" height="20"/></a>
 									</c:if>
 									
 									<c:if test="${boardDto.statusFavor==true}">
 									
 									<a href="javascript:void(0)" class="unFavorQuote" data-id="${boardDto.id }">
 									<img onclick="diffImage(this)" src="<c:url value="/img/star2.png"/>"  width="20" height="20"/></a>
 									</c:if>


<p></p>
 									<a href="${pageContext.request.contextPath}/afterConvert.html?id=${boardDto.id}" data-id="${boardDto.id}" class="board-id-for-canvas" data-toggle="tooltip" data-placement="left" title="Share" > 
 									<img src="<c:url value="/img/f3.png"/>"  width="20" height="20"/></a>
 									
 												
									
									<script type="text/javascript">
										function diffImage(img) 
										{
										   if(img.src.match(/star2/)) img.src = "img/star.png";
							  			   else img.src = "img/star2.png";
										}
									</script> 									
 									
 										<%-- <c:if test="${userId==board.user.id}">
 											<p></p><a href="" data-id="${board.id}" data-toggle="modal" data-target="#edit-${board.id}">
											<img src="<c:url value="/img/paper.png"/>"  width="20" height="20"/></a><p></p>
 											<a href="javascript:void(0)" class="deleteQuote" data-id="${board.id }" data-toggle="tooltip" title="Delete" >
 											<img src="<c:url value="/img/trash.png"/>"  width="20" height="20"/></a>
 										</c:if> --%>
 										
 									</div> 								
 								</div>	
						</div>
 							<div class="panel-body bPanelColor">	
 									
 									<strong><a href="${pageContext.request.contextPath }/quoteOfUser.html?id=${boardDto.user.id}" class="quoteofUser bColorTextUser" data-id="${boardDto.user.id}">
 									${boardDto.user.firstname} ${boardDto.user.lastname }</a> </strong>
 									<div>
									<span class="text-muted">commented on <fmt:formatDate pattern="dd MMMM yyyy "  value="${boardDto.createDate.time}"/></span>
									</div>						
										
 								
 								 								
 							<!-- end of Panel-body -->
 							</div>
 							<div class="panel-footer bPanelColor">
 								<strong class="bTextTopic">Topic:</strong>
 								<a href="${pageContext.request.contextPath }/categoriesOfQuotes.html?id=${boardDto.categories.id}" class="quoteofUser bColorText" data-id="${boardDto.categories.id}">
 									${boardDto.categories.categoriesName}</a> 								
 															
 						
 							
								<!-- <div class="fb-share-button" data-href="http://nextzy.me/" data-layout="button"></div> -->							
								<!-- <button class="btn btn-success share" onclick="postCanvasToFace()">Share</button> -->

 							 							
 								<%-- <canvas id="canvas" width="430" height="260"  class="size-canvas canvas" style="border:1px solid black;"></canvas> --%> 			
 										
																 								
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


<!-- delete Quote -->
<script type="text/javascript">
	$(function() {
		$(".deleteQuote").click(function() {
			if (confirm("Are You Sure To Delete !")) {
				var quoteId = $(this).data("id");
				$(this).parent().parent().fadeOut('slow');

				$.ajax({
					url : "deleteQuote.html",
					data : {
						id : quoteId
					},
					type : "POST",
					success : function(data) {
						if (data == "success") {
							window.location.reload();
						} else {
							//add effect
						}

					}
				});
			}
		});
	});
</script>

<script type="text/javascript">
	$(function() {
		$(".favorQuote").click(function() {
				
			var userId=$("#name-id-favor").val();
			var quoteId = $(this).data("id");
				
			//alert(quoteId);
			//alert(userId);
				
				$.ajax({
					url : "favoriteQuote.html",
					data : {
						"quoteId": quoteId,
						"userId": userId
						
					},
					type : "POST",
					success : function(data) {
						if (data == "success") {
							window.location.reload();
						} else {
							//add effect
						}
					}
				});
			bootbox.alert("A Quote Was To Favorited");
			
		});
	});
	
	
	$(function() {
		$(".cate").click(function() {
				
			var catename = $(this).data("id");
				
			//alert(catename);
			//alert(userId);
			
			if (catename == "Success") {
				window.location = "${pageContext.request.contextPath}/favorBoard.html";				
			} 
			if(catename == "Inspiration") {
				window.location = "${pageContext.request.contextPath}/inspiration.html";
			}
			if(catename == "General") {
				window.location = "${pageContext.request.contextPath}/success.html";
			}
				
				$.ajax({
					url : "",
					data : {
						"quoteId": quoteId,
						"userId": userId
						
					},
					type : "POST",
					success : function(data) {
						if (data == "success") {
							window.location.reload();
						} else {
							//add effect
						}
					}
				});		
			
		});
	});
	
	// **************** share Canvas to facebook *****************************
	/* $(".photos").each(function(j){                      
			 
				 var image = new Image();                      
				 image.src =  "bg2.jpg";
				 //ได้ค่าท้ายสุดเลย
				 textfor = $(this).val();
				 
			 image.onload = function(){ 
    		test = document.getElementsByClassName("canvas")[j].getContext('2d');
    		test.drawImage(image,0,0, 430, 260); 
    		test.fillText(textfor,10,50);
			}               

			 });  */    	
	

</script>






