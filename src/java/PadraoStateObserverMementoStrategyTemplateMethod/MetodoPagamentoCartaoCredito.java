package PadraoStateObserverMementoStrategyTemplateMethod;

public class MetodoPagamentoCartaoCredito implements MetodoPagamento{

    @Override
    public Double obterValor(Pedido pedido) {
        return pedido.getValor() * 1.10;
    }

    @Override
    public String obterNomeMetodoPagamento() {
        return "Pagamento realizado com cartão de crédito";
    }
    
}
