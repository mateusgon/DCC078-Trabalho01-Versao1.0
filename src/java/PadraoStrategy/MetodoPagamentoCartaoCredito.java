package PadraoStrategy;

import PadraoStateObserverMemento.Pedido;

public class MetodoPagamentoCartaoCredito implements MetodoPagamento{

    @Override
    public Double obterValor(Double valor) {
        return valor * 1.10;
    }

    @Override
    public String obterNomeMetodoPagamento() {
        return "Pagamento realizado com cartão de crédito";
    }
    
}
