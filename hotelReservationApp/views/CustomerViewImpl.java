package hotelReservationApp.views;

import hotelReservationApp.entities.Kamar;
import hotelReservationApp.services.CustomerServiceImpl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class CustomerViewImpl implements CustomerView {
    private final Scanner scanner = new Scanner(System.in);
    private final CustomerServiceImpl customerService;

    public CustomerViewImpl(CustomerServiceImpl customerServiceImpl) {
        this.customerService = customerServiceImpl;
    }
    @Override
    public void tampilkanMenuCustomer() {
        int pilihan;
        do {
            System.out.println("\n===== Menu Customer =====");
            System.out.println("1. Cari Kamar");
            System.out.println("2. Lihat Daftar Kamar");
            System.out.println("3. Pemesanan Kamar");
            System.out.println("4. Batalkan Pemesanan");
            System.out.println("5. Pembayaran");
            System.out.println("6. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer input

            switch (pilihan) {
                case 1 -> cariKamar();
                case 2 -> lihatDaftarKamar();
                case 3 -> pemesananKamar();
                case 4 -> batalkanPemesanan();
                case 5 -> pembayaran();
                case 6 -> {
                    return;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 6);
    }

    private void cariKamar() {
        System.out.print("Masukkan jenis kamar yang diinginkan (Large/Medium/Small): ");
        String jenisKamar = scanner.nextLine();
        System.out.println("\nKamar dengan jenis " + jenisKamar + " tersedia:");

        List<Kamar> kamarTersedia = customerService.cariKamarBerdasarkanJenis(jenisKamar);
        kamarTersedia.forEach(kamar -> System.out.printf("Nomor Kamar: %s, Jenis Kamar: %s, Harga: %.2f\n",
                kamar.getNomorKamar(), kamar.getJenisKamar(), kamar.getHargaKamar()));
    }

    private void lihatDaftarKamar() {
        List<Kamar> kamarList = customerService.getAllKamar();
        System.out.println("=== Daftar Kamar ===");
        for (Kamar kamar : kamarList) {
            System.out.println("Nomor Kamar: " + kamar.getNomorKamar() + ", Jenis Kamar: " + kamar.getJenisKamar() + ", Harga: " + kamar.getHargaKamar());
        }
    }

    private void batalkanPemesanan() {
        System.out.print("Masukkan nama pemesan: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan nomor kamar: ");
        String nomorKamar = scanner.nextLine();
        customerService.batalkanPemesanan(nama, nomorKamar);
        System.out.println("Pemesanan berhasil dibatalkan.");
    }

    private void pembayaran() {
        System.out.print("Masukkan nama pemesan: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan nomor kamar: ");
        String nomorKamar = scanner.nextLine();
        // Implementasi pembayaran sesuai kebutuhan
        System.out.println("Pembayaran untuk " + nama + " pada kamar " + nomorKamar + " berhasil.");
    }

    private void pemesananKamar() {
        System.out.print("Masukkan nama Anda: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan nomor kamar yang ingin dipesan: ");
        String nomorKamar = scanner.nextLine();
        System.out.print("Masukkan tanggal check-in (yyyy-mm-dd): ");
        String tanggalCheckIn = scanner.nextLine();
        System.out.print("Masukkan tanggal check-out (yyyy-mm-dd): ");
        String tanggalCheckOut = scanner.nextLine();
        System.out.print("Masukkan metode pembayaran: ");
        String metodePembayaran = scanner.nextLine();

        try {
            customerService.buatPemesanan(nama, nomorKamar, tanggalCheckIn, tanggalCheckOut, metodePembayaran);
            System.out.println("Pemesanan berhasil!");
        } catch (Exception e) {
            System.out.println("Pemesanan gagal: " + e.getMessage());
        }
    }
}