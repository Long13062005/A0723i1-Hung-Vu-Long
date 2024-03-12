package repository;

import dto.BenhNhanDto;

import java.sql.SQLException;
import java.util.List;

public interface IBenhNhanRepository {
    List<BenhNhanDto> getAll();
    boolean delete(int id);
    boolean update(BenhNhan victim) throws SQLException;
    BenhNhan getVictimByID(int id) throws SQLException;
}
