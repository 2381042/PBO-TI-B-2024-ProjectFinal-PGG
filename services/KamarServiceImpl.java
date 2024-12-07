package services;

import entities.Kamar;
import repository.KamarRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KamarServiceImpl implements KamarService{
    private KamarRepository kamarRepository;

    public KamarServiceImpl(KamarRepository kamarRepository) {
        this.kamarRepository = kamarRepository;
    }

    @Override
    public void tambahKamar(String nomorKamar, String jenisKamar, double hargaKamar) {
        Kamar kamar = new Kamar(nomorKamar, jenisKamar, hargaKamar);
        kamarRepository.addKamar(kamar);
    }

    @Override
    public Kamar cariKamar(String nomorKamar) {
        return kamarRepository.findKamarByNomor(nomorKamar);
    }

    @Override
    public List<Kamar> cariKamarBerdasarkanJenis(String jenisKamar) {
        return kamarRepository.findKamarByJenis(jenisKamar);
    }

    @Override
    public void hapusKamar(String nomorKamar) {
        kamarRepository.deleteKamar(nomorKamar);
    }

    @Override
    public void updateKamar(String oldNomorKamar, String newNomorKamar, String jenisKamar, Double hargaKamar) {
        kamarRepository.updateKamar(oldNomorKamar,newNomorKamar,jenisKamar,hargaKamar);
    }
}