package PadraoComposite;

import java.util.ArrayList;
import java.util.List;

public class Combo extends ItemDeVenda{
    
    List <ItemDeVenda> itens;
    
    public Combo (String nome, Double valor)
    {
        this.nome = nome;
        this.valor = valor;
        itens = new ArrayList<>();
    }

    @Override
    public void adicionar(ItemDeVenda item) throws Exception {
        this.itens.add(item);
    }
    
}
