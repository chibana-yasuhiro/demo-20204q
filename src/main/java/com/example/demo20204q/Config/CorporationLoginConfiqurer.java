package com.example.demo20204q.Config;

import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.example.demo20204q.Filter.CorporationPasswordAuthenticationFilter;

public class CorporationLoginConfiqurer<H extends HttpSecurityBuilder<H>> 
extends AbstractAuthenticationFilterConfigurer<H, CorporationLoginConfiqurer<H>, CorporationPasswordAuthenticationFilter>{

    public CorporationLoginConfiqurer() {
        super(new CorporationPasswordAuthenticationFilter(), null);
    }
    
    @Override
    protected RequestMatcher createLoginProcessingUrlMatcher(String loginProcessingUrl) {
        // TODO Auto-generated method stub
        return new AntPathRequestMatcher(loginProcessingUrl, "POST");
    }
    
    public CorporationLoginConfiqurer<H> corporationParameter(String corporationParameter) {
        getAuthenticationFilter().setCorporationParameter(corporationParameter);
        return this;
    }

    
    public CorporationLoginConfiqurer<H> usernameParameter(String usernameParameter) {
        getAuthenticationFilter().setUsernameParameter(usernameParameter);
        return this;
    }
    
    public CorporationLoginConfiqurer<H> passwordParameter(String passwordParameter) {
        getAuthenticationFilter().setPasswordParameter(passwordParameter);
        return this;
    }
    
    @Override
    public CorporationLoginConfiqurer<H> loginPage(String loginPage) {
        return super.loginPage(loginPage);
        
    }
    
    public CorporationLoginConfiqurer<H> successForwardUrl(String forwardUrl) {
        successHandler(new ForwardAuthenticationSuccessHandler(forwardUrl));
        return this;
    }

}
