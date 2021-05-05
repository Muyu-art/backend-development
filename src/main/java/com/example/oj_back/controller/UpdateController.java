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
public class UpdateController {
    @Autowired
    RegisterService registerService;

    @CrossOrigin
    @PostMapping(value = "/api/update")
    @ResponseBody
    public Result Update(@RequestBody User requestUser)
    {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        int id = registerService.getByName(username).getId();
        User u=new User();
        u.setId(id);
        u.setUsername(username);
        u.setPassword(requestUser.getPassword());
        u.setUniversity(requestUser.getUniversity());
        u.setMajor(requestUser.getMajor());
        u.setEmail(requestUser.getEmail());
        u.setStudentnumber(requestUser.getstudentnumber());
        return registerService.Register(u);
    }
}
