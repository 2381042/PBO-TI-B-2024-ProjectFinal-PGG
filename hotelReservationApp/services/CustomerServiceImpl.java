package hotelReservationApp.services;

import hotelReservationApp.entities.Kamar;
import hotelReservationApp.entities.Pemesanan;
import hotelReservationApp.repository.KamarRepository;
import hotelReservationApp.repository.PemesananRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerServiceImpl implements CostumerService {
    private KamarRepository kamarRepository;
    private PemesananRepository pemesananRepository;

    public CustomerServiceImpl(KamarRepository kamarRepository, PemesananRepository pemesananRepository) {
        this.kamarRepository = kamarRepository;
        this.pemesananRepository = pemesananRepository;
    }
    @Override
    public List<Kamar> getAllKamar() {
        return kamarRepository.findAllKamar();
    }

    @Override
    public List<Kamar> cariKamarBerdasarkanJenis(String jenisKamar) {
        return kamarRepository.findKamarByJenis(jenisKamar);
    }

    @Override
    public List<Kamar> lihatDaftarKamar() {
        return kamarRepository.findAllKamar();
    }

    @Override
    public void buatPemesanan(String nama, String nomorKamar, String checkIn, String checkOut, String metodePembayaran) {
        Kamar kamar = kamarRepository.findKamarByNomor(nomorKamar);
        if (kamar == null) {
            throw new RuntimeException("Kamar tidak ditemukan");
        }else {
            Pemesanan pemesanan = new Pemesanan(nama, nomorKamar, checkIn, checkOut, metodePembayaran);
            pemesananRepository.tambahPemesanan(pemesanan);
        }
    }
    @Override
    public void batalkanPemesanan(String nama, String nomorKamar) {
        pemesananRepository.batalkanPemesanan(nama, nomorKamar);
    }
}