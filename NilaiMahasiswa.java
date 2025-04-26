
    import java.util.Scanner;

public class NilaiMahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input data
        System.out.print("Masukkan NIM: ");
        String nim = input.nextLine();
        
        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        
        System.out.print("Masukkan Nilai UTS: ");
        double uts = input.nextDouble();
        
        System.out.print("Masukkan Nilai UAS: ");
        double uas = input.nextDouble();

        // Hitung nilai akhir
        double nilaiAkhir = (uts + uas) / 2;

        // Tentukan grade
        char grade;
        if (nilaiAkhir >= 85) {
            grade = 'A';
        } else if (nilaiAkhir >= 70) {
            grade = 'B';
        } else if (nilaiAkhir >= 60) {
            grade = 'C';
        } else if (nilaiAkhir >= 50) {
            grade = 'D';
        } else {
            grade = 'E';
        }

        // Output
        System.out.println("\n===============================");
        System.out.println("NIM\t\t: " + nim);
        System.out.println("Nama\t\t: " + nama);
        System.out.println("Nilai Akhir\t: " + nilaiAkhir);
        System.out.println("Grade\t\t: " + grade);
        System.out.println("===============================");

        input.close();
    }
}

