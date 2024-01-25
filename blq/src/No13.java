import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class No13 {
    public static void main(String[] args) {
        String input = "02:20";
        System.out.print("Input HH:mm : ");
        clockDegree(input);
    }

    private static float calculateClockDegree(float hour, float minute) {
        float degree = 30 * hour - 11 * minute / 2;

        if (hour > 11) {
            degree -= 360;
        }

        return Math.abs(degree == 360 ? 0 : degree);
    }

    private static float parseHour(String input) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime time = LocalTime.parse(input, formatter);
            float hour = time.getHour();

            if (hour > 11) {
                hour -= 12;
            }

            return hour;
        } catch (DateTimeParseException e) {
            return Float.NaN;
        }
    }

    private static float parseMinute(String input) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime time = LocalTime.parse(input, formatter);
            return time.getMinute();
        } catch (DateTimeParseException e) {
            return Float.NaN;
        }
    }

    private static float caseClockDegree(String input) {
        float hour = parseHour(input);
        float minute = parseMinute(input);

        if (Float.isNaN(hour) || Float.isNaN(minute)) {
            return Float.NaN;
        }

        return calculateClockDegree(hour, minute);
    }

    public static void clockDegree(String input) {
        float degree = caseClockDegree(input);
        if (Float.isNaN(degree)) {
            System.out.println("Invalid Input");
        } else {
            System.out.println(input + " is " + degree + " degree");
        }
    }
}