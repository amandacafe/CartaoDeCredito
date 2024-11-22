public class Transacao {
    private Date data;
    private float valor;
    private String descricao;

    public Transacao(Date data, float valor, String descricao) {
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public float getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    // Método para exibir a transação
    public String exibirTransacao() {
        return "Data: " + data.toString() + " | Valor: " + valor + " | Descrição: " + descricao;
    }
}

public class CartaoDeCredito3 {
    private String numero;
    private float limite;
    private float saldo;
    private float taxaCashback;
    private Cliente cliente;
    private List<Transacao> historicoDeTransacoes; // Atributo para armazenar o histórico de transações

    public CartaoDeCredito3(String numero, Cliente cliente, float limite) {
        this.numero = numero;
        this.cliente = cliente;
        this.limite = limite;
        this.saldo = 0.0f; 
        this.taxaCashback = 0.0f; 
        this.historicoDeTransacoes = new ArrayList<>();
    }

    public CartaoDeCredito3(String numero, String Cliente, float limite, float saldo, float taxaCashback) {
        this.numero = numero;
        this.cliente = cliente;
        this.limite = limite;
        this.saldo = saldo;
        this.taxaCashback = taxaCashback;
        this.historicoDeTransacoes = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getTaxaCashback() {
        return taxaCashback;
    }

    public void setTaxaCashback(float taxaCashback) {
        this.taxaCashback = taxaCashback;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void realizarTransacao(float valor, String descricao) {
        Date dataTransacao = new Date(); // Cria a data da transação no momento da execução
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
        Transacao transacao = new Transacao(dataTransacao, valor, descricao);
        historicoDeTransacoes.add(transacao);
    }

    public void realizarCompra(float valor, String descricao) {
        if (valor <= consultarLimite()) {
            saldo += valor;
            System.out.println("Compra realizada com sucesso! Novo saldo: " + saldo);
            Date dataTransacao = new Date(); // Cria a data da transação no momento da execução
            // Adiciona a compra no histórico
            Transacao transacao = new Transacao(dataTransacao, valor, descricao);
            historicoDeTransacoes.add(transacao);
        } else {
            System.out.println("Limite insuficiente para a compra!");
        }
    }

    public void realizarCompraComCashback(float valor, String descricao) {
        if (valor <= consultarLimite()) {
            saldo += valor;
            float cashback = valor * taxaCashback;
            saldo -= cashback;
            System.out.println("Compra realizada com cashback! Novo saldo: " + saldo + " (Cashback: " + cashback + ")");
            Date dataTransacao = new Date(); // Cria a data da transação no momento da execução
            // Adiciona a compra com cashback no histórico
            Transacao transacao = new Transacao(dataTransacao, valor, descricao + " | Cashback aplicado");
            historicoDeTransacoes.add(transacao);
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
    public void exibirHistorico() {
        if (historicoDeTransacoes.isEmpty()) {
            System.out.println("Nenhuma transação realizada.");
        } else {
            System.out.println("Histórico de Transações:");
            for (Transacao transacao : historicoDeTransacoes) {
                System.out.println(transacao.exibirTransacao());
            }
        }
    }
}

