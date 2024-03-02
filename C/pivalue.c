#include <stdio.h>
#include <math.h>

double calculatePi(int n) {
    double resultSeries = 0.0;

    for (int i = 0; i < n; i++) {
        double term = pow(-1, i) * (1.0 / pow(2 * i + 1, 3));
        resultSeries += term;
    }

    double approximatedPi = pow(resultSeries * 32, 1.0 / 3);
    return approximatedPi;
}

int main() {
    int n;

    printf("Enter the number of terms to calculate pi: ");
    scanf("%d", &n);

    double piValue = calculatePi(n);
    printf("Approximate pi value with %d terms: %.10f\n", n, piValue);

    return 0;
}
