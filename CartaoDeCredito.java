import java.util.Scanner;

public class CartaoDeCredito {
    private String numero;
    private String nomeTitular;
    private String cpfTitular;
    private float limite;
    private float saldo;

    public CartaoDeCredito(String numero, String nomeTitular, String cpfTitular, float limite, float saldo) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.limite = limite;
        this.saldo = saldo;
    }

    public float consultarSaldo() {
        return saldo;
    }

    public float consultarLimite() {
        return limite;
    }

    public void realizarTransacao(float valor) {
        if (valor > 0) {
            
            saldo += valor;
            System.out.println("Depósito realizado com sucesso! Novo saldo: " + saldo);
        } else {
            // Saque
            if (saldo + limite >= -valor) {
                saldo += valor;
                System.out.println("Saque realizado com sucesso! Novo saldo: " + saldo);
            } else {
                System.out.println("Saldo e limite insuficientes para o saque!");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Receber dados do cartão de crédito
        System.out.print("Digite o número do cartão: ");
        String numero = scanner.nextLine();
        
        System.out.print("Digite o nome do titular: ");
        String nomeTitular = scanner.nextLine();
        
        System.out.print("Digite o CPF do titular: ");
        String cpfTitular = scanner.nextLine();
        
        System.out.print("Digite o limite: ");
        float limite = scanner.nextFloat();
        
        System.out.print("Digite o saldo inicial: ");
        float saldo = scanner.nextFloat();
        
        // Instanciar o cartão de crédito
        CartaoDeCredito cartao = new CartaoDeCredito(numero, nomeTitular, cpfTitular, limite, saldo);
        
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Realizar Transação");
            System.out.println("2. Consultar Limite");
            System.out.println("3. Consultar Saldo");
            System.out.println("4. Sair");
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
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
