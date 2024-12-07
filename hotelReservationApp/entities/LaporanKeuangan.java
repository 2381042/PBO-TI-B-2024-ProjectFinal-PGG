package hotelReservationApp.entities;

public class LaporanKeuangan {
    private int no;
    private String tanggal;
    private double pemasukkan;

    public LaporanKeuangan(int no, String tanggal, double pemasukkan) {
        this.no = no;
        this.tanggal = tanggal;
        this.pemasukkan = pemasukkan;
    }

    public int getNo() {
        return no;
    }

    public String getTanggal() {
        return tanggal;
    }

    public double getPemasukkan() {
        return pemasukkan;
    }
}