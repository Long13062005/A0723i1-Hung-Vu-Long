package com.example.projectmyself.service;

import com.example.projectmyself.model.Tutor;

import java.sql.SQLException;
import java.util.List;

public interface ITutorService {
    List<Tutor> findAll();
    boolean add(Tutor tutor) throws SQLException;
}
