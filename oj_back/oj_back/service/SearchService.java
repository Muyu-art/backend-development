package com.example.oj_back.service;

import com.example.oj_back.dao.QuestionDAO;
import com.example.oj_back.pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    QuestionDAO questionDAO;

    public List<Question> Search(String questiontitle){return questionDAO.findByQuestiontitleLike(questiontitle);};

}
