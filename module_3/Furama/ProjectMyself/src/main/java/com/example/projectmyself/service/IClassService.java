package com.example.projectmyself.service;

import com.example.projectmyself.model.ClassStudent;

import java.sql.SQLException;
import java.util.List;

public interface IClassService {
    List<ClassStudent> findAll();
    boolean add(ClassStudent classStudent) throws SQLException;
}
