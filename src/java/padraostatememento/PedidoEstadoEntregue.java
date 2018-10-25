
package padraostatememento;

import model.Pedido;


public class PedidoEstadoEntregue implements PedidoEstado{
 
  String nome = "Cancelado";
    
    public PedidoEstadoEntregue() {
    }

    @Override
    public Boolean iniciado(Pedido a) {
        return false;
    }

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