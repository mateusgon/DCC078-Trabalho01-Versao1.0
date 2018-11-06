package PadraoStateObserverMemento;

import java.util.Observable;

public class PedidoEstadoReceber extends Observable implements PedidoEstado {

    private String nome;

    public PedidoEstadoReceber() {
        this.nome = "Receber";
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
