package com.example.oj_back.controller;

import com.example.oj_back.pojo.Code;
import com.example.oj_back.pojo.Question;
import com.example.oj_back.result.Result;
import com.example.oj_back.service.LoadQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;


@Controller
public class LoadQuestionController {
    @Autowired
    LoadQuestionService loadQuestionService;

    @CrossOrigin
    @PostMapping(value = "/api/question")
    @ResponseBody
    public Question Load(@RequestBody Question requestQuestion){
        int questionid=requestQuestion.getQuestionid();
        //ystem.out.println(questionid);
        return loadQuestionService.getByQuestionid(questionid);
    }

    @ResponseBody
    public Result Get(@RequestBody Code requestCode)
    {
        String code=requestCode.getCode();
        code = HtmlUtils.htmlEscape(code);
        System.out.println(code);
        return new Result(200);
    }
}
