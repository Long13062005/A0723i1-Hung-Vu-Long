package service.imp;

import repository.IBenhAnRepository;
import repository.imp.BenhAnRepository;
import service.IBenhAnService;

import java.sql.SQLException;
import java.util.List;

public class BenhAnService implements IBenhAnService {
    IBenhAnRepository benhAnRepository = new BenhAnRepository();
    @Override
    public List<BenhAn> findAll() {
        return benhAnRepository.findAll();
    }

    @Override
    public boolean add(BenhAn sick) throws SQLException {
        return false;
    }
}
