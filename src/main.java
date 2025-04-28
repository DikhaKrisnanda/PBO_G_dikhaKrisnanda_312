// Kelas dasar untuk semua karakter dalam game
class KarakterGame {
    private String nama; // Nama karakter
    private int kesehatan; // Jumlah poin kesehatan karakter

    // Konstruktor untuk mengatur nama dan kesehatan saat karakter dibuat
    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    // Method untuk mendapatkan nama karakter
    public String getNama() {
        return nama;
    }

    // Method untuk mendapatkan jumlah kesehatan karakter
    public int getKesehatan() {
        return kesehatan;
    }

    // Method untuk mengatur kesehatan, tapi tidak boleh kurang dari 0
    public void setKesehatan(int kesehatan) {
        this.kesehatan = Math.max(kesehatan, 0);
    }

    // Method dasar untuk menyerang, akan diubah oleh subclass
    public void serang(KarakterGame target) {
        System.out.println(nama + " menyerang " + target.getNama() + "!");
    }
}

// Kelas Pahlawan yang merupakan turunan dari KarakterGame
class Pahlawan extends KarakterGame {
    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan); // Panggil konstruktor dari KarakterGame
    }

    // Pahlawan punya cara menyerang yang berbeda, jadi kita override method serang
    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Orbital Strike!");
        target.setKesehatan(target.getKesehatan() - 20); // Musuh kehilangan 20 poin kesehatan
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}

// Kelas Musuh yang juga turunan dari KarakterGame
class Musuh extends KarakterGame {
    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan); // Panggil konstruktor dari KarakterGame
    }

    // Musuh juga punya cara menyerang sendiri
    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Snake Bite!");
        target.setKesehatan(target.getKesehatan() - 15); // Pahlawan kehilangan 15 poin kesehatan
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}

// Kelas utama untuk menjalankan program
public class main {
    public static void main(String[] args) {
        // Buat objek karakter dengan kesehatan masing-masing
        Pahlawan pahlawan = new Pahlawan("Brimstone", 150);
        Musuh musuh = new Musuh("Viper", 200);

        // Tampilkan status awal karakter
        System.out.println("=== STATUS AWAL ===");
        System.out.println(pahlawan.getNama() + " memiliki kesehatan: " + pahlawan.getKesehatan());
        System.out.println(musuh.getNama() + " memiliki kesehatan: " + musuh.getKesehatan());
        System.out.println("===================");

        // Simulasi pertarungan
        pahlawan.serang(musuh); // Brimstone menyerang Viper
        musuh.serang(pahlawan); // Viper membalas serangan Brimstone

        // Tampilkan status akhir setelah serangan
        System.out.println("=== PERTARUNGAN SELESAI ===");
    }
}
