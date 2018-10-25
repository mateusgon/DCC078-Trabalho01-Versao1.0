package model;

import PadraoObserver.PadraoObserverPedido;

import java.util.Observable;

public class Pedido {
    
    String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
         
        setChanged();
        notifyObservers();
    }
    
    
}
