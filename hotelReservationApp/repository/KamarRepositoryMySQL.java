package hotelReservationApp.repository;

import hotelReservationApp.config.Database;
import hotelReservationApp.entities.Kamar;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class KamarRepositoryMySQL implements KamarRepository {
    private Database database;

    public KamarRepositoryMySQL(Database database) {
        this.database = database;
    }

    @Override
    public void addKamar(Kamar kamar) {
        String sql = "INSERT INTO kamar (nomor_kamar, jenis_kamar, harga_kamar) VALUES (?, ?, ?)";
        try {Connection connection = database.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, kamar.getNomorKamar());
            stmt.setString(2, kamar.getJenisKamar());
            stmt.setDouble(3, kamar.getHargaKamar());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public Kamar findKamarByNomor(String nomorKamar) {
        String sql = "SELECT * FROM kamar WHERE nomor_kamar = ?";
        try {Connection connection = database.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomorKamar);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Kamar(
                        rs.getString("nomor_kamar"),
                        rs.getString("jenis_kamar"),
                        rs.getDouble("harga_kamar")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Kamar> findKamarByJenis(String jenisKamar) {
        String sql = "SELECT * FROM kamar WHERE jenis_kamar = ?";
        List<Kamar> kamarList = new ArrayList<>();
        try {Connection connection = database.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, jenisKamar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                kamarList.add(new Kamar(
                        rs.getString("nomor_kamar"),
                        rs.getString("jenis_kamar"),
                        rs.getDouble("harga_kamar")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kamarList;
    }



    @Override
    public void deleteKamar(String nomorKamar) {
        String sql = "DELETE FROM kamar WHERE nomor_kamar = ?";
        try {Connection connection = database.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, nomorKamar);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateKamar(String oldNomorKamar, String newNomorKamar, String jenisKamar, Double hargaKamar){
        String sql = "UPDATE kamar set nomor_kamar = ?, jenis_kamar = ?, harga_kamar = ?  WHERE nomor_kamar = ?";
        try {Connection connection = database.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, newNomorKamar);
            stmt.setString(2, jenisKamar);
            stmt.setDouble(3, hargaKamar);
            stmt.setString(4, oldNomorKamar);


            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Kamar> findAllKamar() {
        String sql = "SELECT * FROM kamar";
        List<Kamar> kamarList = new ArrayList<>();
        try {Connection connection = database.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                kamarList.add(new Kamar(
                        rs.getString("nomor_kamar"),
                        rs.getString("jenis_kamar"),
                        rs.getDouble("harga_kamar")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kamarList;
    }
}