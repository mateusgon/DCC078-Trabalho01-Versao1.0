package padraostatememento;

import model.Pedido;

public interface PedidoEstado {
    public Boolean iniciado(Pedido a);
    public Boolean entregue(Pedido a);
    public Boolean prontoParaEnviar(Pedido a);
    public Boolean cancelado(Pedido a);
    public String getNomeEstado();
}
