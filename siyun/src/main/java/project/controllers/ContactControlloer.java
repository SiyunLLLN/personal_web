package project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactControlloer {

	public ContactControlloer() {
		// TODO Auto-generated constructor stub
	}
	
	
    @GetMapping("/contact")
    public String contactPage(Model model) {
    	
    	
    	
        return "homePage/contact";
    }

}
