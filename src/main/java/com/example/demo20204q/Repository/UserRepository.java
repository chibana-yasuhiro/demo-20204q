package com.example.demo20204q.Repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo20204q.Model.User;

@Repository
@Mapper
public interface UserRepository {
    
    public User findUser(String userName);
    
    public int insertUser(String corporationId, String userName, String password);

    public User findLoginUser(String corporationId, String userName);
}
