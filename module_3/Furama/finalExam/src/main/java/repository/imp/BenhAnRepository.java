package repository.imp;

import repository.BaseRepository;
import repository.IBenhAnRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepository implements IBenhAnRepository {
    private final String SHOW_LIST_HOSPITAL ="select * from benh_an;";

    @Override
    public List<BenhAn> findAll() {
        Connection connection = BaseRepository.getConnectDB();
        List<BenhAn> benhAns = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_LIST_HOSPITAL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("ID_sick");
                String codeSick = resultSet.getString("code_sick");
                BenhAn benhAn = new BenhAn(id,codeSick);
                benhAns.add(benhAn);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return benhAns;
    }

    @Override
    public boolean add(BenhAn sick) throws SQLException {
        return false;
    }
}
