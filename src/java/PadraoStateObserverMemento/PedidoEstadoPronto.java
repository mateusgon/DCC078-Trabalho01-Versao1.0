package PadraoStateObserverMemento;

import java.util.Observable;

public class PedidoEstadoPronto extends Observable implements PedidoEstado {

    String nome = "Pronto";

    public PedidoEstadoPronto() {

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
        a.setEstado(new PedidoEstadoEnviar());
    }

    @Override
    public void recebido(Pedido a) {

    }

    @Override
    public String getNomeEstado() {
        return nome;
    }

}
