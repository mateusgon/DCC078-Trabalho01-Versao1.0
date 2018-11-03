package PadraoStateObserverMemento;

import java.util.Observable;

public class PedidoEstadoReceber extends Observable implements PedidoEstado {

    String nome = "Receber";

    public PedidoEstadoReceber() {

    }

    @Override
    public void aberto(Pedido a) {

    }

    @Override
    public void preparando(Pedido a) {

    }

    @Override
    public void pronto(Pedido a) {

    }

    @Override
    public void enviado(Pedido a) {

    }

    @Override
    public void recebido(Pedido a) {

    }

    @Override
    public String getNomeEstado() {
        return nome;
    }

}
