package repository;

import entities.LaporanKeuangan;
import entities.Pemesanan;
import entities.Tamu;

import java.util.List;

public interface PemesananRepository {
    void tambahPemesanan(Pemesanan pemesanan);
    List<Pemesanan> getAllPemesanan();
    List<Tamu> getAllTamu();
    List<LaporanKeuangan> getAllLaporanKeuangan();
    void batalkanPemesanan(String nama, String nomorKamar);
    void updatePemesanan(Pemesanan pemesanan);
}