package com.example.oj_back.controller;


import com.example.oj_back.Judge.Judge;
import com.example.oj_back.Judge.JudgeResult;
import com.example.oj_back.Judge.JudgeTask;
import com.example.oj_back.pojo.Info;
import com.example.oj_back.pojo.Status;
import com.example.oj_back.result.Result;
import com.example.oj_back.service.LoadQuestionService;
import com.example.oj_back.service.LoadStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Controller
public class GetCodeController {
    @Autowired
    LoadQuestionService loadQuestionService;

    @Autowired
    LoadStatusService loadStatusService;

    @CrossOrigin
    @PostMapping(value = "/api/code")
    @ResponseBody
    public Result Get(@RequestBody Info requestInfo) throws IOException {
        String username=HtmlUtils.htmlEscape(requestInfo.getUsername());
        //System.out.println(username);
        String code=requestInfo.getCode();//设置判题任务
        //System.out.println(code);
        //System.out.println(requestInfo.getLanguageid());
        //生成judgetask
        JudgeTask judgeTask=new JudgeTask();
        judgeTask.setQuestionId(requestInfo.getQuestionid());
        judgeTask.setLanguageId(requestInfo.getLanguageid());
        judgeTask.setCode(code);
        int usecaseNum=loadQuestionService.getByQuestionid(requestInfo.getQuestionid()).getUsecasenum();
        //System.out.println(usecaseNum);
        judgeTask.setUsecaseNum(usecaseNum);
        int timeLimit=loadQuestionService.getByQuestionid(requestInfo.getQuestionid()).getTimelimit();
        //System.out.println(timeLimit);
        judgeTask.setTimeLimit(timeLimit);
        int memoryLimit=loadQuestionService.getByQuestionid(requestInfo.getQuestionid()).getMemorylimit();
        //System.out.println(memoryLimit);
        judgeTask.setMemoryLimit(memoryLimit);
        //执行判题任务
        Judge judgement=new Judge();
        //返回判题结果
        //judgement.judge(judgeTask);
        JudgeResult result=judgement.judge(judgeTask);

        //System.out.println("运行结果为"+result.getErorMessage());
        //更新提交状态
        Status status=new Status();
        status.setUsername(username);
        status.setQuestionid(requestInfo.getQuestionid());
        status.setQuestiontitle(loadQuestionService.getByQuestionid(requestInfo.getQuestionid()).getQuestiontitle());
        switch (requestInfo.getLanguageid())
        {
            case 1:
                status.setLanguage("c");
                break;
            case 2:
                status.setLanguage("c++");
                break;
            case 3:
                status.setLanguage("java");
                break;
            case 4:
                status.setLanguage("python");
                break;
        }
        status.setTestresult(result.getStatus());
        if(result.getStatus().equals("Accepted"))
        {
            status.setScore(100);
        }else
        {
            status.setScore(0);
        }
        status.setTime(result.getTimeUsed());
        status.setMemory(result.getMemoryUsed());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();
        String time=date.format(formatter);
        status.setSubmittime(time);
        loadStatusService.save(status);
        return new Result(200);
    }
}