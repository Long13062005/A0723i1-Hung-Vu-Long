package service.imp;

import dto.BenhNhanDto;
import repository.IBenhNhanRepository;
import repository.imp.BenhNhanRepository;
import service.IBenhNhanService;

import java.sql.SQLException;
import java.util.List;

public class BenhNhanService implements IBenhNhanService {
    IBenhNhanRepository  benhNhanRepository = new BenhNhanRepository();
    @Override
    public List<BenhNhanDto> getAll() {
        return benhNhanRepository.getAll();
    }

    @Override
    public boolean delete(int id) {
        return benhNhanRepository.delete(id);
    }

    @Override
    public boolean update(BenhNhan victim) throws SQLException {
        return benhNhanRepository.update(victim);
    }

    @Override
    public BenhNhan getVictimByID(int id) throws SQLException {
        return benhNhanRepository.getVictimByID(id);
    }
}
