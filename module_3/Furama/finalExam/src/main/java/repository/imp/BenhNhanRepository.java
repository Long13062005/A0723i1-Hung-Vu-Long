package repository.imp;

import dto.BenhNhanDto;
import repository.BaseRepository;
import repository.IBenhNhanRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepository implements IBenhNhanRepository {
    private final String SHOW_LIST_HOSPITAL ="CALL SHOW_ALL_HOSPITAL();";
    private final String DELETE_VICTIM =" call DELETE_VICTIM(?);;";
    private final String FIND_BY_ID_VICTIM ="select * from benh_nhan where id = ?;";
    private final String UPDATE_VICTIM  ="call update_victim(?,?,?,?,?); ";
    @Override
    public List<BenhNhanDto> getAll() {
        Connection connection = BaseRepository.getConnectDB();
        List<BenhNhanDto> benhNhanDtos = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_LIST_HOSPITAL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("ID");
                String codeSick = resultSet.getString("MA_BENH_AN");
                String codeVictim = resultSet.getString("MA_BENH_NHAN");
                String nameVictim = resultSet.getString("TEN_BENH_NHAN");
                String dateStart = resultSet.getString("NGAY_NHAP_VIEN");
                String dateEnd = resultSet.getString("NGAY_XUAT_VIEN");
                String reason = resultSet.getString("LY_DO_NHAP_VIEN");
                BenhNhanDto benhNhan = new BenhNhanDto(id,codeSick,codeVictim,nameVictim,dateStart,dateEnd,reason);
                benhNhanDtos.add(benhNhan);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return benhNhanDtos;
    }



    @Override
    public boolean delete(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_VICTIM);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            return false;
        }

    }

    @Override
    public boolean update(BenhNhan victim) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_VICTIM);
            preparedStatement.setString(1, victim.getNameVictim());
            preparedStatement.setString(2, victim.getDateStart());
            preparedStatement.setString(3, victim.getDateEnd());
            preparedStatement.setString(4, victim.getReason());
            preparedStatement.setInt(5, victim.getId());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public BenhNhan getVictimByID(int id) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        BenhNhan benhNhan = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_VICTIM);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idSearch = resultSet.getInt("ID");
                int idSick = resultSet.getInt("id_sick");
                String codeVictim = resultSet.getString("code_victim");
                String nameVictim = resultSet.getString("name_victim");
                String dateStart = resultSet.getString("date_start");
                String dateEnd = resultSet.getString("date_end");
                String reason = resultSet.getString("reason");
                benhNhan = new BenhNhan(idSearch,idSick,codeVictim,nameVictim,dateStart,dateEnd,reason);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return benhNhan;
    }


}
