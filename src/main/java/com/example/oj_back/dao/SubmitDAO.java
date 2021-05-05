package com.example.oj_back.dao;

import com.example.oj_back.pojo.Submit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmitDAO extends JpaRepository<Submit,Long> {
    List<Submit> findByUserid(int userid);
}
