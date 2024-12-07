package hotelReservationApp.entities;

public class Pemesanan {
    private String nama;
    private String nomorKamar;
    private String checkIn;
    private String checkOut;
    private String metodePembayaran;

    public Pemesanan(String nama, String nomorKamar, String checkIn, String checkOut, String metodePembayaran) {
        this.nama = nama;
        this.nomorKamar = nomorKamar;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.metodePembayaran = metodePembayaran;
    }

    public String getNama() {
        return nama;
    }

    public String getNomorKamar() {
        return nomorKamar;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }
}