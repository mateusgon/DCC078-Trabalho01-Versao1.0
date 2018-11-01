package PadraoComposite;

import java.util.List;

public class Combo extends ItemDeVenda {

    List<ItemDeVenda> itens;

    public Combo(List<ItemDeVenda> itens, Integer codigo, String nome, Double valor, Integer dificuldade, Integer restaurantecod) {
        super(codigo, nome, valor, dificuldade, restaurantecod);
        this.itens = itens;
    }

    @Override
    public void adicionar(ItemDeVenda item) throws Exception {
        this.itens.add(item);
    }

    @Override
    public List<ItemDeVenda> getItens() throws Exception {
        return this.itens; //To change body of generated methods, choose Tools | Templates.
    }

    
}
