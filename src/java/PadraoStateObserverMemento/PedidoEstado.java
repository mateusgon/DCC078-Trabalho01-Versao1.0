package PadraoStateObserverMemento;

public interface PedidoEstado {
    public void aberto(Pedido a);
    public void preparando(Pedido a);
    public void pronto(Pedido a);
    public void enviado(Pedido a);
    public void recebido(Pedido a);
    public String getNomeEstado();
}
