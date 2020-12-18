package com.example.demo20204q.Filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo20204q.Model.Corporation;

public class CorporationPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private String corporationParameter;
    private boolean postOnly = true;
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {
        
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }

        String corporaionId = obtainCorporationId(request);
        String username = obtainUsername(request);
        String password = obtainPassword(request);

        if (corporaionId == null) {
            corporaionId = "";
        }

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }

        username = username.trim();

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                new Corporation(corporaionId, username), password);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }
    
    protected String obtainCorporationId(HttpServletRequest request) {
        return request.getParameter("corporationId");
    }

    public void setCorporationParameter(String corporationParameter) {
        this.corporationParameter = corporationParameter;
    }
    
    

}
