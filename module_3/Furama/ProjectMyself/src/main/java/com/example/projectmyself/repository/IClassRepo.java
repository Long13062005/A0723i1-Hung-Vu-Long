package com.example.projectmyself.repository;

import com.example.projectmyself.model.ClassStudent;
import com.example.projectmyself.model.Tutor;

import java.sql.SQLException;
import java.util.List;

public interface IClassRepo {
    List<ClassStudent> findAll();
    boolean add(ClassStudent classStudent) throws SQLException;
}
