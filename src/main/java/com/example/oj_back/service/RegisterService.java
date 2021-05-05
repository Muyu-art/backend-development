package com.example.oj_back.service;

import com.example.oj_back.dao.UserDAO;
import com.example.oj_back.pojo.User;
import com.example.oj_back.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    UserDAO userDAO;
    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }

    public User getByName(String username) {
        return userDAO.findByUsername(username);
    }

    public void add(User user) {
        userDAO.saveAndFlush(user);
    }

    public Result Register(User user)
    {
        add(user);
        return new Result(200);
    }

}
