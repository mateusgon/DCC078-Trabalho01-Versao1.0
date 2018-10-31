package PadraoStateObserverMementoStrategyTemplateMethod;

public interface MetodoPagamento {
    public Double obterValor(Pedido pedido);
    public String obterNomeMetodoPagamento();
}
