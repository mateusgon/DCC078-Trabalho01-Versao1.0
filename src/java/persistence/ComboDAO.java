package persistence;

import PadraoComposite.ItemDeVenda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ComboDAO {

    private static ComboDAO instance = new ComboDAO();
    private PreparedStatement insereCombo;
    private PreparedStatement buscaCombo;
    private PreparedStatement insereComboProduto;

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
}
