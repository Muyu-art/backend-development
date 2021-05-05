package com.example.oj_back.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    String username;//用户名
    String password;//登录密码
    String email;//注册邮箱
    String university;//学校
    String major;
    String studentnumber;//学号

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id=id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username=username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password=password;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email=email;
    }

    public String getUniversity()
    {
        return this.university;
    }

    public void setUniversity(String university)
    {
        this.university=university;
    }

    public String getMajor(){return this.major;}
    public void setMajor(String major){this.major=major;}

    public String getstudentnumber()
    {
        return this.studentnumber;
    }

    public void setStudentnumber(String studentnumber)
    {
        this.studentnumber=studentnumber;
    }
}
