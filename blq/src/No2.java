import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class No2 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatTanggal = new SimpleDateFormat("dd-MM-yyyy");

        Date tanggalPinjamPertama = formatTanggal.parse("28-2-2016");
        Date tanggalKembaliPertama = formatTanggal.parse("7-3-2016");
        int jumlahHariPertama = hitungSelisihHari(tanggalPinjamPertama, tanggalKembaliPertama);

        Date tanggalPinjamKedua = formatTanggal.parse("29-4-2018");
        Date tanggalKembaliKedua = formatTanggal.parse("30-5-2018");
        int jumlahHariKedua = hitungSelisihHari(tanggalPinjamKedua, tanggalKembaliKedua);

        HashMap<String, Integer> bukuBuku = new HashMap<>();
        bukuBuku.put("Buku A", 14);
        bukuBuku.put("Buku B", 3);
        bukuBuku.put("Buku C", 7);
        bukuBuku.put("Buku D", 7);

        System.out.println("Total hari untuk peminjaman pertama: " + jumlahHariPertama);
        System.out.println("Total hari untuk peminjaman kedua: " + jumlahHariKedua);
        System.out.println();

        for (HashMap.Entry<String, Integer> entry : bukuBuku.entrySet()) {
            String buku = entry.getKey();
            int durasiPeminjaman = entry.getValue();

            System.out.println("---------------------------------------------------------");

            cetakBiaya("pertama", buku, jumlahHariPertama, durasiPeminjaman);
            cetakBiaya("kedua", buku, jumlahHariKedua, durasiPeminjaman);

            System.out.println("---------------------------------------------------------");
        }
    }

    private static int hitungSelisihHari(Date tanggalMulai, Date tanggalSelesai) {
        long selisih = tanggalSelesai.getTime() - tanggalMulai.getTime();
        return (int) (selisih / (1000 * 60 * 60 * 24));
    }

    private static void cetakBiaya(String sesi, String buku, int totalHari, int durasiPeminjaman) {
        int biaya = Math.max(totalHari - durasiPeminjaman, 0) * 100;
        System.out.println("Biaya untuk " + sesi + " " + buku + " adalah Rp" + biaya +
                " dengan " + Math.max(totalHari - durasiPeminjaman, 0) + " Hari Terlambat");
    }
}