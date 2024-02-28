import java.util.Scanner;

public class Aeroporto {

    static class Passageiro {
        String possuiRg;
        String dataNascRg;
        String possuiPassagem;
        String dataNascPassagem;
        String assento;
    }

    public static void verificar(int qtdPassageiros) {
        Passageiro[] passageiros = new Passageiro[qtdPassageiros];

        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < qtdPassageiros; ++i) {
                passageiros[i] = new Passageiro();

                System.out.print("Possui RG? Digite 'RG' se sim ou 'Nao possui' se nao: ");
                passageiros[i].possuiRg = scanner.next();

                if ("Nao possui".equals(passageiros[i].possuiRg)) {
                    System.out.println("A saída é nessa direção");
                    continue;
                }

                System.out.print("Digite a data de nascimento (formato DD/MM/AAAA): ");
                passageiros[i].dataNascRg = scanner.next();

                System.out.print("Possui Passagem? Digite 'Passagem' se sim ou 'Nao possui' se nao: ");
                passageiros[i].possuiPassagem = scanner.next();

                if ("Nao possui".equals(passageiros[i].possuiPassagem)) {
                    System.out.println("A recepção é nessa direção");
                    continue;
                }

                System.out.print("Digite a data de nascimento na passagem (formato DD/MM/AAAA): ");
                passageiros[i].dataNascPassagem = scanner.next();

                if (!passageiros[i].dataNascRg.equals(passageiros[i].dataNascPassagem)) {
                    System.out.println("190 - Chamar a polícia!");
                    continue;
                }

                System.out.print("Digite o número do assento (formato A12): ");
                passageiros[i].assento = scanner.next();
                System.out.println("O seu assento é " + passageiros[i].assento + ", tenha uma excelente viagem!");
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite a quantidade de passageiros: ");
            int quantidadePassageiros = scanner.nextInt();

            verificar(quantidadePassageiros);
        }
    }
}
