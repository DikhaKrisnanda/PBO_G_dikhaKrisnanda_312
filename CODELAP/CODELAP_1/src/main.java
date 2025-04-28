import java.util.Scanner;
import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // untuk Input Nama
            System.out.print("Masukkan nama: ");
            String nama = scanner.nextLine();

            // untuk Input Jenis Kelamin
            System.out.print("Masukkan jenis kelamin (P/L): ");
            char jenisKelaminInput = scanner.next().charAt(0);
            String jenisKelamin;
            if (jenisKelaminInput == 'L' || jenisKelaminInput == 'l') {
                jenisKelamin = "Laki-laki";
            } else if (jenisKelaminInput == 'P' || jenisKelaminInput == 'p') {
                jenisKelamin = "Perempuan";
            } else {
                jenisKelamin = "Tidak diketahui";
            }

            // untuk Input Tahun Lahir
            System.out.print("Masukkan tahun lahir: ");
            int tahunLahir = scanner.nextInt();

            // untuk Hitung Umur
            int tahunSekarang = LocalDate.now().getYear();
            int umur = tahunSekarang - tahunLahir;

            // untuk menampilkan Output
            System.out.println("\nData Diri:");
            System.out.println("Nama          : " + nama);
            System.out.println("Jenis Kelamin : " + jenisKelamin);
            System.out.println("Umur          : " + umur + " tahun");

        } finally {
            // Pastikan program di tutup/scanne
            scanner.close();
        }
    }
}
