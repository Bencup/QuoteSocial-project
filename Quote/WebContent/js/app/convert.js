// *********************** meto toggle wrapper *************************************
$("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });

//************************* create on Database to board Page ***********************************
$(function() {
	$(".commentConvert").click(function() {			
		var text1 = $("#toptext").val();
		var text2 = $("#bottomtext").val();
		var text3 = $("#lasttext").val();
		var userid = $("#user-id").val();
		var statusbid = $("#sta-id").val();
		var categoriesid = $("#cat-id").val();
		var credit = $("#cre-id").val();
		$.ajax({
			url : "convertTosave.html",
			data : {
				"text1": text1,
				"text2": text2,
				"text3": text3,
				"userId": userid,
				"statusb": statusbid,
				"categoriesId": categoriesid,
				"creditId": credit
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

//************************ share Canvas to facebook **********************************
var authToken;
function drawCanvas() {
	
	canvas =  $('#canvas')[0];
	context = canvas.getContext("2d");	
	img = new Image();
	img.src = "img/bg2.png";
	img.onload = function() {
		context.drawImage(img, 0, 0);
		context.fillStyle = 'black';
		centerX = canvas.width / 2;		
		context.font = ' bold 30px quark';
		context.textAlign = 'center';
	console.log(canvas.toDataURL("image/png"));		
	};
	
	$('#a').click(function(){
		canvas =  $('#canvas')[0];
		context = canvas.getContext("2d");	
		img = new Image();
		img.src = "img/bg3.png";
		img.onload = function() {
			context.drawImage(img, 0, 0);
			context.fillStyle = 'black';
			centerX = canvas.width / 2;		
			context.font = ' bold 30px quark';
			context.textAlign = 'center';
		console.log(canvas.toDataURL("image/png"));		
		};});
	
	$('#b').click(function(){
		canvas =  $('#canvas')[0];
		context = canvas.getContext("2d");	
		img = new Image();
		img.src = "img/bg2.png";
		img.onload = function() {
			context.drawImage(img, 0, 0);
			context.fillStyle = 'black';
			centerX = canvas.width / 2;		
			context.font = ' bold 30px quark';
			context.textAlign = 'center';
		console.log(canvas.toDataURL("image/png"));		
		};});
	
	$('#c').click(function(){
		canvas =  $('#canvas')[0];
		context = canvas.getContext("2d");	
		img = new Image();
		img.src = "img/bg4.png";
		img.onload = function() {
			context.drawImage(img, 0, 0);
			context.fillStyle = 'black';
			centerX = canvas.width / 2;		
			context.font = ' bold 30px quark';
			context.textAlign = 'center';
		console.log(canvas.toDataURL("image/png"));		
		};});
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