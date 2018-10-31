package PadraoStateObserverMementoStrategyTemplateMethod;

import Composite.ItemDeVenda;
import java.util.List;
import java.util.Observable;

public class Pedido extends Observable{

    //Pedido deve ter uma data também
    private Integer numeroPedido;
    private List<ItemDeVenda> itens;
    private PedidoEstado estado;
    private Double valor;

    public Pedido(Integer numeroPedido, List<ItemDeVenda> itens, PedidoEstado estado, Double valor) {
        this.numeroPedido = numeroPedido;
        this.itens = itens;
        this.estado = estado;
        this.valor = valor;
    }
    
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

    public PedidoEstado getEstado() {
        return estado;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public List<ItemDeVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemDeVenda> itens) {
        this.itens = itens;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
     
    
    
}
