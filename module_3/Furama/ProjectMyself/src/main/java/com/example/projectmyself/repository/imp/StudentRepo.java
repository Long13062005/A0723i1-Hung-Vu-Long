package com.example.projectmyself.repository.imp;

import com.example.projectmyself.dto.StudentList;
import com.example.projectmyself.model.Student;
import com.example.projectmyself.repository.BaseRepository;
import com.example.projectmyself.repository.IRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements IRepo {
    private final String SHOW_LIST_STUDENT ="call get_all_student();";
    private final String ADD_STUDENT ="call add_student(?,?,?);";
    private final String DELETE_STUDENT =" call delete_student(?);;";
    private final String FIND_BY_NAME_STUDENT ="call search_by_name_student(?); ";
    private final String FIND_BY_ID_STUDENT ="select * from student where id = ?; ";
    private final String UPDATE_STUDENT ="call update_student(?,?,?,?); ";

    @Override
    public List<StudentList> getAll() {
        Connection connection = BaseRepository.getConnectDB();
        List<StudentList> studentLists = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_LIST_STUDENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String className = resultSet.getString("className");
                String gvName = resultSet.getString("gvName");
                StudentList studentList = new StudentList(id,name,className,gvName);
                studentLists.add(studentList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentLists;

    }

    @Override
    public boolean add(Student student) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_STUDENT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getGvID());
            preparedStatement.setInt(3, student.getClassID());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            return false;
        }
    }


    @Override
    public boolean update(Student student) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getGvID());
            preparedStatement.setInt(3, student.getClassID());
            preparedStatement.setInt(4,student.getId());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Student getStudentByID(int id) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        Student student = null;
         try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_STUDENT);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()) {
                 String name = resultSet.getString("name");
                 int classId = resultSet.getInt("classId");
                 int gvId = resultSet.getInt("gvId");
                 student = new Student(name,classId,gvId);
             }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public List<StudentList> getStudentByName(String inputName) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        List<StudentList> studentLists = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME_STUDENT);
            preparedStatement.setString(1,inputName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String className = resultSet.getString("className");
                String gvName = resultSet.getString("gvName");
                StudentList studentList = new StudentList(id,name,className,gvName);
                studentLists.add(studentList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentLists;

    }
}
