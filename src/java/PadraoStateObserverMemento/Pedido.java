package PadraoStateObserverMemento;

import PadraoComposite.ItemDeVenda;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

public class Pedido extends Observable {

    private Integer numeroPedido;
    private List<ItemDeVenda> itens;
    private PedidoEstado estado;
    private Double valor;
    private Date dataPedido;
    private Integer dificuldade;
    private Integer idRestaurante;
    private Integer idCliente;

    public Pedido(Integer numeroPedido, List<ItemDeVenda> itens, PedidoEstado estado, Double valor, Date dataPedido, Integer dificuldade, Integer idRestaurante, Integer idCliente) {
        this.numeroPedido = numeroPedido;
        this.itens = itens;
        this.valor = valor;
        this.dataPedido = dataPedido;
        this.dificuldade = dificuldade;
        this.idRestaurante = idRestaurante;
        this.idCliente = idCliente;
        // ver como fazer com pedido
    }

    public Pedido() {
        this.itens = new ArrayList<>();
        this.estado = new PedidoEstadoAberto(this);
    }

    public void abrir() {
        estado.aberto(this);
    }

    public void preparar() {
        estado.preparando(this);
    }

    public void pronto()
    {
        estado.pronto(this);
    }
    
    public void enviar() {
        estado.enviado(this);
    }

    public void receber() {
        estado.recebido(this);
    }

    public void notificar() {
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

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Integer getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Integer dificuldade) {
        this.dificuldade = dificuldade;
    }

    public Integer getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Integer idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    
}
