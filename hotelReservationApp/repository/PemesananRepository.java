package hotelReservationApp.repository;

import hotelReservationApp.entities.LaporanKeuangan;
import hotelReservationApp.entities.Pemesanan;
import hotelReservationApp.entities.Tamu;

import java.util.List;

public interface PemesananRepository {
    void tambahPemesanan(Pemesanan pemesanan);
    List<Pemesanan> getAllPemesanan();
    List<Tamu> getAllTamu();
    List<LaporanKeuangan> getAllLaporanKeuangan();
    void batalkanPemesanan(String nama, String nomorKamar);
    void updatePemesanan(Pemesanan pemesanan);
}