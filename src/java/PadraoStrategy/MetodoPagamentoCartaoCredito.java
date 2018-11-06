package PadraoStrategy;

public class MetodoPagamentoCartaoCredito implements MetodoPagamento {

    @Override
    public Double obterValor(Double valor) {
        if (valor > 100.00) {
            return valor * 1.05;
        } else {
            return valor * 1.10;
        }
    }

    @Override
    public String obterNomeMetodoPagamento() {
        return "Pagamento realizado com cartão de crédito";
    }

}
