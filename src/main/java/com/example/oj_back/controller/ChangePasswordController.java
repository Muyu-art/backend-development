package com.example.oj_back.controller;

import com.example.oj_back.pojo.NewPassword;
import com.example.oj_back.pojo.User;
import com.example.oj_back.result.Result;
import com.example.oj_back.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

public class ChangePasswordController {
    @Autowired
    LoginService loginService;

    @CrossOrigin
    @PostMapping(value = "/api/changepassword")
    @ResponseBody
    public Result change(@RequestBody NewPassword requestNewPassword) {
        String username = requestNewPassword.getUsername();
        username = HtmlUtils.htmlEscape(username);
        User user = loginService.getByName(username);
        User u=new User();
        u.setId(user.getId());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setUniversity(user.getUniversity());
        u.setMajor(user.getMajor());
        u.setEmail(user.getEmail());
        u.setStudentnumber(user.getstudentnumber());
        loginService.save(u);
        return new Result(200);
    }
}
