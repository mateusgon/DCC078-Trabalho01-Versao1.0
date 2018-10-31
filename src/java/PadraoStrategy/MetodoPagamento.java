package PadraoStrategy;

import PadraoStateObserverMemento.Pedido;

public interface MetodoPagamento {
    public Double obterValor(Pedido pedido);
    public String obterNomeMetodoPagamento();
}
