package com.example.oj_back.service;

import com.example.oj_back.dao.QuestionDAO;
import com.example.oj_back.pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadQuestionService {
    @Autowired
    QuestionDAO questionDAO;

    public Question getByQuestionid(int questionid){return questionDAO.findByQuestionid(questionid);};

    public List<Question> getAllQuestion(){return questionDAO.findAll();}
}
