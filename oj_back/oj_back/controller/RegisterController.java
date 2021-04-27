package com.example.oj_back.controller;


import com.example.oj_back.pojo.User;
import com.example.oj_back.result.Result;
import com.example.oj_back.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

@Controller
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @CrossOrigin
    @PostMapping(value = "/api/register")
    @ResponseBody
    public Result Register(@RequestBody User requestUser)
    {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        System.out.println(username);

        if(registerService.isExist(username)) return new Result(400);
        else return registerService.Register(requestUser);
    }
}

