package PadraoComposite;

public class Bebida extends ItemDeVenda {

    public Bebida() {
    }
    
    public Bebida(Integer codigo, String nome, Double valor, Integer dificuldade, Integer restaurantecod, Integer ativado) {
        super(codigo, nome, valor, dificuldade, restaurantecod, ativado);
    }

}
