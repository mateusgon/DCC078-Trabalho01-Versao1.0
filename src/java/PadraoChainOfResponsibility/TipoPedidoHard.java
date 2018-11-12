package PadraoChainOfResponsibility;

public class TipoPedidoHard implements TipoPedido {

    private static final TipoPedidoHard tipoPedidoHard = new TipoPedidoHard();

    public static TipoPedidoHard getTipoPedidoHard() {
        return tipoPedidoHard;
    }

    @Override
    public String getTipoPedido() {
        return "Hard";
    }
}
