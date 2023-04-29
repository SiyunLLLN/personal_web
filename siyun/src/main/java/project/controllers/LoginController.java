package project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/sign-in")
	public String login() {
		// TODO Auto-generated constructor stub
		return "/sign-in";
	}

}
