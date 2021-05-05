package com.example.oj_back.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "submit")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Submit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "submitid")
    int submitid;
    int userid;

    int questionid;
    String submittime;
    String language;
    String state;
    String code;
    int codelength;
    int memory;
    int runtime;

    public void setSubmitid(int submitid)
    {
        this.submitid=submitid;
    }

    public int getSubmitid()
    {
        return this.submitid;
    }

    public void setUserid(int userid)
    {
        this.userid=userid;
    }

    public int getUserid()
    {
        return this.userid;
    }

    public void setQuestionid(int questionid)
    {
        this.questionid=questionid;
    }

    public int getQuestionid()
    {
        return this.questionid;
    }

    public void setSubmittime(String submittime)
    {
        this.submittime=submittime;
    }

    public String getSubmittime()
    {
        return this.submittime;
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

    public void setCodelength(int codelength)
    {
        this.codelength=codelength;
    }

    public int getCodelength()
    {
        return this.codelength;
    }

    public void setMemory(int memory)
    {
        this.memory=memory;
    }

    public int getMemory()
    {
        return this.memory;
    }

    public void setRuntime(int runtime)
    {
        this.runtime=runtime;
    }

    public int getRuntime()
    {
        return this.runtime;
    }
}
