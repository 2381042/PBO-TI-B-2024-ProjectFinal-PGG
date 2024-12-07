package hotelReservationApp.services;

import hotelReservationApp.entities.Pemesanan;
import hotelReservationApp.repository.PemesananRepository;
import hotelReservationApp.entities.Tamu;
import hotelReservationApp.entities.LaporanKeuangan;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class PemesananServiceImpl implements PemesananService {
    private PemesananRepository pemesananRepository;

    public PemesananServiceImpl(PemesananRepository pemesananRepository) {
        this.pemesananRepository = pemesananRepository;
    }

    @Override
    public void buatPemesanan(String nama, String nomorKamar, String checkIn, String checkOut, String metodePembayaran) {
        Pemesanan pemesanan = new Pemesanan(nama, nomorKamar, checkIn, checkOut, metodePembayaran);
        pemesananRepository.tambahPemesanan(pemesanan);
    }

    @Override
    public List<Pemesanan> getRiwayatPemesanan() {
        return pemesananRepository.getAllPemesanan();
    }

    @Override
    public List<Tamu> getManajemenTamu() {
        return pemesananRepository.getAllTamu();
    }

    @Override
    public List<LaporanKeuangan> getLaporanKeuangan() {
        return pemesananRepository.getAllLaporanKeuangan();
    }
}
