package com.example.oj_back.dao;

import com.example.oj_back.pojo.Question;
import com.tdunning.math.stats.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionDAO extends JpaRepository<Question,Long> {
    Question findByQuestionid(int questionid);

    List<Question> findAll();

    List<Question> findByQuestiontitleLike(String questontitle);

    List<Question> findByQuestiontypeLike(String questiontype);
}
