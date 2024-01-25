import java.util.ArrayList;

public class No5 {
    public static ArrayList<Integer> angkaFibonacci(int n) {
    ArrayList<Integer> fibonacci = new ArrayList<>();

    fibonacci.add(0);
    fibonacci.add(1);

    for (int i = 2; i <= n; i++) {
        fibonacci.add(fibonacci.get(i - 1) + fibonacci.get(i - 2));
    }

    return fibonacci;
}

    public static void main(String[] args) {
        int n = 10;

        ArrayList<Integer> fibonacci = angkaFibonacci(n);

        for (int fibonacciNumber : fibonacci) {
            System.out.println(fibonacciNumber);
        }
    }
}