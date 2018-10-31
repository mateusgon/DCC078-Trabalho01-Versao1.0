package PadraoStateObserverMementoStrategyTemplateMethod;

public class MetodoPagamentoCartaoDebito implements MetodoPagamento{

    @Override
    public Double obterValor(Pedido pedido) {
        return pedido.getValor() * 1.10;
    }

    @Override
    public String obterNomeMetodoPagamento() {
        return "Pagamento feito com cartão de débito";
    }
    
}
