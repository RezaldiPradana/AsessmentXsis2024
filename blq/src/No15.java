import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class No15 {
    public static String convertTo24HourFormat(String time) {
        LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("hh:mm:ss a"));
        int hour = localTime.getHour();

        if (hour == 0) {
            hour = 12;
        }

        return localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public static void main(String[] args) {
        String time = "03:40:44 PM";
        String convertedTime = convertTo24HourFormat(time);
        System.out.println("Mengubah format jam dari : "+time);
        System.out.println("Menjadi format jam : "+convertedTime);

    }
}