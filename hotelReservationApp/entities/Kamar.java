package hotelReservationApp.entities;

public class Kamar {
    private String nomorKamar;
    private String jenisKamar;
    private double hargaKamar;

    public Kamar(String nomorKamar, String jenisKamar, double hargaKamar) {
        this.nomorKamar = nomorKamar;
        this.jenisKamar = jenisKamar;
        this.hargaKamar = hargaKamar;
    }

    public String getNomorKamar() {
        return nomorKamar;
    }

    public String getJenisKamar() {
        return jenisKamar;
    }

    public double getHargaKamar() {
        return hargaKamar;
    }
}