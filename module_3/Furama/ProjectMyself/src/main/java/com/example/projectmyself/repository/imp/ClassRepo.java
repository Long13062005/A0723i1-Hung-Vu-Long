package com.example.projectmyself.repository.imp;

import com.example.projectmyself.dto.StudentList;
import com.example.projectmyself.model.ClassStudent;
import com.example.projectmyself.repository.BaseRepository;
import com.example.projectmyself.repository.IClassRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRepo implements IClassRepo {
    private final String All = "select * from class";
    private final String ADD = "insert into class(className) value (?);";



    @Override
    public List<ClassStudent> findAll() {
        Connection connection = BaseRepository.getConnectDB();
        List<ClassStudent> classStudentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(All);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("classid");
                String className = resultSet.getString("className");
                ClassStudent classStudent = new ClassStudent(id,className);
                classStudentList.add(classStudent);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return classStudentList;
    }

    @Override
    public boolean add(ClassStudent classStudent) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD);
            preparedStatement.setString(1, classStudent.getClassName());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            return false;
        }
    }
}
