package com.example.demo20204q.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.demo20204q.Service.LoginService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    LoginService loginService;
    
//    以下のコメントアウトはspring securityのデフォルト実装
//
//    @Autowired
//    void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(loginService).passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/", "/user", "/user-create", "/api/person").permitAll()
//            .anyRequest()
//            .authenticated()
//            .and()
//        .formLogin()
//            .usernameParameter("userName")
//            .passwordParameter("password")
//            .loginProcessingUrl("/authenticate")
//            .defaultSuccessUrl("/top")
//            .permitAll()
//            .and()
//         .cors()
//            .configurationSource(this.corsConfigurationSource());
//    }
//    
//    
    private CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedMethod("GET");
        corsConfiguration.addAllowedOrigin("http://localhost:8081");

        UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
        corsSource.registerCorsConfiguration("/api/person", corsConfiguration);

        return corsSource;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/", "/user", "/user-create", "/api/person").permitAll()
            .anyRequest()
            .authenticated();
        
        http.apply(new CorporationLoginConfiqurer<HttpSecurity>())
            .corporationParameter("corporationId")
            .usernameParameter("userName")
            .passwordParameter("password")
            .loginPage("/login")
            .loginProcessingUrl("/authenticate")
            .defaultSuccessUrl("/top")
            .permitAll()
            .and()
            .cors()
            .configurationSource(this.corsConfigurationSource());
    }
}
