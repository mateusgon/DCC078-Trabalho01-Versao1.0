package PadraoStateObserverMementoStrategyTemplateMethod;

public class MetodoPagamentoDinheiro implements MetodoPagamento{

    @Override
    public Double obterValor(Pedido pedido) {
        return pedido.getValor() * 0.9;
    }

    @Override
    public String obterNomeMetodoPagamento() {
        return "Pagamento feito com dinheiro a vista";
    }
    
}
