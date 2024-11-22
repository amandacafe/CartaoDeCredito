import java.util.Scanner;

public class CartaoDeCredito3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do titular: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("Digite o CPF do titular: ");
        String cpfCliente = scanner.nextLine();

        System.out.print("Digite o CNPJ do titular (se PJ): ");
        String cnpjCliente = scanner.nextLine();

        System.out.print("Digite o e-mail do titular: ");
        String emailCliente = scanner.nextLine();

        System.out.print("Digite o telefone do titular: ");
        String telefoneCliente = scanner.nextLine();

        Cliente cliente = new Cliente(nomeCliente, cpfCliente, cnpjCliente, emailCliente, telefoneCliente);

        System.out.print("Digite o número do cartão: ");
        String numeroCartao = scanner.nextLine();

        CartaoDeCredito3 cartao = new CartaoDeCredito3(numeroCartao, cliente, 1000.0f);

        System.out.print("Digite o limite personalizado: ");
        float limitePersonalizado = scanner.nextFloat();
        cartao.setLimite(limitePersonalizado);

        System.out.print("Digite a taxa de cashback (em decimal, por exemplo, 0.05 para 5%): ");
        float taxaCashback = scanner.nextFloat();
        cartao.setTaxaCashback(taxaCashback);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Realizar Transação");
            System.out.println("2. Consultar Limite");
            System.out.println("3. Consultar Saldo");
            System.out.println("4. Realizar Compra");
            System.out.println("5. Realizar Compra com Cashback");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor da transação (positivo para depósito, negativo para saque): ");
                    float valorTransacao = scanner.nextFloat();
                    cartao.realizarTransacao(valorTransacao);
                    break;
                case 2:
                    System.out.println("Limite disponível: " + cartao.consultarLimite());
                    break;
                case 3:
                    System.out.println("Saldo atual: " + cartao.consultarSaldo());
                    break;
                case 4:
                    System.out.print("Digite o valor da compra: ");
                    float valorCompra = scanner.nextFloat();
                    cartao.realizarCompra(valorCompra);
                    break;
                case 5:
                    System.out.print("Digite o valor da compra (com cashback): ");
                    float valorCompraCashback = scanner.nextFloat();
                    cartao.realizarCompraComCashback(valorCompraCashback);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
