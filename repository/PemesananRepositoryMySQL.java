package repository;

import config.Database;
import entities.LaporanKeuangan;
import entities.Pemesanan;
import entities.Tamu;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PemesananRepositoryMySQL implements PemesananRepository {
    private Database database;

    public PemesananRepositoryMySQL(Database database) {
        this.database = database;
    }

    @Override
    public void tambahPemesanan(Pemesanan pemesanan) {
        String sql = "INSERT INTO pemesanan (nama, nomor_kamar, check_in, check_out, metode_pembayaran) VALUES (?, ?, ?, ?, ?)";
        String sqlRestoreKamar = "Delete From kamar WHERE nomor_kamar = ?";


        try {Connection connection = database.getConnection();
            PreparedStatement stmtRestore = connection.prepareStatement(sqlRestoreKamar);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, pemesanan.getNama());
            stmt.setString(2, pemesanan.getNomorKamar());
            stmt.setString(3, pemesanan.getCheckIn());
            stmt.setString(4, pemesanan.getCheckOut());
            stmt.setString(5, pemesanan.getMetodePembayaran());
            stmt.executeUpdate();

            stmtRestore.setString(1, pemesanan.getNomorKamar());
            stmtRestore.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pemesanan> getAllPemesanan() {
        String sql = "SELECT * FROM pemesanan";
        List<Pemesanan> pemesananList = new ArrayList<>();
        try {Connection connection = database.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                pemesananList.add(new Pemesanan(
                        rs.getString("nama"),
                        rs.getString("nomor_kamar"),
                        rs.getString("check_in"),
                        rs.getString("check_out"),
                        rs.getString("metode_pembayaran")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pemesananList;
    }

    @Override
    public List<Tamu> getAllTamu() {
        String sql = "SELECT nama, nomor_kamar, check_in, check_out FROM pemesanan";
        List<Tamu> tamuList = new ArrayList<>();
        try {Connection connection = database.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tamuList.add(new Tamu(
                        rs.getString("nama"),
                        rs.getString("nomor_kamar"),
                        rs.getString("check_in"),
                        rs.getString("check_out")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tamuList;
    }

    @Override
    public List<LaporanKeuangan> getAllLaporanKeuangan() {
        String sql = "SELECT " +
                "ROW_NUMBER() OVER (ORDER BY check_out) AS no, " +
                "check_out AS tanggal, " +
                "SUM(harga_kamar) AS pemasukkan " +
                "FROM pemesanan p " +
                "JOIN kamar k ON p.nomor_kamar = k.nomor_kamar " +
                "GROUP BY check_out";

        List<LaporanKeuangan> laporanList = new ArrayList<>();
        try {Connection connection = database.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                laporanList.add(new LaporanKeuangan(
                        rs.getInt("no"),
                        rs.getString("tanggal"),
                        rs.getDouble("pemasukkan")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laporanList;
    }

    @Override
    public void batalkanPemesanan(String nama, String nomorKamar) {
        String sqlDeletePemesanan = "DELETE FROM pemesanan WHERE nama = ? AND nomor_kamar = ?";


        try {Connection connection = database.getConnection();
            PreparedStatement stmtDelete = connection.prepareStatement(sqlDeletePemesanan);

            connection.setAutoCommit(false); // Mulai transaksi

            stmtDelete.setString(1, nama);
            stmtDelete.setString(2, nomorKamar);
            stmtDelete.executeUpdate();

            connection.commit(); // Commit transaksi
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePemesanan(Pemesanan pemesanan) {
        String sql = "UPDATE pemesanan SET check_in = ?, check_out = ?, metode_pembayaran = ? WHERE nama = ? AND nomor_kamar = ?";
        try {Connection connection = database.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, pemesanan.getCheckIn());
            stmt.setString(2, pemesanan.getCheckOut());
            stmt.setString(3, pemesanan.getMetodePembayaran());
            stmt.setString(4, pemesanan.getNama());
            stmt.setString(5, pemesanan.getNomorKamar());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}