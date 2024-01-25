import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No7 {
    public static void main(String[] args) {
        int[] deretAngka = {8, 7, 0, 2, 7, 1, 7, 6, 3, 0, 7, 1, 3, 4, 6, 1, 6, 4, 3};

        double mean = hitungMean(deretAngka);
        System.out.println("Mean: " + mean);

        double median = hitungMedian(deretAngka);
        System.out.println("Median: " + median);

        int[] modus = hitungModus(deretAngka);
        System.out.print("Modus: ");
        for (int nilaiModus : modus) {
            System.out.print(nilaiModus + " ");
        }
    }

    static double hitungMean(int[] deretAngka) {
        int total = 0;
        for (int angka : deretAngka) {
            total += angka;
        }
        return (double) total / deretAngka.length;
    }

    static double hitungMedian(int[] deretAngka) {
        Arrays.sort(deretAngka);

        int panjang = deretAngka.length;
        if (panjang % 2 == 0) {
            int tengah1 = deretAngka[panjang / 2 - 1];
            int tengah2 = deretAngka[panjang / 2];
            return (double) (tengah1 + tengah2) / 2;
        } else {
            return deretAngka[panjang / 2];
        }
    }

    static int[] hitungModus(int[] deretAngka) {
        Map<Integer, Integer> frekuensi = new HashMap<>();

        for (int angka : deretAngka) {
            frekuensi.put(angka, frekuensi.getOrDefault(angka, 0) + 1);
        }

        int maxFrekuensi = 0;
        for (int value : frekuensi.values()) {
            if (value > maxFrekuensi) {
                maxFrekuensi = value;
            }
        }

        int jumlahModus = 0;
        for (int key : frekuensi.keySet()) {
            if (frekuensi.get(key) == maxFrekuensi) {
                jumlahModus++;
            }
        }

        int[] modus = new int[jumlahModus];
        int index = 0;
        for (int key : frekuensi.keySet()) {
            if (frekuensi.get(key) == maxFrekuensi) {
                modus[index++] = key;
            }
        }

        Arrays.sort(modus);

        return modus;
    }
}