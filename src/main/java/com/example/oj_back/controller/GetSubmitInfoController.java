package com.example.oj_back.controller;

import com.example.oj_back.pojo.Status;
import com.example.oj_back.pojo.Submit;
import com.example.oj_back.pojo.User;
import com.example.oj_back.result.Result;
import com.example.oj_back.service.LoadStatusService;
import com.example.oj_back.service.RegisterService;
import com.example.oj_back.service.SubmitInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Controller
public class GetSubmitInfoController {

    @Autowired
    LoadStatusService loadStatusService;

    @CrossOrigin
    @PostMapping(value = "/api/submitinfo")
    @ResponseBody
    public List<Status> Register(@RequestBody User requestUser)
    {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        //List<Submit> s = submitInfoService.getSubmitByUserId(id);
        //System.out.println(s.get(0).getQuestionid());
        return loadStatusService.getByUsername(username);
    }
}
