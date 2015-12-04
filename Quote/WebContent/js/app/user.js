$(function() {
		$(".btn-deleteuser").click(function() {
			
			bootbox.confirm("Are you sure?", function(result) {    
                if (result) {
                	
                	
    				var userId = $(this).data("id");
    				$(this).parent().parent().fadeOut('slow');

    				$.ajax({
    					url : "deleteuser.html",
    					data : {
    						id : userId
    					},
    					type : "POST",
    					success : function(data) {
    						if (data == "success") {
    							window.location.reload();
    						} else {
    							window.location.reload();
    						}

    					}
    				});
                          
                }    
            });
			
				});
			
		});