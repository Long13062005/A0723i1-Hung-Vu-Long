package com.example.projectmyself.service;

import com.example.projectmyself.dto.StudentList;
import com.example.projectmyself.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IRepoService {
    List<StudentList> getAll();
    boolean add(Student student) throws SQLException;
    boolean delete(int id);
    boolean update(Student student) throws SQLException;
    Student getStudentByID(int id) throws SQLException;
    List<StudentList> getStudentByName(String inputName) throws SQLException;

}
