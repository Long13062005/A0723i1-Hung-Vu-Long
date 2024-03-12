package com.example.projectmyself.repository;

import com.example.projectmyself.model.Tutor;

import java.sql.SQLException;
import java.util.List;

public interface ITutorRepo {
    List<Tutor> findAll();
    boolean add(Tutor tutor) throws SQLException;
}
