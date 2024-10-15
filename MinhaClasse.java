import java.util.Scanner;

public class Conta {

    public static void main(String[] args) {

        Conta conta = new Conta("10", "Maria", "123.456.789-00", 500.0f, 500.0f);
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Consultar Limite");
            System.out.println("3. Realizar Saque");
            System.out.println("4. Realizar Depósito");
            System.out.println("5. Sair");
            
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.println("Saldo: " + conta.consultarSaldo());
                    break;
                case 2:
                    System.out.println("Limite: " + conta.consultarLimite());
                    break;
                case 3:
                    System.out.print("Digite o valor do saque: ");
                    float valorSaque = scanner.nextFloat();
                    conta.realizarTransacao(-valorSaque);
                    break;
                case 4:
                    System.out.print("Digite o valor do depósito: ");
                    float valorDeposito = scanner.nextFloat();
                    conta.realizarTransacao(valorDeposito);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
