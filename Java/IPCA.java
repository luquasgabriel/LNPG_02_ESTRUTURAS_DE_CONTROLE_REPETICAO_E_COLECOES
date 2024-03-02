import java.util.Scanner;

public class IPCA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        double ipcavalue, smallest = -1, largest = -1, sum = 0;
        String month_year, smallest_month_year = "", largest_month_year = "";
        int first = 1, count = 0;

        System.out.println("Enter IPCA data (year/month index). Press Enter without typing anything to finish");

        while (true) {
            input = scanner.nextLine();

            if (input.isEmpty()) {
                break;
            }

            String[] parts = input.split(" ");
            month_year = parts[0];
            ipcavalue = Double.parseDouble(parts[1]);

            if (first == 1 || ipcavalue < smallest) {
                smallest = ipcavalue;
                smallest_month_year = month_year;
            }

            if (first == 1 || ipcavalue > largest) {
                largest = ipcavalue;
                largest_month_year = month_year;
            }

            sum += ipcavalue;
            count++;
            first = 0;
        }

        if (count > 0) {
            System.out.printf("Smallest IPCA: %.2f (%s)\n", smallest, smallest_month_year);
            System.out.printf("Largest IPCA: %.2f (%s)\n", largest, largest_month_year);
            System.out.printf("Average IPCA: %.2f\n", sum / count);
        } else {
            System.out.println("No IPCA data provided.");
        }

        scanner.close();
    }
}
