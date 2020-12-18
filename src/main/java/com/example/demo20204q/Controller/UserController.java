package com.example.demo20204q.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo20204q.Service.UserService;

@Controller
public class UserController {
    
    
    private UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/user")
    public String user() {
        return "user";
    }
    
    @GetMapping("/user-create")
    public String createUser(@RequestParam(name="corporationId") String corporationId, @RequestParam(name="userName") String userName, @RequestParam(name="password") String password, Model model) {
        model.addAttribute("userName", userName);
        model.addAttribute("password", password);
        userService.insertUser(corporationId, userName, password);
        return "top";
    }



}
