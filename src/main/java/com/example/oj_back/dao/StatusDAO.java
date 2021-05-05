package com.example.oj_back.dao;

import com.example.oj_back.pojo.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface StatusDAO extends JpaRepository<Status,Long>{
    //Status findByRunId(int runId);

    List<Status> findAll();

    List<Status> findByUsername(String username);

    //List<Status> findByUsernameLike(String username);
}
