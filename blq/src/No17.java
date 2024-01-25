import java.util.Arrays;

public class No17 {

    public static void main(String[] args) {
        char[] perjalananHattori = {'N', 'N', 'T', 'N', 'N', 'N', 'T', 'T', 'T', 'T', 'T', 'N', 'T', 'T', 'T', 'N', 'T', 'N'};
        int[] result = hitungGunungDanLembah(perjalananHattori);

        String div = "-------------------------------------------------------------";
        System.out.println(div);
        System.out.println("Perjalanan : " + Arrays.toString(perjalananHattori));
        System.out.println("Jumlah Gunung Yang Dilewati Hattori: " + result[0]);
        System.out.println("Jumlah Lembah Yang Dilewati Hattori: " + result[1]);
        System.out.println(div);
    }

    private static int[] hitungGunungDanLembah(char[] perjalanan) {
        int gunung = 0;
        int lembah = 0;
        int level = 0;

        for (char langkah : perjalanan) {
            if (langkah == 'N') {
                level++;
            } else if (langkah == 'T') {
                level--;
            }

            // Cek apakah level kembali ke 0, dan tentukan apakah itu gunung atau lembah
            if (level == 0) {
                if (langkah == 'N') {
                    lembah++;
                } else if (langkah == 'T') {
                    gunung++;
                }
            }
        }

        return new int[]{gunung, lembah};
    }
}
