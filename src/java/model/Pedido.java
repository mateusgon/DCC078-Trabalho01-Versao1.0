package model;

import java.util.Observable;

public class Pedido extends Observable{
    
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
