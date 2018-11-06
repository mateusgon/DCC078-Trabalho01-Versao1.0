package persistence;

import PadraoComposite.Combo;
import PadraoComposite.ItemDeVenda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pessoa;

public class ComboDAO {

    private static ComboDAO instance = new ComboDAO();
    private PreparedStatement insereCombo;
    private PreparedStatement buscaCombo;
    private PreparedStatement insereComboProduto;
    private PreparedStatement excluirCombo;
    private PreparedStatement excluirComboProduto;

    public static ComboDAO getInstance() {
        return instance;
    }

    public void saveCombo(ItemDeVenda combo) throws ClassNotFoundException, SQLException, Exception {
        insereCombo = DatabaseLocator.getInstance().getConnection().prepareStatement("insert into combo (nome, valor, dificuldade, restaurantecod) values (?, ?, ?, ?)");
        insereCombo.clearParameters();
        insereCombo.setString(1, combo.getNome());
        insereCombo.setDouble(2, combo.getValor());
        insereCombo.setInt(3, combo.getDificuldade());
        insereCombo.setInt(4, combo.getRestaurantecod());
        insereCombo.execute();

        buscaCombo = DatabaseLocator.getInstance().getConnection().prepareStatement("select combocod from combo where nome = ? and valor = ? and dificuldade = ? and restaurantecod = ?");
        buscaCombo.clearParameters();
        buscaCombo.setString(1, combo.getNome());
        buscaCombo.setDouble(2, combo.getValor());
        buscaCombo.setInt(3, combo.getDificuldade());
        buscaCombo.setInt(4, combo.getRestaurantecod());
        ResultSet resutaldo = buscaCombo.executeQuery();
        resutaldo.next();
        combo.setCodigo(resutaldo.getInt("combocod"));

        List<ItemDeVenda> itens = combo.getItens();
        insereComboProduto = DatabaseLocator.getInstance().getConnection().prepareStatement("insert into combo_produto (combocod, produtocod) values (?, ?)");
        for (ItemDeVenda iten : itens) {
            insereComboProduto.clearParameters();
            insereComboProduto.setInt(1, combo.getCodigo());
            insereComboProduto.setInt(2, iten.getCodigo());
            insereComboProduto.execute();
        }
    }

    public List<ItemDeVenda> searchCombo(Integer idRest) throws ClassNotFoundException, SQLException {
        buscaCombo = DatabaseLocator.getInstance().getConnection().prepareStatement("select * from combo where restaurantecod = ?");
        buscaCombo.clearParameters();
        buscaCombo.setInt(1, idRest);
        ArrayList<ItemDeVenda> combos = new ArrayList<>();
        ResultSet resultado = buscaCombo.executeQuery();
        while (resultado.next()) {
            ItemDeVenda combo = new Combo();
            combo = combo.setCodigo(resultado.getInt("combocod")).setNome(resultado.getString("nome")).setValor(resultado.getDouble("valor")).setDificuldade(resultado.getInt("dificuldade")).setRestaurantecod(idRest);
            combos.add(combo);
        }
        return combos;
    }

    public List<Integer> searchComboProduto(Integer comboCod) throws ClassNotFoundException, SQLException {
        buscaCombo = DatabaseLocator.getInstance().getConnection().prepareStatement("select produtocod from combo_produto where combocod = ?");
        buscaCombo.clearParameters();
        buscaCombo.setInt(1, comboCod);
        ArrayList<Integer> idProdutos = new ArrayList<>();
        ResultSet resultado = buscaCombo.executeQuery();
        while (resultado.next()) {
            Integer idProduto = resultado.getInt("produtoCod");
            idProdutos.add(idProduto);
        }
        return idProdutos;
    }

    public ItemDeVenda searchComboEspecifico(Integer idCOmbo) throws ClassNotFoundException, SQLException {
        buscaCombo = DatabaseLocator.getInstance().getConnection().prepareStatement("select * from combo where combocod = ?");
        buscaCombo.clearParameters();
        buscaCombo.setInt(1, idCOmbo);
        ItemDeVenda combo = null;
        ResultSet resultado = buscaCombo.executeQuery();
        while (resultado.next()) {
            combo = new Combo();
            combo = combo.setCodigo(resultado.getInt("combocod")).setNome(resultado.getString("nome")).setValor(resultado.getDouble("valor")).setDificuldade(resultado.getInt("dificuldade")).setRestaurantecod(resultado.getInt("restaurantecod"));
        }
        return combo;
    }

    public void deleteCombo(Integer idCombo) throws ClassNotFoundException, SQLException {
        excluirCombo = DatabaseLocator.getInstance().getConnection().prepareStatement("delete from combo where combocod = ?");
        excluirCombo.clearParameters();
        excluirComboProduto = DatabaseLocator.getInstance().getConnection().prepareStatement("delete from combo_produto where combocod = ?");
        excluirComboProduto.clearParameters();
        excluirComboProduto.setInt(1, idCombo);
        excluirComboProduto.execute();
        excluirCombo.setInt(1, idCombo);
        excluirCombo.execute();
    }
}
