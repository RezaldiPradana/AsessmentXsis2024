public class No10 {
    public static void main(String[] args) {
        soal10("Susilo Bambang Yudhoyono");
        soal10("Rani Tiara");
    }

    private static void soal10(String name) {
        String[] arrName = name.split(" ");
        System.out.println("Input : " + name);
        System.out.print("Output : ");

        for (String part : arrName) {
            int top = part.length();
            int bottom = 0;

            for (int j = bottom; j < top; j++) {
                if (j == bottom || j == top - 1) {
                    System.out.print(part.charAt(j));
                } else {
                    System.out.print("*");
                }
            }

            System.out.print(" ");
        }
        System.out.println("\n");
    }
}