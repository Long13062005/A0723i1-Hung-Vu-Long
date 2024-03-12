package com.example.projectmyself.repository.imp;

import com.example.projectmyself.model.ClassStudent;
import com.example.projectmyself.model.Tutor;
import com.example.projectmyself.repository.BaseRepository;
import com.example.projectmyself.repository.ITutorRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TutorRepo implements ITutorRepo {
    private final String All = "select * from gv";
    private final String ADD = "insert into gv(gvName) value (?);";



    @Override
    public List<Tutor> findAll() {
        Connection connection = BaseRepository.getConnectDB();
        List<Tutor> tutorList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(All);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("gvid");
                String gvName = resultSet.getString("gvName");
                Tutor tutor = new Tutor(id,gvName);
                tutorList.add(tutor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tutorList;
    }

    @Override
    public boolean add(Tutor tutor) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD);
            preparedStatement.setString(1, tutor.getGvName());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            return false;
        }
    }
}
