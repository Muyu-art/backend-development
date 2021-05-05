package com.example.oj_back.controller;

import com.example.oj_back.result.Result;
import com.example.oj_back.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogoutController {
    @Autowired
    LoginService loginService;

    @CrossOrigin
    @PostMapping(value = "/api/logout")
    @ResponseBody
    public Result logout() {

        return new Result(200);
    }
}