package com.example.oj_back.controller;

import com.example.oj_back.pojo.Status;
import com.example.oj_back.service.LoadStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LoadStatusController {
    @Autowired
    LoadStatusService loadStatusService;

    @CrossOrigin
    @PostMapping(value = "/api/status")
    @ResponseBody
    public List<Status> Load(){
        return loadStatusService.getAllStatus();
    }
}
