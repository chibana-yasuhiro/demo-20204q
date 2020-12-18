package com.example.demo20204q.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo20204q.Repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public int insertUser(String corporationId, String userName, String password) {
        
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String hash = bcrypt.encode(password);
        return userRepository.insertUser(corporationId, userName, hash);
    }

}
