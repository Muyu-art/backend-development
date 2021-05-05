package com.example.oj_back.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "status")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "runid")
    int runid;//运行ID
    String username;//用户
    int questionid;//题号
    String questiontitle;//题目
    String testresult;//测试结果
    int score;//分数
    int time;//时间
    int memory;//内存
    String language;//语言
    String submittime;//提交时间

    public int getRunid(){return runid;}
    public void setRunid(int runid){this.runid=runid;}

    public String getUsername(){return username;}
    public void setUsername(String username){this.username=username;}

    public int getQuestionid(){return questionid;}
    public void setQuestionid(int questionid){this.questionid=questionid;}

    public String getQuestiontitle(){return questiontitle;}
    public void setQuestiontitle(String questiontitle){this.questiontitle=questiontitle;}

    public String getTestresult(){return testresult;}
    public void setTestresult(String testresult){this.testresult=testresult;}

    public int getScore(){return score;}
    public void setScore(int score){this.score=score;}

    public int getTime(){return time;}
    public void setTime(int time){this.time=time;}

    public int getMemory(){return memory;}
    public void setMemory(int memory){this.memory=memory;}

    public String getLanguage(){return language;}
    public void setLanguage(String language){this.language=language;}

    public String getSubmittime(){return submittime;}
    public void setSubmittime(String submittime){this.submittime=submittime;}
}