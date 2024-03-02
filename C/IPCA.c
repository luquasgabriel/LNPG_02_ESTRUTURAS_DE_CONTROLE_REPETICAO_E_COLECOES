#include <stdio.h>
#include <stdlib.h>

int main() {
    char input[50];
    double ipcavalue, smallest = -1, largest = -1, sum = 0;
    char month_year[8], smallest_month_year[8], largest_month_year[8];
    int first = 1, count = 0;

    printf("Enter IPCA data (year/month index). To finish, press Enter without typing anything:\n");

    while (1) {
        fgets(input, sizeof(input), stdin);

        if (input[0] == '\n') {
            break;
        }

        sscanf(input, "%s %lf", month_year, &ipcavalue);

        if (first || ipcavalue < smallest) {
            smallest = ipcavalue;
            sprintf(smallest_month_year, "%s", month_year);
        }

        if (first || ipcavalue > largest) {
            largest = ipcavalue;
            sprintf(largest_month_year, "%s", month_year);
        }

        sum += ipcavalue;
        count++;
        first = 0;
    }

    if (count > 0) {
        printf("Smallest IPCA: %.2lf (%s)\n", smallest, smallest_month_year);
        printf("Largest IPCA: %.2lf (%s)\n", largest, largest_month_year);
        printf("Average IPCA: %.2lf\n", sum / count);
    } else {
        printf("No IPCA data provided.\n");
    }

    return 0;
}
