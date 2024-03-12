package service;

import java.sql.SQLException;
import java.util.List;

public interface IBenhAnService {
    List<BenhAn> findAll();
    boolean add(BenhAn sick) throws SQLException;
}
