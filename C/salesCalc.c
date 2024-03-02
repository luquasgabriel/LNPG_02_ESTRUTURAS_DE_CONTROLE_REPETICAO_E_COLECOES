#include <stdio.h>

int main() {
    int quantitySold;
    printf("Games sold by Catarina: ");
    scanf("%d", &quantitySold);

    double costPerGame = 19.90;
    double totalSales = quantitySold * costPerGame;
    double bonus = (quantitySold / 15.0) * 0.08 * totalSales;
    double salary = 0.5 * totalSales;
    double totalEarnings = salary + bonus;

    printf("%.2f\n%.2f\n%.2f\n", totalSales, bonus, totalEarnings);

    return 0;
}
