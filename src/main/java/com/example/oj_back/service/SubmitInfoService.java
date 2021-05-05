package com.example.oj_back.service;

import com.example.oj_back.dao.SubmitDAO;
import com.example.oj_back.pojo.Submit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmitInfoService {
    @Autowired
    SubmitDAO submitDAO;

    public List<Submit> getSubmitByUserId(int userid){return submitDAO.findByUserid(userid);};
}
