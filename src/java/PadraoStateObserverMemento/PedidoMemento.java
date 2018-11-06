package PadraoStateObserverMemento;

import PadraoChainOfResponsibility.TipoPedido;
import PadraoComposite.ItemDeVenda;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

public class PedidoMemento extends Observable {

    private Integer numeroPedido;
    private List<ItemDeVenda> itens;
    private PedidoEstado estado;
    private Double valor;
    private Date dataPedido;
    private Integer dificuldade;
    private Integer idRestaurante;
    private Integer idCliente;
    private String nomeEstado;
    private Cliente cliente;
    private TipoPedido tipoPedido;
    private PedidoMemento prox = null;
    private PedidoMemento ant = null;
    
    public PedidoMemento() {
        this.itens = new ArrayList<>();
        this.estado = null;
    }

    public void notificar() {
        this.setChanged();
        notifyObservers();
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public PedidoMemento setEstado(PedidoEstado estado) {
        if (this.estado == null) {
            this.estado = estado;
        } else {
            this.estado = estado;
            setChanged();
            notifyObservers();
        }
        return this;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public PedidoMemento setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
        return this;
    }

    public List<ItemDeVenda> getItens() {
        return itens;
    }

    public PedidoMemento setItens(List<ItemDeVenda> itens) {
        this.itens = itens;
        return this;
    }

    public Double getValor() {
        return valor;
    }

    public PedidoMemento setValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public PedidoMemento setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
        return this;
    }

    public Integer getDificuldade() {
        return dificuldade;
    }

    public PedidoMemento setDificuldade(Integer dificuldade) {
        this.dificuldade = dificuldade;
        return this;
    }

    public Integer getIdRestaurante() {
        return idRestaurante;
    }

    public PedidoMemento setIdRestaurante(Integer idRestaurante) {
        this.idRestaurante = idRestaurante;
        return this;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public PedidoMemento setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
        return this;
    }

    public String getNomeEstado() {
        return this.estado.getNomeEstado();
    }

    public PedidoMemento setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public PedidoMemento setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public TipoPedido getTipoPedido() {
        return tipoPedido;
    }

    public PedidoMemento setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
        return this;
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

    
    
}
