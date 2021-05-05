package com.example.oj_back.controller;

import com.example.oj_back.pojo.Question;
import com.example.oj_back.pojo.SearchInfo;
import com.example.oj_back.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    SearchService searchService;

    @CrossOrigin
    @PostMapping(value = "/api/search")
    @ResponseBody
    public List<Question> Search(@RequestBody SearchInfo requestSearchinfo)
    {
        System.out.println(1);
        String searchinfo=requestSearchinfo.getSearchInfo();
        System.out.println(2);
        //searchinfo= HtmlUtils.htmlEscape(searchinfo);
        System.out.println(3);
        System.out.println(searchinfo);
        return searchService.searchByTitle(searchinfo);
    }
}
