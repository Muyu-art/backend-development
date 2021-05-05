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

    public Question getByQuestionid(int questionId){return questionDAO.findByQuestionid(questionId);};

    public List<Question> getByQuestionTypeLike(String questiontype){return questionDAO.findByQuestiontypeLike(questiontype);}//根据问题类型返回问题列表

    public List<Question> getByQuestionTitleLike(String questiontitle){return questionDAO.findByQuestiontitleLike(questiontitle);}//根据问题标题返回问题列表

    public List<Question> getAllQuestion(){return questionDAO.findAll();}
}
