import java.util.Arrays;

public class No12 {
    public static void main(String[] args) {
        String input = "1 2 1 3 4 7 1 1 5 6 1 8";
        int[] array = convertToArrayInt(input);
        sortItOut(array);
    }

    private static int[] convertToArrayInt(String input) {
        String[] arrayString = input.split(" ");  // Split string berdasarkan spasi
        int[] result = new int[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            result[i] = Integer.parseInt(arrayString[i]);
        }
        return result;
    }

    private static void sortItOut(int[] array) {
        Arrays.sort(array);  // Urutkan array menggunakan Arrays.sort()
        System.out.println("Array input: ");
        printArray(array);
        System.out.println();
        System.out.println("Array output (sorted): ");
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}