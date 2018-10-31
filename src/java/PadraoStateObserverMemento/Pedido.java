package PadraoStateObserverMemento;

import java.util.Observable;

public class Pedido extends Observable{
    
    private PedidoEstado estado;
    
    public void abrir()
    {}
    
    public void preparar()
    {}
    
    public void encerrar()
    {}
    
    public void enviar()
    {}
    
    public void receber()
    {}
    
    public void cancelar()
    {}
    
    public void notificar()
    {
        this.setChanged();
        notifyObservers();
    }
    
}
