package PadraoTemplateMethod;

import PadraoStateObserverMemento.Pedido;

public abstract class MensagemTemplate {
    
    public abstract String getEstado();
    
    public String getEstadoPedido(Pedido pedido)
    {
        return "O Pedido " + pedido.getNumeroPedido() + " mudou o seu estado para " + getEstado() + ". Fique atento"; 
    }
    
}
