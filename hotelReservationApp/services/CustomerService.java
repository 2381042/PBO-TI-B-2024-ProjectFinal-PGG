package hotelReservationApp.services;

import hotelReservationApp.entities.Kamar;

import java.util.List;

public interface CustomerService {

    List<Kamar> getAllKamar();
    List<Kamar> cariKamarBerdasarkanJenis(String jenisKamar);
    List<Kamar> lihatDaftarKamar();
    void buatPemesanan(String nama, String nomorKamar, String checkIn, String checkOut, String metodePembayaran);
    void batalkanPemesanan(String nama, String nomorKamar);
}