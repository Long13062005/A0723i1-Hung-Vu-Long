package com.example.projectmyself.service.imp;

import com.example.projectmyself.model.ClassStudent;
import com.example.projectmyself.repository.IClassRepo;
import com.example.projectmyself.repository.imp.ClassRepo;
import com.example.projectmyself.service.IClassService;

import java.sql.SQLException;
import java.util.List;

public class ClassService implements IClassService {
    IClassRepo classRepo = new ClassRepo();
    @Override
    public List<ClassStudent> findAll() {
        return classRepo.findAll();
    }

    @Override
    public boolean add(ClassStudent classStudent) throws SQLException {
        return classRepo.add(classStudent);
    }
}
