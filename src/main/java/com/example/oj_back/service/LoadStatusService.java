package com.example.oj_back.service;

import com.example.oj_back.dao.StatusDAO;
import com.example.oj_back.pojo.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadStatusService {

    @Autowired
    StatusDAO statusDAO;

    public List<Status> getAllStatus(){return statusDAO.findAll();}

    public List<Status> getByUsername(String username){return statusDAO.findByUsername(username);}

    public void save(Status status){statusDAO.saveAndFlush(status);}
}

