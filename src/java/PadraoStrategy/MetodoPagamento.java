package PadraoStrategy;

import PadraoStateObserverMemento.Pedido;

public interface MetodoPagamento {
    public Double obterValor(Double valor);
    public String obterNomeMetodoPagamento();
}
