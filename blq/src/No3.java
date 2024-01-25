import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class No3 {
    public static void main(String[] args) throws ParseException {
        String in1 = "27 January 2019 | 05:00:01";
        String out1 = "27 January 2019 | 17:45:03";

        String in2 = "27 January 2019 | 07:03:59";
        String out2 = "27 January 2019 | 15:30:06";

        String in3 = "27 January 2019 | 07:05:00";
        String out3 = "28 January 2019 | 00:20:21";

        String in4 = "27 January 2019 | 11:14:23";
        String out4 = "29 January 2019 | 13:20:00";

        cetakBiaya(in1, out1);
        cetakBiaya(in2, out2);
        cetakBiaya(in3, out3);
        cetakBiaya(in4, out4);
    }

    private static void cetakBiaya(String timeIn, String timeOut) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy | HH:mm:ss");
        Date timeInDate = dateFormat.parse(timeIn);
        Date timeOutDate = dateFormat.parse(timeOut);

        int parkTime = (int) ((timeOutDate.getTime() - timeInDate.getTime()) / 3600000);

        int charge;
        if (parkTime <= 8) {
            charge = parkTime * 1000;
        } else if (parkTime <= 24) {
            charge = 8000;
        } else {
            charge = 15000 + (parkTime - 24) * 1000;
        }

        System.out.println("Biaya parkir untuk " + parkTime + " jam [" + timeIn + " - " + timeOut + "],");
        System.out.println("adalah Rp" + charge);
        System.out.println("_______________________________________________________________________________");
    }
}
