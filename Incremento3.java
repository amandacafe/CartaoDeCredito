
    import java.util.Scanner;

    public class CartaoDeCredito3 {
        private String numero;
        private String nomeTitular;
        private String cpfTitular;
        private float limite;
        private float saldo;
        private float taxaCashback;
    
        public CartaoDeCredito3(String numero, String nomeTitular, float limite) {
            this.numero = numero;
            this.nomeTitular = nomeTitular;
            this.limite = limite;
            this.saldo = 0.0f; 
            this.taxaCashback = 0.0f; 
        }
    
        public CartaoDeCredito3(String numero, String nomeTitular, String cpfTitular, float limite, float saldo, float taxaCashback) {
            this.numero = numero;
            this.nomeTitular = nomeTitular;
            this.cpfTitular = cpfTitular;
            this.limite = limite;
            this.saldo = saldo;
            this.taxaCashback = taxaCashback;
        }
    
        public float getLimite() {
            return limite;
        }
    
        public float getSaldo() {
            return saldo;
        }
    
        public void setTaxaCashback(float taxaCashback) {
            this.taxaCashback = taxaCashback;
        }
    
        public void realizarTransacao(float valor) {
            if (valor > 0) {
                saldo += valor;
                System.out.println("Depósito realizado com sucesso! Novo saldo: " + saldo);
            } else {
                if (saldo + limite >= -valor) {
                    saldo += valor;
                    System.out.println("Saque realizado com sucesso! Novo saldo: " + saldo);
                } else {
                    System.out.println("Saldo e limite insuficientes para o saque!");
                }
            }
        }
    
        public void realizarCompra(float valor) {
            if (valor <= consultarLimite()) {
                saldo += valor;
                System.out.println("Compra realizada com sucesso! Novo saldo: " + saldo);
            } else {
                System.out.println("Limite insuficiente para a compra!");
            }
        }
    
        public void realizarCompraComCashback(float valor) {
            if (valor <= consultarLimite()) {
                saldo += valor;
                float cashback = valor * taxaCashback;
                saldo -= cashback;
                System.out.println("Compra realizada com cashback! Novo saldo: " + saldo + " (Cashback: " + cashback + ")");
            } else {
                System.out.println("Limite insuficiente para a compra!");
            }
        }
    
        public float consultarLimite() {
            return limite - saldo;
        }
    
        public float consultarSaldo() {
            return saldo;
        }
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            System.out.print("Digite o número do cartão: ");
            String numero = scanner.nextLine();
    
            System.out.print("Digite o nome do titular: ");
            String nomeTitular = scanner.nextLine();
    
            
            CartaoDeCredito3 cartao = new CartaoDeCredito3(numero, nomeTitular, 1000.0f);
    
            System.out.print("Digite o CPF do titular: ");
            String cpfTitular = scanner.nextLine();
            
            System.out.print("Digite o limite personalizado: ");
            float limitePersonalizado = scanner.nextFloat();
            cartao.limite = limitePersonalizado;
    
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
