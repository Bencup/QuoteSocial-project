<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/app/convert.js"></script>

<form action="convert-ans.html" method="post">
	
<!-- add Back to Top	 -->
<div class="row convert-tapdown container-narrow" id="bg-colorConvert">
	<div class="col-md-4">
	
	</div>

<div class="col-md-8">
	<div id="wrapper">			
      <!-- ***************Sidebar***************** -->
        <div id="sidebar-wrapper">
        	<a href="${pageContext.request.contextPath}/convert.html"><img id="logo" src="<c:url value="/img/logo2.png"/>"  width="120" height="75"/></a><p></p>
        	<a class="posWrapper"><img src="img/avator.png" class="img-circle" alt="Cinque Terre" width="170" height="170"></a>  
        	
            <ul class="sidebar-nav" id="nav-left-tapdown">
            	
            	</li>
            	
            	<li style="margin-top: 160px;">            		
            		<label class="label-rigt-menu"> ${userName}</label>     		
            	</li>
                <li>
                    <a href="" data-toggle="modal" data-target="#myModal" id="front-size-a" class="posWrapper3">
                    <img src="img/user-icon.png" class="img-rounded" width="20" height="20">  View Profile</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/accountSetting.html" id="front-size-a" class="posWrapper3">
                    <img src="img/setting.png" class="img-circle" alt="Cinque Terre" width="20" height="20">  Account Setting</a>
                </li>
                <li>
                    <a href="<c:url value="/j_spring_security_logout"/>" id="front-size-a" class="posWrapper3">
                    <img src="img/logout.png" class="img-circle" alt="Cinque Terre" width="20" height="20">  Log Out</a>
                </li>
            </ul>
        </div>
    </div>
    
    <!-- ************************************** Start Content here **************************** -->     
    			
			<label class="areaConvert coUpto">Convert Quote</label>
			<a href="javascript:void(0);" onclick="javascript:introJs().setOption('showProgress', true).start();" style="color:#b4b0b0;">how to use</a>
			<a style="color:#b4b0b0;" class="glyphicon glyphicon-question-sign"></a>
						
	<div class="centre">
		<div data-step="1" data-intro="let's your new Quotes, Up to you design own your special quote!">
		<p class="fontcolor2">ใส่ข้อความของคุณ</p>
            <div><input type="text" id="toptext" class="form-control" onkeyup="onKeyUp();" style=" width:450px;"> </div>
            <div><input type="text" id="bottomtext"class="form-control" onkeyup="onKeyUp();" style=" width:450px;" > </div>
            <div><input type="text" id="lasttext"class="form-control" onkeyup="onKeyUp();" style=" width:450px;" > </div>
            <input type="hidden" id="user-id" value="${userId}"/>
            <input type="hidden" id="sta-id" value="1"/>
            <input type="hidden" id="cat-id" value="3"/>
            <input type="hidden" id="cre-id" value="1"/>
		</div>
		<br/>		
	</div>
				<p></p>
			
				<label class="coUpto">Preview</label>
				<p class="fontcolor1">ภาพตัวอย่างหลังแปลงข้อความเป็นรูปภาพ</p> 
				<div data-step="2" data-intro="Choose background up to you like!">
				<p class="fontcolor1">Chang Background :
				<a id="a" href="javascript:void()">Background 1 | </a>
  				<a id="b" href="javascript:void()">Background 2 | </a>
  				<a id="c" href="javascript:void()">Background 3</a>
				</p> 
				</div>
			<div >	
				
				<div class="col-lg-4">						
					<canvas id="canvas" width="430" height="260" data-step="3" data-intro="WOWWW! This it your final of your image">Your browser does not support the canvas element.</canvas>
					<!-- <button class="btn btn-success share" onclick="postCanvasToFacebook()" type="reset" data-step="3" data-intro="Share! อย่ารอช้า รีบแชร์คำคมเด็ดๆให้เพื่อนได้อิจฉากันได้เลยยยย"> 
					 Share on facebook </button> -->
					 <a href="javascript:void(0)" class="commentConvert" onclick="postCanvasToFacebook()" data-step="4" data-intro="Share! อย่ารอช้า รีบแชร์คำคมเด็ดๆให้เพื่อนได้อิจฉากันได้เลยยยย">
 							<img src="<c:url value="/img/share2.png"/>"  width="200" height="40"></a> 														
				</div>	
			</div>	
			
			
</div>
      <div class="col-md-4"></div>
    </div>							
<a href="#" class="scrollToTop "></a>
</form>

<!-- dialog modal for profile -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content" style="background-color: #dee3e7;">
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