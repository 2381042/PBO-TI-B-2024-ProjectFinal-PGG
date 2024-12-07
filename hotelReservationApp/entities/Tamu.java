package hotelReservationApp.entities;

public class Tamu {
    private String nama;
    private String nomorKamar;
    private String checkIn;
    private String checkOut;

    public Tamu(String nama, String nomorKamar, String checkIn, String checkOut) {
        this.nama = nama;
        this.nomorKamar = nomorKamar;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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
}