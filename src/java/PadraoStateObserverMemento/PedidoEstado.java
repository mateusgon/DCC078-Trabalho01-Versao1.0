package PadraoStateObserverMemento;

public interface PedidoEstado {
    public Boolean aberto(Pedido a);
    public Boolean preparando(Pedido a);
    public Boolean pronto(Pedido a);
    public Boolean enviado(Pedido a);
    public Boolean recebido(Pedido a);
    public Boolean cancelado(Pedido a);
    public String getNomeEstado();
}
