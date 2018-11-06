package PadraoComposite;

public class PratoDeEntrada extends ItemDeVenda {

    public PratoDeEntrada() {
    }

    public PratoDeEntrada(Integer codigo, String nome, Double valor, Integer dificuldade, Integer restaurantecod, Integer ativado) {
        super(codigo, nome, valor, dificuldade, restaurantecod, ativado);
    }

}
