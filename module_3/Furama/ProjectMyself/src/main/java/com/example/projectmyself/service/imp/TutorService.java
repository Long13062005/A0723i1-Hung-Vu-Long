package com.example.projectmyself.service.imp;

import com.example.projectmyself.model.Tutor;
import com.example.projectmyself.repository.ITutorRepo;
import com.example.projectmyself.repository.imp.TutorRepo;
import com.example.projectmyself.service.ITutorService;

import java.sql.SQLException;
import java.util.List;

public class TutorService implements ITutorService {
    ITutorRepo tutorRepo = new TutorRepo();
    @Override
    public List<Tutor> findAll() {
        return tutorRepo.findAll();
    }

    @Override
    public boolean add(Tutor tutor) throws SQLException {
        return tutorRepo.add(tutor);
    }
}
