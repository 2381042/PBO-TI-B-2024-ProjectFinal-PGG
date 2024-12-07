package services;

import entities.LaporanKeuangan;
import entities.Pemesanan;
import entities.Tamu;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminServiceImpl implements AdminService {
    private KamarServiceImpl kamarService;
    private PemesananServiceImpl pemesananService;


    public AdminServiceImpl(KamarServiceImpl kamarServiceImpl, PemesananServiceImpl pemesananServiceImpl) {
        this.kamarService = kamarServiceImpl;
        this.pemesananService = pemesananServiceImpl;
    }

    @Override
    public void tambahKamar(String nomorKamar, String jenisKamar, double hargaKamar) {
        kamarService.tambahKamar(nomorKamar, jenisKamar, hargaKamar);
    }

    @Override
    public void updateKamar (String oldNomorKamar, String newNomorKamar, String jenisKamar, Double hargaKamar){
        kamarService.updateKamar(oldNomorKamar,newNomorKamar,jenisKamar,hargaKamar);
    }

    @Override
    public void hapusKamar(String nomorKamar) {
        kamarService.hapusKamar(nomorKamar);
    }

    @Override
    public List<Pemesanan> riwayatPemesanan() {
        return pemesananService.getRiwayatPemesanan();
    }

    @Override
    public List<Tamu> manajemenTamu() {
        return pemesananService.getManajemenTamu();
    }

    @Override
    public List<LaporanKeuangan> laporanKeuangan() {
        return pemesananService.getLaporanKeuangan();
    }
}