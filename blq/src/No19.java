import java.util.HashSet;
import java.util.Set;

public class No19 {
    public static void main(String[] args) {
    String input = "Brawny gods just flocked up to quiz and vex him";
    Pangram(input);
}

    private static boolean isPangram(String input) {
        boolean[] alphabetCheck = new boolean[26];

        for (char character : input.toCharArray()) {
            if (Character.isLetter(character)) {
                int index = Character.toLowerCase(character) - 'a';
                alphabetCheck[index] = true;
            }
        }

        for (boolean isPresent : alphabetCheck) {
            if (!isPresent) {
                return false;
            }
        }

        return true;
    }

    public static void Pangram(String input) {
        if (isPangram(input)) {
            System.out.println(input + " is pangram");
        } else {
            System.out.println(input + " is not pangram");
        }
    }
}