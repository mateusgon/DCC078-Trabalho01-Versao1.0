package PadraoStateObserverMementoStrategyTemplateMethod;

import java.util.Date;

public class PedidoMemento {
    private Date data;
    private Integer codigoPedido;
    private Integer codMemento;
    private PedidoEstado estado;
    private PedidoMemento alunoAnt=null;
    private PedidoMemento alunoProx=null;

    
    
    public PedidoMemento getPedidoAnt() {
        return alunoAnt;
    }

    public Integer getCodMemento() {
        return codMemento;
    }

    public void setCodMemento(Integer codMemento) {
        this.codMemento = codMemento;
    }

        
    public void setPedidoAnt(PedidoMemento alunoAnt) {
        this.alunoAnt = alunoAnt;
    }

    public PedidoMemento getPedidoProx() {
        return alunoProx;
    }

    public void setPedidoProx(PedidoMemento alunoProx) {
        this.alunoProx = alunoProx;
    }


    public PedidoMemento(PedidoEstado estado, Integer codigoPedido,Integer codMemento) {
        
        this.estado = estado;
        this.codigoPedido = codigoPedido;
        this.codMemento = codMemento;
    } 

    public PedidoEstado getEstado() {
        return estado;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }
    
    public PedidoEstado getEstadoSalvo()
    {
        return estado;
    }
    
    public String toString()
    {
        return estado.getNomeEstado();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Integer codigoPedido) {
        this.codigoPedido = codigoPedido;
    }
    
    
}
