package service;

import dto.BenhNhanDto;

import java.sql.SQLException;
import java.util.List;

public interface IBenhNhanService {
    List<BenhNhanDto> getAll();
    boolean delete(int id);
    boolean update(BenhNhan victim) throws SQLException;
    BenhNhan getVictimByID(int id) throws SQLException;
}
