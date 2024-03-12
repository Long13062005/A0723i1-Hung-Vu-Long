package repository;

import java.sql.SQLException;
import java.util.List;

public interface IBenhAnRepository {
    List<BenhAn> findAll();
    boolean add(BenhAn sick) throws SQLException;
}
