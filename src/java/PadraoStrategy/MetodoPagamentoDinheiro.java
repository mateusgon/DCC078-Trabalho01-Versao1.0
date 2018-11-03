package PadraoStrategy;

import PadraoStateObserverMemento.Pedido;

public class MetodoPagamentoDinheiro implements MetodoPagamento{

    @Override
    public Double obterValor(Double valor) {
        return valor * 0.9;
    }

    @Override
    public String obterNomeMetodoPagamento() {
        return "Pagamento feito com dinheiro a vista";
    }
    
}
