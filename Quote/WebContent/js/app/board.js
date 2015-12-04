// *************** mouse hover to show button share facebook **************************
var originalLeave = $.fn.popover.Constructor.prototype.leave;
			$.fn.popover.Constructor.prototype.leave = function(obj){
			  var self = obj instanceof this.constructor ?
			    obj : $(obj.currentTarget)[this.type](this.getDelegateOptions()).data('bs.' + this.type)
			  var container, timeout;

			  originalLeave.call(this, obj);

			  if(obj.currentTarget) {
			    container = $(obj.currentTarget).siblings('.popover')
			    timeout = self.timeout;
			    container.one('mouseenter', function(){
			      //We entered the actual popover – call off the dogs
			      clearTimeout(timeout);
			      //Let's monitor popover content instead
			      container.one('mouseleave', function(){
			        $.fn.popover.Constructor.prototype.leave.call(self, self);
			      });
			    })
			  }
			};
$('body').popover({ selector: '[data-popover]', trigger: 'click hover', placement: 'right', delay: {show: 0, hide: 200}});


// ********************** change different image when click "Star" *************************************
function diffImage(img) 
{
   if(img.src.match(/star2/)) img.src = "img/star.png";
	   else img.src = "img/star2.png";
}

// ********************* delete Quote *******************************
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

// ************************* favorite Quotes ****************************
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

//********************* UnFavorite Quote *******************************
$(function() {
	$(".unFavorQuote").click(function() {
			
		var userId=$("#name-id-favor").val();
		var quoteId = $(this).data("id");
			
			
			$.ajax({
				url : "unFavorite.html",
				data : {
					"quoteId": quoteId,
					"userId": userId
					
				},
				type : "POST",
				success : function(data) {
					//console.log(data);
					
					if (data == "success") {
						//alert("Has been Favorite");
						
					} else {
						//alert("Has been Favorite");
						//alert(data);
						
						
					}
				}
			});
				
	});
});

//**************** share Canvas to facebook *****************************
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

var authToken;
function drawCanvas() {
$(".photos").each(function(i){  
img = new Image();
img.src = "bg2.jpg";
textfor = $(this).val();	

img.onload = function() {
	canvas = document.getElementsByClassName("canvas");
	context = canvas[i].getContext('2d');
	context.drawImage(img, 0, 0);
	context.fillText(textfor,10,50);		
	//console.log(canvas[0]);						
	};	
});
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


function postCanvasToFace(d) {
	var i = d.getAttribute("data-id");
	//alert(i);
var data = canvas[i].toDataURL("image/png");
var encodedPng = data.substring(data.indexOf(',') + 1, data.length);
var decodedPng = Base64Binary.decode(encodedPng);
FB.getLoginStatus(function(response) {
  if (response.status === "connected") {	
	postImageToFacebook(response.authResponse.accessToken, "quote", "image/png", decodedPng, "www.quotesocial.com");
	alert('share is succeed');
	window.location.reload();
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

// ********************************************* function if js *********************************
$(function() {
	$(".cate").click(function() {
			
		var catename = $(this).data("id");
			
		//alert(catename);
		//alert(userId);
		
		if (catename == "Success") {
			window.location = "${pageContext.request.contextPath}/success.html";				
		} 
		if(catename == "Inspiration") {
			window.location = "${pageContext.request.contextPath}/inspiration.html";
		}
		if(catename == "General") {
			window.location = "${pageContext.request.contextPath}/general.html";
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