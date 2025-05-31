package REMED;

import java.util.*;


class RumusFisika {

    String nama;        
    String rumus;       
    String satuan;      

    
    RumusFisika(String nama, String rumus, String satuan) {
        this.nama = nama;
        this.rumus = rumus;
        this.satuan = satuan;
    }

    
    double hitung(double[] nilai) {
        return 0.0; 
    }

    
    String[] getInputLabel() {
        return new String[]{}; 
    }
}


class Gaya extends RumusFisika {
    Gaya() {
        super("Gaya", "F = m * a", "N");
    }

    @Override
    double hitung(double[] nilai) {
        return nilai[0] * nilai[1];
    }

    @Override
    String[] getInputLabel() {
        return new String[]{"massa (kg)", "percepatan (m/s^2)"};
    }
}


class EnergiKinetik extends RumusFisika {
    EnergiKinetik() {
        super("Energi Kinetik", "Ek = ½ * m * v^2", "J");
    }

    @Override
    double hitung(double[] nilai) {
        return 0.5 * nilai[0] * nilai[1] * nilai[1];
    }

    @Override
    String[] getInputLabel() {
        return new String[]{"massa (kg)", "kecepatan (m/s)"};
    }
}


class EnergiPotensial extends RumusFisika {
    EnergiPotensial() {
        super("Energi Potensial", "Ep = m * g * h", "J");
    }

    @Override
    double hitung(double[] nilai) {
        double GRAVITASI = 10.0;
        return nilai[0] * GRAVITASI * nilai[1];
    }

    @Override
    String[] getInputLabel() {
        return new String[]{"massa (kg)", "tinggi (m)"};
    }
}


class Kecepatan extends RumusFisika {
    Kecepatan() {
        super("Kecepatan", "v = s ÷ t", "m/s");
    }

    @Override
    double hitung(double[] nilai) {
        return nilai[0] / nilai[1];
    }

    @Override
    String[] getInputLabel() {
        return new String[]{"jarak (m)", "waktu (s)"};
    }
}


class Usaha extends RumusFisika {
    Usaha() {
        super("Usaha", "W = F * s", "J");
    }

    @Override
    double hitung(double[] nilai) {
        return nilai[0] * nilai[1];
    }

    @Override
    String[] getInputLabel() {
        return new String[]{"gaya (N)", "jarak (m)"};
    }
}


class Daya extends RumusFisika {
    Daya() {
        super("Daya", "P = W ÷ t", "W");
    }

    @Override
    double hitung(double[] nilai) {
        return nilai[0] / nilai[1];
    }

    @Override
    String[] getInputLabel() {
        return new String[]{"usaha (J)", "waktu (s)"};
    }
}


class Momentum extends RumusFisika {
    Momentum() {
        super("Momentum", "p = m * v", "kg⋅m/s");
    }

    @Override
    double hitung(double[] nilai) {
        return nilai[0] * nilai[1];
    }

    @Override
    String[] getInputLabel() {
        return new String[]{"massa (kg)", "kecepatan (m/s)"};
    }
}


class Percepatan extends RumusFisika {
    Percepatan() {
        super("Percepatan", "a = (v2 - v1) ÷ t", "m/s^2");
    }

    @Override
    double hitung(double[] nilai) {
        return (nilai[1] - nilai[0]) / nilai[2];
    }

    @Override
    String[] getInputLabel() {
        return new String[]{"kecepatan awal (m/s)", "kecepatan akhir (m/s)", "waktu (s)"};
    }
}


class Tekanan extends RumusFisika {
    Tekanan() {
        super("Tekanan", "P = F ÷ A", "Pa");
    }

    @Override
    double hitung(double[] nilai) {
        return nilai[0] / nilai[1];
    }

    @Override
    String[] getInputLabel() {
        return new String[]{"gaya (N)", "luas permukaan (m^2)"};
    }
}


class MassaJenis extends RumusFisika {
    MassaJenis() {
        super("Massa Jenis", "p = m ÷ V", "kg/m^3");
    }

    @Override
    double hitung(double[] nilai) {
        return nilai[0] / nilai[1];
    }

    @Override
    String[] getInputLabel() {
        return new String[]{"massa (kg)", "volume (m^3)"};
    }
}


public class KalkulatorFisika {

    static Scanner scanner = new Scanner(System.in);
    

    static ArrayList<RumusFisika> daftarRumus = new ArrayList<>();

    public static void main(String[] args) {

        daftarRumus.add(new Gaya());
        daftarRumus.add(new EnergiKinetik());
        daftarRumus.add(new EnergiPotensial());
        daftarRumus.add(new Kecepatan());
        daftarRumus.add(new Usaha());
        daftarRumus.add(new Daya());
        daftarRumus.add(new Momentum());
        daftarRumus.add(new Percepatan());
        daftarRumus.add(new Tekanan());
        daftarRumus.add(new MassaJenis());

        while (true) {
            
            tampilkanMenu();
            int pilihan = bacaAngka("Pilih rumus (1-" + daftarRumus.size() + ", 0 untuk keluar): ", 0, daftarRumus.size());


            if (pilihan == 0) {
                System.out.println("\nTerima kasih telah menggunakan Kalkulator Fisika!");
                scanner.close();
                break;
            }


            hitungRumus(pilihan);


            System.out.println("\nTekan Enter untuk melanjutkan...");
            scanner.nextLine();
        }
    }


    static void tampilkanMenu() {
        System.out.println("\n=== Kalkulator Rumus Fisika ===");

        for (int i = 0; i < daftarRumus.size(); i++) {
            RumusFisika rumus = daftarRumus.get(i);
            System.out.println((i + 1) + ". " + rumus.nama + " (" + rumus.rumus + ")");
        }
        System.out.println("0. Keluar");
    }

    static void hitungRumus(int pilihan) {

        RumusFisika rumus = daftarRumus.get(pilihan - 1);
        System.out.println("\n=== Menghitung " + rumus.nama + " ===");


        String[] labels = rumus.getInputLabel();
        double[] nilai = new double[labels.length];


        for (int i = 0; i < labels.length; i++) {
            nilai[i] = bacaAngkaDesimal("Masukkan " + labels[i] + ": ");
        }


        double hasil = rumus.hitung(nilai);
        System.out.printf("%s = %.2f %s%n", rumus.nama, hasil, rumus.satuan);
    }


    static int bacaAngka(String pesan, int min, int max) {
        while (true) {
            try {
                System.out.print(pesan);
                int nilai = Integer.parseInt(scanner.nextLine());
                if (nilai >= min && nilai <= max) {
                    return nilai;
                }
                System.out.println("Masukkan angka antara " + min + " dan " + max + "!");
            } catch (Exception e) {
                System.out.println("Masukkan angka yang valid!");
            }
        }
    }


    static double bacaAngkaDesimal(String pesan) {
        while (true) {
            try {
                System.out.print(pesan);
                double nilai = Double.parseDouble(scanner.nextLine());
                if (nilai >= 0) {
                    return nilai;
                }
                System.out.println("Masukkan angka positif!");
            } catch (Exception e) {
                System.out.println("Masukkan angka yang valid!");
            }
        }
    }
} 