package com.codingz.quote.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Qualifier;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.codingz.quote.iservice.IRoleService;
import com.codingz.quote.iservice.IUserService;
import com.codingz.quote.model.Role;
import com.codingz.quote.model.User;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	 @Autowired
	 RequestCache requestCache;

	 @Autowired
	 protected AuthenticationManager authenticationManager;
	
	@RequestMapping(value = "/user.html")
	public ModelAndView index() {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("user");

			List<User> userList = new ArrayList<User>(userService.findAll());
			/*Set<User> userList = new HashSet<User>(userService.findAll());*/
			mav.addObject("userList", userList);
			
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName();
			System.out.println("Youuu== " + name);
			
			User user = userService.findByUsername(name);
			mav.addObject("firstName", user.getFirstname());
			mav.addObject("lastName", user.getLastname());
			mav.addObject("userName", user.getUsername());
			mav.addObject("userId", user.getId());


			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "/signinwithface.html")
	public ModelAndView create() {
		try{
		ModelAndView model = new ModelAndView();
		model.setViewName("signinwithface");
		
		Set<Role> roleList = new HashSet<Role>(roleService.findAll());
		model.addObject("roleList", roleList);
			
		return model;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/saveuser.html", method = RequestMethod.POST)
	public String save(User user,@RequestParam(value = "role_id") Long roleId){
			
		try {
			Role role = roleService.findById(roleId);
			user.setRole(role);
			
			userService.save(user);
			
			
			return "redirect:/login.html";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	@RequestMapping(value = "/saveuserface.html", method = RequestMethod.POST)
	public String saveface(@ModelAttribute("user") User user,@RequestParam(value = "role_id") Long roleId, HttpServletRequest request ){
			
		try {
			Role role = roleService.findById(roleId);
			user.setRole(role);
			
			userService.save(user);
			
			authenticateUserAndSetSession(user, request);
			
			return "redirect:/convert.html";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//******************* by pass auto when user login ********************************************
	private void authenticateUserAndSetSession(User user, HttpServletRequest request) {
        String username = user.getUsername();
        String password = user.getPassword();
        
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        // generate session if one doesn't exist
        request.getSession();

        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }
	
	@RequestMapping(value="/editUser.html",method=RequestMethod.POST)
	public String editUser(User user,@RequestParam String firstname,
			@RequestParam String lastname,
			@RequestParam Long roleId,
			@RequestParam String username,
			@RequestParam Boolean Enabled,
			@RequestParam String password){
		try {
			Role role =roleService.findById(roleId);
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setUsername(username);
			user.setEnabled(Enabled);
			user.setRole(role);
			userService.update(user);	
			
			return "redirect:/user.html";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "/showUser/{id}.html", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable(value = "id") Long id) {
		try {
			ModelAndView mav = new ModelAndView();
			User user  = userService.findById(id);
			mav.addObject("user", user);
			mav.setViewName("showUser");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteuser.html", method = RequestMethod.POST)
	public String deleteBook(@RequestParam(value = "id") Long id) {
		try {
			User user = userService.findById(id);
			userService.delete(user);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
		
	@RequestMapping(value="/accountSetting.html")
	public ModelAndView accountSetting(){
		try {
				ModelAndView mav = new ModelAndView();
				mav.setViewName("accountSetting");
				Authentication auth = SecurityContextHolder.getContext()
						.getAuthentication();
				String name = auth.getName();
				User user = userService.findByUsername(name);
				mav.addObject("firstName", user.getFirstname());
				mav.addObject("lastName", user.getLastname());
				mav.addObject("userName", user.getUsername());
				mav.addObject("userId", user.getId());	
				mav.addObject("roleId", user.getRole());
				mav.addObject("password", user.getPassword());
				return mav;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/changePassword.html")
	public ModelAndView changePassword(){
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("changePassword");
			
			return mav;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
