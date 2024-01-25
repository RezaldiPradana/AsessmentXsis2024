public class No11 {

    public static void main(String[] args) {
        String input = "Sleman";
        inversePrint(input);
    }

    private static void inversePrint(String input) {
        String pattern = "***";
        for (int i = 0; i < input.length(); i++) {
            String result = pattern + input.charAt(input.length() - i - 1) + pattern;
            System.out.println(result);
        }
    }
}
