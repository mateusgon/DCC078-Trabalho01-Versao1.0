package PadraoStateObserverMemento;

import java.util.Observable;

public class PedidoEstadoAberto extends Observable implements PedidoEstado{

    private String nome;
    
    public PedidoEstadoAberto(Pedido pedido) {
        this.nome = "Aberto";
        pedido.notificar();
    }

    @Override
    public void aberto(Pedido a) {
    
    }

    @Override
    public void preparando(Pedido a) {
        a.setEstado(new PedidoEstadoPreparar());
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
        return this.nome;
    }

}