package hotelReservationApp.services;

import hotelReservationApp.entities.LaporanKeuangan;
import hotelReservationApp.entities.Pemesanan;
import hotelReservationApp.entities.Tamu;

import java.util.List;

public interface AdminService {


    void tambahKamar(String nomorKamar, String jenisKamar, double hargaKamar);
    void updateKamar (String oldNomorKamar, String newNomorKamar, String jenisKamar, Double hargaKamar);
    void hapusKamar(String nomorKamar);
    List<Pemesanan> riwayatPemesanan();
    List<Tamu> manajemenTamu();
    List<LaporanKeuangan> laporanKeuangan();

}