<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row convert-tapdown container-narrow" id="bg-colorConvert">
<div class="col-md-3"></div>
	<div class="col-md-9">
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
                     <a href="" data-toggle="modal" data-target="#myModal" id="front-size-a" class="posWrapper3" >
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
		
			
			<label class="areaConvert uptofont"> Preview share</label>
			
			<div class="panel-default">
				<div class="panel-body"  >
							<input type="hidden"  value="${boardDetail.detailPost}" id="textfor" />				
				<div class="row"> 
					
					<canvas id="canvas" width="430" height="260" class="marginCanvas1"></canvas> 
					<p></p>	
					<a href="javascript:void(0)" onclick="postCanvasToFacebook()"> 
 								<img src="<c:url value="/img/share.png"/>"  width="78" height="30" class="marginCanvas2"/></a>   							 
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


<script type="text/javascript">
		
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
	

				// *************************share Canvas to facebook **********************************
var authToken;
	
 function wrapText(context, text, x, y, maxWidth, lineHeight) {
			        var words = text.split(' ');
			        var line = '';

			        for(var n = 0; n < words.length; n++) {
			          var testLine = line + words[n] + ' ';
			          var metrics = context.measureText(testLine);
			          var testWidth = metrics.width;
			          if (testWidth > maxWidth && n > 0) {
			            context.fillText(line, x, y);
			            line = words[n] + ' ';
			            y += lineHeight;
			          }
			          else {
			            line = testLine;
			          }
			        }
			        context.fillText(line, x, y);
			      }	
 
	function drawCanvas() {
				
				canvas = document.getElementById("canvas");
				context = canvas.getContext("2d");
				img = new Image();
				img.src = "bg2.jpg";
				
				img.onload = function() {
					var text = document.getElementById('textfor').value;
					context.drawImage(img, 0, 0);
					context.font = ' bold 20px quark';
					//context.fillText(text, 10, 90);
					var maxWidth = 430;
     				var lineHeight = 30;
     				var x = (canvas.width - maxWidth) / 2;
     				var y = 60;
					
					centerX = canvas.width / 2;
					//context.textAlign = 'center';
					context.font = ' bold 30px quark';
					wrapText(context, text, 10, y, maxWidth, lineHeight);
					console.log(canvas.toDataURL("image/png"));	
					
										};
				
				
			};

			function onKeyUp(e){ 
				context.drawImage(img, 0, 0);
				var topText = document.getElementById("toptext").value;
				context.fillText(topText, centerX, 90);
				var bottomText = document.getElementById("bottomtext").value;
				context.fillText(bottomText, centerX, 130);
				var bottomText = document.getElementById("lasttext").value;
				context.fillText(bottomText, centerX, 170);	
			};

			function postImageToFacebook( authToken, filename, mimeType, imageData, message )
			{
			    // this is the multipart/form-data boundary we'll use
			    var boundary = '----ThisIsTheBoundary1234567890';   
			    // let's encode our image file, which is contained in the var
			    var formData = '--' + boundary + '\r\n'
			    formData += 'Content-Disposition: form-data; name="source"; filename="' + filename + '"\r\n';
			    formData += 'Content-Type: ' + mimeType + '\r\n\r\n';
			    for ( var i = 0; i < imageData.length; ++i )
			    {
			        formData += String.fromCharCode( imageData[ i ] & 0xff );
			    }
			    formData += '\r\n';
			    formData += '--' + boundary + '\r\n';
			    formData += 'Content-Disposition: form-data; name="message"\r\n\r\n';
			    formData += message + '\r\n'
			    formData += '--' + boundary + '--\r\n';
			    
			    var xhr = new XMLHttpRequest();
			    xhr.open( 'POST', 'https://graph.facebook.com/me/photos?access_token=' + authToken, true );
			    xhr.onload = xhr.onerror = function() {
			        console.log( xhr.responseText );
			    };
			    xhr.setRequestHeader( "Content-Type", "multipart/form-data; boundary=" + boundary );
			    xhr.sendAsBinary( formData );
			};


			function postCanvasToFacebook() {
				var data = canvas.toDataURL("image/png");
				var encodedPng = data.substring(data.indexOf(',') + 1, data.length);
				var decodedPng = Base64Binary.decode(encodedPng);
				FB.getLoginStatus(function(response) {
				  if (response.status === "connected") {	
					postImageToFacebook(response.authResponse.accessToken, "quote", "image/png", decodedPng, "www.quotesocial.com");
					alert('share is succeed');
					window.location = "${pageContext.request.contextPath}/board.html";
				  } else if (response.status === "not_authorized") {
					 FB.login(function(response) {
						postImageToFacebook(response.authResponse.accessToken, "quote", "image/png", decodedPng, "www.quotesocial.com");
					 }, {scope: "publish_stream,publish_actions"});
				  } else {
					 FB.login(function(response)  { 
						postImageToFacebook(response.authResponse.accessToken, "quote", "image/png", decodedPng, "www.quotesocial.com");
					 }, {scope: "publish_stream,publish_actions"});
				  }
				 });

			};

			if ( XMLHttpRequest.prototype.sendAsBinary === undefined ) {
			    XMLHttpRequest.prototype.sendAsBinary = function(string) {
			        var bytes = Array.prototype.map.call(string, function(c) {
			            return c.charCodeAt(0) & 0xff;
			        });
			        this.send(new Uint8Array(bytes).buffer);
			    };
			};
</script>






