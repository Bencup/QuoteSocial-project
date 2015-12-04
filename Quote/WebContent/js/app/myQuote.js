// ********************* Delete Quote *********************************
$(function() {
		$(".deleteQuote").click(function() {
			
				
			
			
			
			var quoteId = $(this).data("id");
			swal({   title: "Are you sure?",   
				text: "You will delete Favorite Quote!",   
				type: "warning",   showCancelButton: true,   
				confirmButtonColor: "#DD6B55",   
				confirmButtonText: "Yes, delete it!",   
				closeOnConfirm: false }, 
				function(){
					$('#forFade').fadeOut('slow');					
					$.ajax({
						url : "deleteQuote.html",
						data : {
							id : quoteId
						},
						type : "POST",
						success : function(data) {
							if (data == "success") {
								$(this).parent().parent().parent().parent().fadeOut('slow');
								swal("Deleted!", "Your imaginary file has been deleted.", "success"); 
								//window.location.reload();
							} else {
								$(this).parent().parent().parent().parent().fadeOut('slow');
								swal("Deleted!", "", "success"); 
								//window.location.reload();
							}
							window.location.reload();
						}
						
					});
					
					
				});
			
			
			
			
			
			
			
			
			
			
			
		});
	});

//*************** mouse hover to show button share facebook **************************
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