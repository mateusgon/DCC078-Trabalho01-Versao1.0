package PadraoComposite;

public class PratoPrincipal extends ItemDeVenda {

    public PratoPrincipal() {
    }
    
    public PratoPrincipal(Integer codigo, String nome, Double valor, Integer dificuldade, Integer restaurantecod, Integer ativado) {
        super(codigo, nome, valor, dificuldade, restaurantecod, ativado);
    }

}
