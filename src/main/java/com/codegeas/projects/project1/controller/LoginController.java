package com.codegeas.projects.project1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * @Controller is used to mark classes as Spring MVC Controller. 
 * @RestController is a convenience annotation that does nothing more than...
 * ...adding the @Controller and @ResponseBody annotations. 
 * Also @RestController will treat return value of the methods as String only...
 * ...so it will not render respective html in browser
 */
@Controller
public class LoginController {
	
   @GetMapping("/")
    public String rootPage() {  
        return "index";  
    } 
   
    @GetMapping("/login")  
    public String login() {  
        return "login-form";  
    }  
    
	@GetMapping("/home-page")
	public String homePage() {
		return "home-page";
	}
}