package com.eduardobarrera.todoapp.controller;

import javax.websocket.server.PathParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eduardobarrera.todoapp.constant.ViewConstant;
import com.eduardobarrera.todoapp.model.UserCredentials;

@Controller
public class LoginController {
	
	private final Log LOG = LogFactory.getLog(LoginController.class);
	
	/**
	 * Method to REDIRECT to login view
	 * @return view string 
	 */
	
	@GetMapping("/")
	public String redirectToLogin() {
		LOG.info("METHOD: redirectToLogin(); REDIRECTING TO URL: /login");
		return "redirect:/login";
	}
	
	/**
	 * Method to SHOW login view
	 * @return view string 
	 */
	
	@GetMapping("/login")
	public String login(Model model,
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout) {
		LOG.info("METHOD: login(); PARAMS: " + error + ", " + logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredentials", new UserCredentials());
		LOG.info("METHOD: login(); REDIRECTING TO VIEW: " + ViewConstant.LOGIN_VIEW );
		return ViewConstant.LOGIN_VIEW;
	}
	
	/**
	 * Method to AUTHENTICATE user
	 * @param userCredentials
	 * @return view string 
	 */
	
	@PostMapping("/loginAuthentication")
	public String loginAuthentication(@ModelAttribute(name="userCredentials") UserCredentials userCredentials) {
		LOG.info("METHOD: /loginAuthentication(); PARAMS: " + userCredentials.toString());
		String viewToRedirect = ""; 
		if(userCredentials.userName.equals("admin") && userCredentials.password.equals("admin")) {
			LOG.info("METHOD: /loginAuthentication(); REDIRECTING TO URL: /todoapp/home");
			viewToRedirect = "/todoapp/home";
		}else {
			LOG.info("METHOD: /loginAuthentication(); REDIRECTING TO URL: /login?error");
			viewToRedirect = "/login?error";	
		}
		return "redirect:" + viewToRedirect;
	}
}
