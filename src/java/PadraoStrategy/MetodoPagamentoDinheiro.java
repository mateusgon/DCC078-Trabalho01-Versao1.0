package PadraoStrategy;

public class MetodoPagamentoDinheiro implements MetodoPagamento {

    @Override
    public Double obterValor(Double valor) {
        if (valor > 100.00) {
            return valor * 0.9;
        } else {
            return valor * 0.95;
        }
    }

    @Override
    public String obterNomeMetodoPagamento() {
        return "Pagamento feito com dinheiro a vista";
    }

}
