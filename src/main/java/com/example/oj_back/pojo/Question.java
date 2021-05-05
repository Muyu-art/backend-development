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
    String questiontype;//问题类型
    String sample1;//输入描述
    String sample2;//输出描述
    int usecasenum;
    int timelimit;//限制时间单位秒
    int memorylimit;//内存限制单位mb
    int submittimes;//提交次数
    int solvetimes;//解决次数
    String tips;

    public int getQuestionid(){return questionid;}
    public void setQuestionid(int questionid){this.questionid=questionid;}

    public String getQuestiontitle(){return questiontitle;}
    public void setQuestiontitle(String questiontitle){this.questiontitle=questiontitle;}

    public String getQuestiondescription(){return this.questiondescription;}
    public void setQuestiondescription(String questiondescription){this.questiondescription=questiondescription;}

    public String getQuestiontype(){return this.questiontype;}
    public void setQuestiontype(String questiontype){this.questiontype=questiontype;}

    public String getSample1(){return sample1;}
    public void setSample1(String sample1){this.sample1=sample1;}

    public String getSample2(){return sample2;}
    public void setSample2(String sample2){this.sample2=sample2;}

    public int getUsecasenum(){return this.usecasenum;}
    public void setUsecasenum(int usecasenum){this.usecasenum=usecasenum;};

    public int getTimelimit(){return this.timelimit;}
    public void setTimelimit(int timelimit){this.timelimit=timelimit;}

    public int getMemorylimit(){return this.memorylimit;}
    public void setMemorylimit(int memorylimit){this.memorylimit=memorylimit;}

    public int getSubmittimes(){return this.submittimes;}
    public void setSubmittimes(int submittimes){this.submittimes=submittimes;}

    public int getSolvetimes(){return this.solvetimes;}
    public void setSolvetimes(int solvetimes){this.solvetimes=solvetimes;}

    public String getTips(){return this.tips;}
    public void setTips(String tips){this.tips=tips;}
}
