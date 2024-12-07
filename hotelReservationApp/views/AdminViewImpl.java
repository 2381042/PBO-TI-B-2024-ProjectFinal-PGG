package hotelReservationApp.views;

import hotelReservationApp.entities.Kamar;
import hotelReservationApp.entities.LaporanKeuangan;
import hotelReservationApp.entities.Pemesanan;
import hotelReservationApp.entities.Tamu;
import hotelReservationApp.services.AdminServiceImpl;
import hotelReservationApp.services.CustomerServiceImpl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class AdminViewImpl implements AdminView{
    private AdminServiceImpl adminService;
    private Scanner scanner;
    CustomerServiceImpl customerService;


    public AdminViewImpl(AdminServiceImpl adminServiceImpl, CustomerServiceImpl customerServiceImpl) {
        this.adminService = adminServiceImpl;
        this.customerService = customerServiceImpl;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        while (true) {
            System.out.println("\nMenu Admin:");
            System.out.println("1. Tambah Kamar");
            System.out.println("2. Hapus Kamar");
            System.out.println("3. Update Kamar");
            System.out.println("4. Manajemen Tamu");
            System.out.println("5. Riwayat Pemesanan");
            System.out.println("6. Laporan Keuangan");
            System.out.println("7. Kembali ke Menu Utama");
            System.out.print("Pilih pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    lihatDaftarKamar();
                    tambahKamar();
                    break;
                case 2:
                    lihatDaftarKamar();
                    hapusKamar();
                    break;
                case 3:
                    lihatDaftarKamar();
                    updatekamar();
                    break;
                case 4:
                    manajemenTamu();
                    break;
                case 5:
                    riwayatPemesanan();
                    break;
                case 6:
                    laporanKeuangan();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void lihatDaftarKamar() {
        List<Kamar> kamarList = customerService.getAllKamar();
        System.out.println("=== Daftar Kamar ===");
        for (Kamar kamar : kamarList) {
            System.out.println("Nomor Kamar: " + kamar.getNomorKamar() + ", Jenis Kamar: " + kamar.getJenisKamar() + ", Harga: " + kamar.getHargaKamar());
        }
    }

    private void tambahKamar() {
        System.out.print("Nomor Kamar: ");
        String nomorKamar = scanner.nextLine();
        System.out.print("Jenis Kamar (Large/Medium/Small): ");
        String jenisKamar = scanner.nextLine();
        System.out.print("Harga Kamar: ");
        double hargaKamar = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        adminService.tambahKamar(nomorKamar, jenisKamar, hargaKamar);
        System.out.println("Kamar berhasil ditambahkan!");
    }

    private void hapusKamar() {
        System.out.print("Masukkan Nomor Kamar yang ingin dihapus: ");
        String nomorKamar = scanner.nextLine();

        adminService.hapusKamar(nomorKamar);
        System.out.println("Kamar berhasil dihapus!");
    }

    private void updatekamar() {
        System.out.print("Masukkan Nomor Kamar yang ingin diUpdate: ");
        String oldNomorKamar = scanner.nextLine();

        System.out.print("Masukkan Nomor Kamar yang Baru : ");
        String newNomorKamar = scanner.nextLine();

        System.out.print("Maukkan Jenis Kamar yang Baru : ");
        String jenisKamar = scanner.nextLine();

        System.out.print("Masukkan Harga Kamar yang Baru: ");
        Double hargaKamar = scanner.nextDouble();

        adminService.updateKamar(oldNomorKamar, newNomorKamar, jenisKamar, hargaKamar);
        System.out.println("Kamar berhasil diupdate!");
    }

    private void manajemenTamu() {
        List<Tamu> tamuList = adminService.manajemenTamu();
        System.out.println("\nDaftar Tamu:");
        for (Tamu tamu : tamuList) {
            System.out.printf("%s | %s | %s | %s\n", tamu.getNama(), tamu.getNomorKamar(), tamu.getCheckIn(), tamu.getCheckOut());
        }
    }

    private void riwayatPemesanan() {
        List<Pemesanan> pemesananList = adminService.riwayatPemesanan();
        System.out.println("\nRiwayat Pemesanan:");
        for (Pemesanan pemesanan : pemesananList) {
            System.out.printf("%s | %s | %s | %s\n", pemesanan.getNama(), pemesanan.getNomorKamar(), pemesanan.getCheckIn(), pemesanan.getMetodePembayaran());
        }
    }

    private void laporanKeuangan() {
        List<LaporanKeuangan> laporanList = adminService.laporanKeuangan();
        double totalPemasukan = 0;
        System.out.println("\nLaporan Keuangan:");
        for (LaporanKeuangan laporan : laporanList) {
            System.out.printf("%d | %s | %.2f\n", laporan.getNo(), laporan.getTanggal(), laporan.getPemasukkan());
            totalPemasukan += laporan.getPemasukkan();
        }
        System.out.println("Total Pemasukan: " + totalPemasukan);
    }
}