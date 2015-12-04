package com.codingz.quote.signin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SigninController {
	
	@RequestMapping(value="/signin.html", method=RequestMethod.GET)
	public void signin() {
	}
	
	//@RequestMapping(value="/signup.html", method=RequestMethod.GET)
	//public void signup() {
	//}
}
