// **************************** check signup ***************************************
function checkForm(form)
  {
    if(form.username.value == "") {
      alert("Error: Username cannot be blank!");
      form.username.focus();
      return false;
    }
    re = /^\w+$/;
    if(!re.test(form.username.value)) {
      alert("Error: Username must contain only letters, numbers and underscores!");
      form.username.focus();
      return false;
    }

    if(form.password.value != "" && form.password.value == form.c_pass.value) {
      if(form.password.value.length < 6) {
        alert("Error: Password must contain at least six characters!");
        form.password.focus();
        return false;
      }
      if(form.password.value == form.username.value) {
        alert("Error: Password must be different from Username!");
        form.password.focus();
        return false;
      }
      re = /[0-9]/;
      if(!re.test(form.password.value)) {
        alert("Error: password must contain at least one number (0-9)!");
        form.password.focus();
        return false;
      }
      re = /[a-z]/;
      if(!re.test(form.password.value)) {
        alert("Error: password must contain at least one lowercase letter (a-z)!");
        form.password.focus();
        return false;
      }
      re = /[A-Z]/;
      if(!re.test(form.password.value)) {
        alert("Error: password must contain at least one uppercase letter (A-Z)!");
        form.password.focus();
        return false;
      }
      re = /^\w+$/;
      if(!re.test(form.password.value)) {
        alert("Error: password must contain only letters, numbers and underscores!");
        form.username.focus();
        return false;
      }
    } else {
      alert("Error: Please check that you've entered and confirmed your password!");
      form.password.focus();
      return false;
    }

    alert("You entered a valid password: " + form.password.value);
    return true;
  }

// ***************************** check username already to used *****************************************
$(document).ready(function(){
    $(".uname").change(function(){
        var uname = $(this).val();
        if(uname.length >= 3){
            $(".status").html("<img src='img/loading.gif'><font color=gray> Checking availability...</font>");
             $.ajax({
                type: "POST",
                url: "check",
                data: "uname="+ uname,
                success: function(msg){
              	  $(".status").html(msg);
              	}
            }); 
        }
        else{

            $(".status").html("<font color=red>Username should be <b>3</b> character long.</font>");
        }

    });
});