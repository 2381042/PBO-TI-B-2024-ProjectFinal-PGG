package hotelReservationApp.services;

import hotelReservationApp.entities.Kamar;

import java.util.List;

public interface KamarService {
    void tambahKamar(String nomorKamar, String jenisKamar, double hargaKamar);
    Kamar cariKamar(String nomorKamar);
    List<Kamar> cariKamarBerdasarkanJenis(String jenisKamar);
    void hapusKamar(String nomorKamar);
    void updateKamar(String oldNomorKamar, String newNomorKamar, String jenisKamar, Double hargaKamar);
}