package com.example.demo20204q.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo20204q.Model.LoginUser;
import com.example.demo20204q.Model.User;
import com.example.demo20204q.Repository.UserRepository;

@Service
public class LoginService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    
   
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findUser(userName);
        
        if (user == null) {
             throw new UsernameNotFoundException("user not found");
        }
        
        return new LoginUser(user,AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN"));
    }
    

    public LoginUser login(String corporationId, String userName, String password) {
        User user = userRepository.findLoginUser(corporationId, userName);
        if (user == null) {
            throw new AuthenticationCredentialsNotFoundException("login error");
        }
        
        LoginUser loginUser = new LoginUser(user,AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN"));
        
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        
        if (bcrypt.matches(password, loginUser.getPassword())) {
            return loginUser;
        } else {
            throw new BadCredentialsException("Credential Error");
        }
        
    }

}
