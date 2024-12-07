package repository;

import entities.Kamar;
import java.util.List;

public interface KamarRepository {
    void addKamar(Kamar kamar);
    Kamar findKamarByNomor(String nomorKamar);
    List<Kamar> findKamarByJenis(String jenisKamar);
    void deleteKamar(String nomorKamar);
    List<Kamar> findAllKamar();
    void updateKamar(String oldNomorKamar, String newNomorKamar, String jenisKamar, Double hargaKamar);
}