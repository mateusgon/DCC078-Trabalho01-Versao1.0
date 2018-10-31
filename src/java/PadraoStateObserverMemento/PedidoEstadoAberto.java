package PadraoStateObserverMemento;

import java.util.Observable;

public class PedidoEstadoAberto extends Observable implements PedidoEstado{

    String nome = "O pedido está em aberto";
    
    public PedidoEstadoAberto(Pedido pedido) {
        pedido.notificar();
    }

    @Override
    public Boolean aberto(Pedido a) {
        return false;
    }

    @Override
    public Boolean preparando(Pedido a) {
        return true;
    }

    @Override
    public Boolean pronto(Pedido a) {
        return false;
    }

    @Override
    public Boolean enviado(Pedido a) {
        return false;
    }

    @Override
    public Boolean recebido(Pedido a) {
        return false;
    }

    @Override
    public Boolean cancelado(Pedido a) {
        return false;
    }

    @Override
    public String getNomeEstado() {
        return this.getNomeEstado();
    }

}