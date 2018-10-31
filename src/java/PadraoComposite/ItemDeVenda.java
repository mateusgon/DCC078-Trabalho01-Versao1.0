package PadraoComposite;

public abstract class ItemDeVenda {
    
    protected String nome;
    protected Double valor;

    public void adicionar(ItemDeVenda item) throws Exception
    {
        throw new Exception("Não é um combo para adicionar");
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    
    
}
