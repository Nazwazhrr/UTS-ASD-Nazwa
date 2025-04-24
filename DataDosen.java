public class DataDosen {
    int NIDN;
    String nama;
    String email;
    int tahunMasuk;
    String Prodi;

    public DataDosen(int NIDN, String nama, String email, int tahunMasuk, String Prodi) {
        this.NIDN = NIDN;
        this.nama = nama;
        this.email = email;
        this.tahunMasuk = tahunMasuk;
        this.Prodi = Prodi;
    }

    public int hitungMasaKerja(int tahunSekarang) {
        return tahunSekarang - tahunMasuk;
    }


    void tampilkanSemuaDosen(int tahunSekarang) {
        System.out.println("------------------");
        System.out.println("NIDN : " + NIDN);
        System.out.println("Nama : " + nama);
        System.out.println("Email : " + email);
        System.out.println("Masa Kerja : " + hitungMasaKerja(tahunSekarang));
        System.out.println("Prodi : " + Prodi);
    }
}