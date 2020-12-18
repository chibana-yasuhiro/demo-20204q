package com.example.demo20204q.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo20204q.Service.LoginService;

@Controller
public class LoginController {
    
    private LoginService loginService;
    
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
