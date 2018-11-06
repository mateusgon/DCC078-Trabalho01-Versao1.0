package PadraoStateObserverMemento;

import java.util.Date;

public class PedidoMemento {

    private Date dataModificacao;
    private Integer mementoCod;
    private Integer numeroPedido;
    private PedidoEstado estado;
    private Integer atual;
    private String nomeEstado;
    private PedidoMemento prox = null;
    private PedidoMemento ant = null;

    public PedidoMemento() {
        this.estado = null;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public PedidoMemento setEstado(PedidoEstado estado) {
        this.estado = estado;
        return this;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public PedidoMemento setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
        return this;
    }

    public String getNomeEstado() {
        return this.estado.getNomeEstado();
    }

    public PedidoMemento getProx() {
        return prox;
    }

    public PedidoMemento setProx(PedidoMemento prox) {
        this.prox = prox;
        return this;
    }

    public PedidoMemento getAnt() {
        return ant;
    }

    public PedidoMemento setAnt(PedidoMemento ant) {
        this.ant = ant;
        return this;
    }

    public Integer getAtual() {
        return atual;
    }

    public PedidoMemento setAtual(Integer atual) {
        this.atual = atual;
        return this;
    }

    public Integer getMementoCod() {
        return mementoCod;
    }

    public PedidoMemento setMementoCod(Integer mementoCod) {
        this.mementoCod = mementoCod;
        return this;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public PedidoMemento setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
        return this;
    }

    public PedidoMemento setNomeEstado(String nomeEstado) {
        this.nomeEstado = estado.getNomeEstado();
        return this;
    }

    
    
    
}
