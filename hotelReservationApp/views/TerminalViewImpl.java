package hotelReservationApp.views;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class TerminalViewImpl implements TerminalView {
    CustomerViewImpl customerView;
    AdminViewImpl adminView;

    public TerminalViewImpl(CustomerViewImpl customerViewImpl, AdminViewImpl adminViewImpl) {
        this.customerView = customerViewImpl;
        this.adminView = adminViewImpl;
    }

    @Override
    public void run(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Menu Utama ===");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Customer");
            System.out.println("3. Exit");
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            if (pilihan == 1) {
                // Admin Login
                System.out.print("Masukkan Username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan Password: ");
                String password = scanner.nextLine();

                // Validasi login
                if (username.equals("admin") && password.equals("admin123")) {
                    System.out.println("Login sebagai Admin berhasil!");
                    adminView.showMenu(); // Menampilkan menu admin
                } else {
                    System.out.println("Username atau password salah.");
                }
            } else if (pilihan == 2) {
                // Customer Login
                customerView.tampilkanMenuCustomer(); // Menampilkan menu customer
            } else if (pilihan == 3) {
                System.out.println("Terima kasih, sampai jumpa!");
                break; // Keluar dari aplikasi
            } else {
                System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }

        scanner.close();
    }
}
