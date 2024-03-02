#include <stdio.h>
#include <string.h>

typedef struct {
    char has_rg[20];
    char birthdate_rg[11];
    char has_boarding_pass[20];
    char birthdate_boarding_pass[11];
    char seat[4];
} Passenger;

void check_passengers(int num_passengers) {
    Passenger passengers[num_passengers];

    for (int i = 0; i < num_passengers; ++i) {
        printf("Do you have a RG? Type 'Yes' if you do or 'No' if you don't: ");
        scanf("%s", passengers[i].has_rg);

        if (strcmp(passengers[i].has_rg, "No") == 0) {
            printf("The exit is in that direction\n");
            continue;
        }

        printf("Enter the birthdate (format DD/MM/YYYY): ");
        scanf("%s", passengers[i].birthdate_rg);

        printf("Do you have a boarding pass? Type 'Yes' if you do or 'No' if you don't: ");
        scanf("%s", passengers[i].has_boarding_pass);

        if (strcmp(passengers[i].has_boarding_pass, "No") == 0) {
            printf("The reception is in that direction\n");
            continue;
        }

        printf("Enter the birthdate on the boarding pass (format DD/MM/YYYY): ");
        scanf("%s", passengers[i].birthdate_boarding_pass);

        if (strcmp(passengers[i].birthdate_rg, passengers[i].birthdate_boarding_pass) != 0) {
            printf("190\n");
            continue;
        }

        printf("Enter the seat number (format A12): ");
        scanf("%s", passengers[i].seat);
        printf("Your seat is %s, have an excellent trip!\n", passengers[i].seat);
    }
}

int main() {
    int num_passengers;

    printf("Enter the number of passengers: ");
    scanf("%d", &num_passengers);

    check_passengers(num_passengers);

    return 0;
}
