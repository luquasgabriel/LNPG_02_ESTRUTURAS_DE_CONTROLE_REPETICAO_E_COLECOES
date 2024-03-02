import java.util.Scanner;

public class SalesCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Games sold by Catarina: ");
        int quantitySold = scanner.nextInt();

        double costPerGame = 19.90;
        double totalSales = quantitySold * costPerGame;
        double bonus = (quantitySold / 15) * 0.08 * totalSales;
        double salary = 0.5 * totalSales;
        double totalEarnings = salary + bonus;

        System.out.printf("%.2f\n%.2f\n%.2f\n", totalSales, bonus, totalEarnings);

        scanner.close();
    }
}
