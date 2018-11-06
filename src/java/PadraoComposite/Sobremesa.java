package PadraoComposite;

public class Sobremesa extends ItemDeVenda {

    public Sobremesa() {
    }

    public Sobremesa(Integer codigo, String nome, Double valor, Integer dificuldade, Integer restaurantecod, Integer ativado) {
        super(codigo, nome, valor, dificuldade, restaurantecod, ativado);
    }

}
