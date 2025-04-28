import java.text.NumberFormat;
import java.util.Locale;

// Kelas Rekening Bank
class RekeningBank {
    private String nomorRekening;
    private String namaPemilik;
    private double saldo;

    // Konstruktor atau method
    public RekeningBank(String nomorRekening, String namaPemilik, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
        System.out.println("Rekening atas nama " + namaPemilik + " berhasil dibuat!\n");
    }

    // untuk menampilkan informasi rekening
    public void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: " + formatUang(saldo));
        System.out.println("----------------------------");
    }

    // Metode untuk menyetor uang
    public void setorUang(double jumlah) {
        if (jumlah > 0) {
            try {
                System.out.println("\nMemproses setoran " + namaPemilik + "...");
                Thread.sleep(1500); //di sini saya menambahkan Animasi simulasi pemrosesan transaksi dengan thread.sleep
            } catch (InterruptedException e) {
                System.out.println("Terjadi kesalahan!");
            }
            saldo += jumlah;
            System.out.println(namaPemilik + " menyetor " + formatUang(jumlah) + ".");
            System.out.println(" Saldo sekarang: " + formatUang(saldo) + "\n");
        } else {
            System.out.println("Jumlah setoran harus lebih dari 0!\n");
        }
    }

    // Metode untuk menarik uang
    public void tarikUang(double jumlah) {
        System.out.println("\nMemproses penarikan " + namaPemilik + "...");
        try {
            Thread.sleep(1500);//di sini saya menambahkan Animasi simulasi pemrosesan transaksi dengan thread.sleep
        } catch (InterruptedException e) {
            System.out.println("Terjadi kesalahan!");
        }

        if (jumlah > saldo) {
            System.out.println(" Penarikan gagal! Saldo tidak mencukupi.");
            System.out.println(" Saldo saat ini: " + formatUang(saldo) + "\n");
        } else {
            saldo -= jumlah;
            System.out.println(namaPemilik + " berhasil menarik " + formatUang(jumlah));
            System.out.println(" Saldo sekarang: " + formatUang(saldo) + "\n");
        }
    }

    // Metode untuk format saldo dalam Rupiah
    private String formatUang(double jumlah) {
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        return formatRupiah.format(jumlah);
    }
}

public class main {
    public static void main(String[] args) {
        // Membuat dua objek rekening bank
        RekeningBank rekening1 = new RekeningBank("202410370110312", "Dikha Krisnanda", 500000);
        RekeningBank rekening2 = new RekeningBank("202410370110310", "Barry Mahardika", 1000000);

        // Menampilkan informasi awal
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        // Simulasi transaksi
        rekening1.setorUang(200000);
        rekening2.setorUang(500000);

        rekening1.tarikUang(800000); // Gagal karena saldo tidak mencukupi
        rekening2.tarikUang(300000); // Berhasil

        // Menampilkan informasi rekening setelah transaksi
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}
