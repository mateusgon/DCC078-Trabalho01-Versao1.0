package padraostatememento;

import model.Pedido;

public class PedidoEstadoIniciado  implements PedidoEstado{

    String nome = "Iniciado";
    
 
    
    public PedidoEstadoIniciado() {
    }

    @Override
    public Boolean iniciado(Pedido a) {
        return false;
    }

    @Override
    public Boolean entregue(Pedido a) {
        return false;
    }
    @Override
    public Boolean prontoParaEnviar(Pedido a) {
        return false;
    }
    @Override
    public Boolean cancelado(Pedido a) {
        return false;
    }
    
    @Override
    public String getNomeEstado() {
        return nome;
    }

    public String getNome() {
        return nome;
    }
    
}