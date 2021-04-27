package com.example.oj_back.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "question")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionid")
    int questionid;//问题id

    String questiontitle;//问题标题
    String questiondescription;//问题描述
    String indescription;//输入描述
    String outdescription;//输出描述
    String inexample;//输入用例
    String outexample;//输出用例
    int timelimit;//限制时间单位秒
    int memeorylimit;//内存限制单位mb
    int submittimes;//提交次数
    int solvetimes;//解决次数

    public int getQuestionid(){return questionid;}
    public void setQuestionid(int questionid){this.questionid=questionid;}

    public String getQuestiontitle(){return questiontitle;}
    public void setQuestiontitle(String question_title){this.questiontitle=questiontitle;}

    public String getQuestiondescription(){return questiondescription;}
    public void setQuestiondescription(String question_description){this.questiondescription=question_description;}

    public String getIndescription(){return indescription;}
    public void setIn_description(String in_description){this.indescription=in_description;}

    public String getOutdescription(){return outdescription;}
    public void setOutdescription(String out_description){this.outdescription=outdescription;}

    public String getInexample(){return inexample;}
    public void setInexample(String inexample){this.inexample=inexample;}

    public String getOutexample(){return outexample;}
    public void setOutexample(String outexample){this.outexample=outexample;}

    public int getTimelimit(){return timelimit;}
    public void setTimelimit(int timelimit){this.timelimit=timelimit;}

    public int getMemeorylimit(){return memeorylimit;}
    public void setMemeorylimit(int memorylimit){this.memeorylimit=memorylimit;}

    public int getSubmittimes(){return submittimes;}
    public void setSubmittimes(int submittimes){this.submittimes=submittimes;}

    public int getSolvetimes(){return solvetimes;}
    public void setSolvetimes(int solvetimes){this.solvetimes=solvetimes;}
}
