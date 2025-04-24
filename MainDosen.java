import java.util.Scanner;

public class MainDosen {

    private static int tahunSekarang;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        DataDosen[] dataDosen = {
            new DataDosen(110506, "Deddy", "deddy@gmail.com",2013, "SIB"),
            new DataDosen(112030
            10507, "Vivin","vivin@gmail.com", 2014,"TI"),
            new DataDosen(110508, "Hendra","hendra@gmail.com", 2015,"TI"),
        };

        System.out.print("Tahun Sekarang : ");
        int tahunSekarang = input.nextInt();
        int pilihan;
        do {
            System.out.println("\n=== Menu Sistem Data Dosen ===");
            System.out.println("1. Tampilkan Semua Dosen");
            System.out.println("2. Urutkan Berdasarkan NIDN (Ascending)");
            System.out.println("3. Cari Dosen Berdasarkan Nama");
            System.out.println("4. Urutkan Berdasarkan Masa Kerja (Descending)");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu : ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                  for (DataDosen dosen : dataDosen){
                    dosen.tampilkanSemuaDosen(tahunSekarang);
                  }
                    break;
                case 2:
                    urutkanNIDN(dataDosen);
                    for (DataDosen dosen : dataDosen){
                    dosen.tampilkanSemuaDosen(tahunSekarang);    
                    }
                    break;
                case 3:
                    cariDosenNama(dataDosen, input);
                    break;
                case 4:
                    urutkanMasaKerja(dataDosen);
                    for (DataDosen dosen : dataDosen){
                    dosen.tampilkanSemuaDosen(tahunSekarang);    
                    }
                    break;
                case 0:
                    System.out.println("Terima kasih! Sampai jumpa.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);
    }


//Bubble sort - ascending
    public static void urutkanNIDN(DataDosen[] dataDosen) {
        for (int i = 0; i < dataDosen.length - 1; i++) {
            for (int j = 0; j < dataDosen.length - i - 1; j++) {
                if (dataDosen[j].NIDN > dataDosen[j + 1].NIDN) {
                    DataDosen temp = dataDosen[j];
                    dataDosen[j] = dataDosen[j + 1];
                    dataDosen[j + 1] = temp;
                }
            }
        }
    }
//Sequential searching
    public static void cariDosenNama(DataDosen[] dataDosen, Scanner input) {
        System.out.print("Masukkan Nama Dosen: ");
        String namaCari = input.nextLine();
        boolean ditemukan = false;

        for (DataDosen dosen : dataDosen) {
            if (dosen.nama.equalsIgnoreCase(namaCari)) {
                dosen.tampilkanSemuaDosen(tahunSekarang);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Dosen tidak ditemukan.");
        }
    }
// selection sort - descending
    public static void urutkanMasaKerja(DataDosen[] dataDosen) {
        for (int i = 0; i < dataDosen.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < dataDosen.length; j++) {
                if (dataDosen[j].hitungMasaKerja(maxIdx) > dataDosen[maxIdx].hitungMasaKerja(maxIdx)) {
                    maxIdx = j;
                }
            }
            DataDosen temp = dataDosen[i];
            dataDosen[i] = dataDosen[maxIdx];
            dataDosen[maxIdx] = temp;
        }
    }
    
}


    