import java.util.Scanner;

public class PiValue {
    public static double calculatePi(int n) {
        double resultSeries = 0.0;

        for (int i = 0; i < n; i++) {
            double term = Math.pow(-1, i) * (1.0 / Math.pow(2 * i + 1, 3));
            resultSeries += term;
        }

        double approximatedPi = Math.pow(resultSeries * 32, 1.0 / 3);
        return approximatedPi;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms to calculate pi: ");
        int n = scanner.nextInt();

        double piValue = calculatePi(n);
        System.out.printf("Approximate pi value with %d terms: %.10f\n", n, piValue);

        scanner.close();
    }
}
