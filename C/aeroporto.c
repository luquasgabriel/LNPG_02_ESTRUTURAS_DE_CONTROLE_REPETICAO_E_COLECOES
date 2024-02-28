#include <stdio.h>
#include <string.h>

typedef struct {
    char possui_rg[20];
    char data_nasc_rg[11];
    char possui_passagem[20];
    char data_nasc_passagem[11];
    char assento[4];
} Passageiro;

void verificar_passageiros(int qtd_passageiros) {
    Passageiro passageiros[qtd_passageiros];

    for (int i = 0; i < qtd_passageiros; ++i) {
        printf("Possui RG? Digite 'RG' se sim ou 'Nao possui' se nao: ");
        scanf("%s", passageiros[i].possui_rg);

        if (strcmp(passageiros[i].possui_rg, "Nao possui") == 0) {
            printf("A saída é nessa direção\n");
            continue;
        }

        printf("Digite a data de nascimento (formato DD/MM/AAAA): ");
        scanf("%s", passageiros[i].data_nasc_rg);

        printf("Possui Passagem? Digite 'Passagem' se sim ou 'Nao possui' se nao: ");
        scanf("%s", passageiros[i].possui_passagem);

        if (strcmp(passageiros[i].possui_passagem, "Nao possui") == 0) {
            printf("A recepção é nessa direção\n");
            continue;
        }

        printf("Digite a data de nascimento na passagem (formato DD/MM/AAAA): ");
        scanf("%s", passageiros[i].data_nasc_passagem);

        if (strcmp(passageiros[i].data_nasc_rg, passageiros[i].data_nasc_passagem) != 0) {
            printf("190 - Chamar a polícia!\n");
            continue;
        }

        printf("Digite o número do assento (formato A12): ");
        scanf("%s", passageiros[i].assento);
        printf("O seu assento é %s, tenha uma excelente viagem!\n", passageiros[i].assento);
    }
}

int main() {
    int quantidade_passageiros;

    printf("Digite a quantidade de passageiros: ");
    scanf("%d", &quantidade_passageiros);

    verificar_passageiros(quantidade_passageiros);

    return 0;
}