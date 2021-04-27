package com.example.oj_back.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "submit")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Submit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "submitId")
    int submitId;
    int userId;

    int questionId;
    String submitTime;
    String language;
    String state;
    String code;
    int codeLength;
    int memory;
    int runTime;

    public void setSubmitId(int submitId)
    {
        this.submitId=submitId;
    }

    public int getSubmitId()
    {
        return this.submitId;
    }

    public void setUserId(int userId)
    {
        this.userId=userId;
    }

    public int getUserId()
    {
        return this.userId;
    }

    public void setQuestionId(int questionId)
    {
        this.questionId=questionId;
    }

    public int getQuestionId()
    {
        return this.questionId;
    }

    public void setSubmitTime(String submitTime)
    {
        this.submitTime=submitTime;
    }

    public String getSubmitTime()
    {
        return this.submitTime;
    }

    public void setLanguage(String language)
    {
        this.language=language;
    }

    public String getLanguage()
    {
        return this.language;
    }

    public void setState(String state)
    {
        this.state=state;
    }

    public String getState()
    {
        return this.state;
    }

    public void setCode(String code)
    {
        this.code=code;
    }

    public String getCode()
    {
        return this.code;
    }

    public void setCodeLength(int codeLength)
    {
        this.codeLength=codeLength;
    }

    public int getCodeLength()
    {
        return this.codeLength;
    }

    public void setMemory(int memory)
    {
        this.memory=memory;
    }

    public int getMemory()
    {
        return this.memory;
    }

    public void setRunTime(int runTime)
    {
        this.runTime=runTime;
    }

    public int getRunTime()
    {
        return this.runTime;
    }
}
