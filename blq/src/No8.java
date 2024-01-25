public class No8 {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 7, 8, 6, 9};

        int minimumSum = Integer.MAX_VALUE;
        int maximumSum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length - 3; i++) {
            int sum = numbers[i] + numbers[i + 1] + numbers[i + 2] + numbers[i + 3];

            minimumSum = Math.min(minimumSum, sum);
            maximumSum = Math.max(maximumSum, sum);
        }

        System.out.println("Nilai minimal dari penjumlahan 4 komponen deret: " + minimumSum);
        System.out.println("Nilai maksimal dari penjumlahan 4 komponen deret: " + maximumSum);
    }
}