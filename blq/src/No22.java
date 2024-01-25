public class No22 {
    public static void main(String[] args) {
        int[] inputArray = new int[]{3, 3, 9, 6, 7, 8, 23};
        System.out.println("Lilin yang paling pertama meleleh adalah : "+fibonacciCandles(inputArray));
    }

    public static int fibonacciCandles(int[] arrayInput) {
        int result = 0;
        int[] arrayFibonacci = new int[]{1, 1, 2, 3, 5, 8, 13};

        for (int i = 0; i < arrayInput.length; i++) {
            int diff = arrayInput[i] - arrayFibonacci[i];
            if (diff <= 0) {
                result = arrayInput[i];
                break; 
            }
        }

        return result;
    }
}