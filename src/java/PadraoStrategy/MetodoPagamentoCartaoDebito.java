package PadraoStrategy;

public class MetodoPagamentoCartaoDebito implements MetodoPagamento {

    @Override
    public Double obterValor(Double valor) {
        if (valor > 50.00) {
            return valor * 1.0;
        } else {
            return valor * 1.10;
        }
    }

    @Override
    public String obterNomeMetodoPagamento() {
        return "Pagamento feito com cartão de débito";
    }

}
