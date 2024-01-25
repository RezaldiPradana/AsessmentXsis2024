import java.util.ArrayList;

public class No4 {
    static boolean isPrime(int angka) {
        if (angka <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(angka); i++) {
            if (angka % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void tampilkanBilanganPrima(int n) {
        int jumlahPrima = 0;
        int angka = 2; 

        System.out.println("N bilangan prima pertama:");

        while (jumlahPrima < n) {
            if (isPrime(angka)) {
                System.out.print(angka + " ");
                jumlahPrima++;
            }
            angka++;
        }
    }

    public static void main(String[] args) {
        int n = 10; 
        tampilkanBilanganPrima(n);
    }
}