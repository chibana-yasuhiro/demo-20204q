package com.example.demo20204q.Provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.demo20204q.Model.Corporation;
import com.example.demo20204q.Model.LoginUser;
import com.example.demo20204q.Service.LoginService;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {
    
    private LoginService loginService;
    
    public LoginAuthenticationProvider (LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Corporation corporation = (Corporation) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        
        LoginUser loginUser = loginService.login(corporation.getCorporationId(), corporation.getUserName(), password);
        
        
        return new UsernamePasswordAuthenticationToken(loginUser, authentication.getCredentials(), null);
        
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // TODO Auto-generated method stub
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
