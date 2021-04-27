package com.example.oj_back.controller;

import com.example.oj_back.Compiler.CustomStringJavaCompiler;
import com.example.oj_back.pojo.Code;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;


@Controller
public class GetCodeController {

    @CrossOrigin
    @PostMapping(value = "/api/code")
    @ResponseBody
    public void Get(@RequestBody Code requestCode)
    {
        String code=requestCode.getCode();
        code = HtmlUtils.htmlEscape(code);

    }
}