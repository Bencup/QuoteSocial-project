/*package com.codingz.quote.signup;

import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import com.codingz.quote.model.User;
import com.codingz.quote.model.UserRepository;
import com.codingz.quote.model.UsernameAlreadyInUseException;
import com.codingz.quote.message.Message;
import com.codingz.quote.message.MessageType;
import com.codingz.quote.signin.SignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
public class SignupController {

	//private final AccountRepository accountRepository;
	private final UserRepository userRepository;
	private final ProviderSignInUtils providerSignInUtils;

	@Inject
	public SignupController(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.providerSignInUtils = new ProviderSignInUtils();
	}

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public SignupForm signupForm(WebRequest request) {
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
		if (connection != null) {
			request.setAttribute("message", new Message(MessageType.INFO, "Your " + StringUtils.capitalize(connection.getKey().getProviderId()) + " account is not associated with a Spring Social Showcase account. If you're new, please sign up."), WebRequest.SCOPE_REQUEST);
			return SignupForm.fromProviderUser(connection.fetchUserProfile());
		} else {
			return new SignupForm();
		}
	}

	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@Valid SignupForm form, BindingResult formBinding, WebRequest request) {
		if (formBinding.hasErrors()) {
			return null;
		}
		
		User user = createAccount(form, formBinding);
		if (user != null) {
			SignInUtils.signin(user.getUsername());
			providerSignInUtils.doPostSignUp(user.getUsername(), request);
			return "redirect:/";
		}
		return null;
	}

	// internal helpers
	private User createAccount(SignupForm form, BindingResult formBinding) {
		try {
			User user = new User(form.getUsername(),form.getPassword(),form.getFirstName(),form.getLastName());
			userRepository.createAccount(user);
			return user;
		} catch (UsernameAlreadyInUseException e) {
			formBinding.rejectValue("username", "user.duplicateUsername", "already in use");
			return null;
		}
	}

}
*/