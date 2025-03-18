// Kelas untuk Hewan
class Hewan {
    String nama;
    String jenis;
    String suara;

    // bagian Proses
    public Hewan(String nama, String jenis, String suara) {
        this.nama = nama;
        this.jenis = jenis;
        this.suara = suara;
    }

    // Metode untuk menyapa
    public void sapaan() {
        System.out.println("Halo! Aku adalah seekor " + nama + " >.<");
    }

    // Metode untuk menampilkan informasi hewan
    public void tampilkanInfo() {
        sapaan();
        System.out.println("---------------------------");
        System.out.println("Nama  : " + nama);
        System.out.println("Jenis : " + jenis);
        System.out.println("Suara : " + suara);
        System.out.println("---------------------------\n");
    }
}


public class Hewan {
    public static void main(String[] args) {
        // Membuat objek hewan
        Hewan hewan1 = new Hewan("Kucing", "Mamalia", "Nyann~~");
        Hewan hewan2 = new Hewan("Anjing", "Mamalia", "Woof-Woof!!");

        // Menampilkan informasi hewan
        hewan1.tampilkanInfo();
        hewan2.tampilkanInfo();
    }
}