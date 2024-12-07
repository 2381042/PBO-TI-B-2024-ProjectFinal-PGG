package services;

import entities.Kamar;

import java.util.List;

public interface CostumerService {

    List<Kamar> getAllKamar();
    List<Kamar> cariKamarBerdasarkanJenis(String jenisKamar);
    List<Kamar> lihatDaftarKamar();
    void buatPemesanan(String nama, String nomorKamar, String checkIn, String checkOut, String metodePembayaran);
    void batalkanPemesanan(String nama, String nomorKamar);
}