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

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@Controller
public class LoginController {
	
	/** The log. */
	private final Log LOG = LogFactory.getLog(LoginController.class);
		
	/**
	 * Method to SHOW login view.
	 *
	 * @param model the model
	 * @param error the error
	 * @param logout the logout
	 * @return view string
	 */
	
	@GetMapping("/login")
	public String login(Model model,
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout) {
		
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		
		LOG.info("METHOD: login(); PARAMS: error=> " + error + ", logout => " + logout);
		LOG.info("METHOD: login(); REDIRECTING TO VIEW: " + ViewConstant.LOGIN_VIEW );
		
		return ViewConstant.LOGIN_VIEW;
	}
	
	/**
	 * Method to AUTHENTICATE user.
	 *
	 * @return view string
	 */
	
	@GetMapping({"/loginSuccess","/"})
	public String loginAuthentication() {
		
		LOG.info("METHOD: /loginAuthentication(); REDIRECTING TO TasksView");	
		return "redirect:/todoapp/home";
	}
}
