package com.example.oj_back.controller;

import com.example.oj_back.pojo.Question;
import com.example.oj_back.service.LoadQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LoadListController {
    @Autowired
    LoadQuestionService loadQuestionService;

    @CrossOrigin
    @PostMapping(value = "/api/questionlist")
    @ResponseBody
    public List<Question> Load(){
        return loadQuestionService.getAllQuestion();
    }
}
