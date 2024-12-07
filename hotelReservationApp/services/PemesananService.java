package hotelReservationApp.services;

import hotelReservationApp.entities.LaporanKeuangan;
import hotelReservationApp.entities.Pemesanan;
import hotelReservationApp.entities.Tamu;

import java.util.List;

public interface PemesananService {

    void buatPemesanan(String nama, String nomorKamar, String checkIn, String checkOut, String metodePembayaran);
    List<Pemesanan> getRiwayatPemesanan();
    List<Tamu> getManajemenTamu();
    List<LaporanKeuangan> getLaporanKeuangan();
}
