package PadraoStateObserverMemento;

import PadraoTemplateMethod.MensagemPreparado;
import PadraoTemplateMethod.MensagemTemplate;
import java.util.Observable;

public class PedidoEstadoPreparar extends Observable implements PedidoEstado {

    private final String nome;
    private final MensagemTemplate mensagem;

    public PedidoEstadoPreparar() {
        this.nome = "Preparando";
        mensagem = new MensagemPreparado();
    }

    @Override
    public Boolean aberto(Pedido a) {
        return false;
    }

    @Override
    public Boolean preparando(Pedido a) {
        return false;
    }

    @Override
    public Boolean pronto(Pedido a) {
        a.setEstado(new PedidoEstadoPronto());
        return true;
    }

    @Override
    public Boolean enviado(Pedido a) {
        return false;
    }

    @Override
    public Boolean recebido(Pedido a) {
        return false;
    }

    @Override
    public String getNomeEstado() {
        return this.nome;
    }

    @Override
    public MensagemTemplate getMensagem() {
        return this.mensagem;
    }
    
}
