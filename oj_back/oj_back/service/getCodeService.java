package com.example.oj_back.service;

import com.example.oj_back.pojo.Code;
import com.example.oj_back.pojo.Submit;
import org.springframework.stereotype.Service;

@Service
public class getCodeService {
    Code code;

    public String get_Code(){return code.getCode();}

    public void submitInfo(Submit submit)
    {

    }
}
