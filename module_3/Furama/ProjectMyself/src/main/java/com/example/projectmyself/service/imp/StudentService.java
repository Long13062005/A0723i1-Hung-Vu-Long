package com.example.projectmyself.service.imp;

import com.example.projectmyself.dto.StudentList;
import com.example.projectmyself.model.Student;
import com.example.projectmyself.repository.IRepo;
import com.example.projectmyself.repository.imp.StudentRepo;
import com.example.projectmyself.service.IRepoService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IRepoService {
    IRepo studentRepo = new StudentRepo();
    @Override
    public List<StudentList> getAll() {
        return studentRepo.getAll();
    }

    @Override
    public boolean add(Student student) throws SQLException {

        return studentRepo.add(student);
    }

    @Override
    public boolean delete(int id) {
        return studentRepo.delete(id);
    }

    @Override
    public boolean update(Student student) throws SQLException {
        return studentRepo.update(student);
    }

    @Override
    public Student getStudentByID(int id) throws SQLException {
        return studentRepo.getStudentByID(id);
    }

    @Override
    public List<StudentList> getStudentByName(String inputName) throws SQLException {
        List<StudentList> studentLists = studentRepo.getAll();
        for (StudentList s  : studentLists) {
            if (s.getName().contains(inputName)) {
                return studentRepo.getStudentByName(inputName);

            }

        }
        return studentLists = null;
    }
}
