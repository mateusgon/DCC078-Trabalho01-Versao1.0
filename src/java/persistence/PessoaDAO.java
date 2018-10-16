
package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static javafx.scene.input.KeyCode.T;
import model.Pessoa;
import model.Restaurante;


public class PessoaDAO {
      private static PessoaDAO instance = new PessoaDAO();

    public static PessoaDAO getInstance() {
        return instance;
    }
    
      public void save(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        String tipo = "T";
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into pessoa(nome, endereco,  telefone,  email,  restaurantecod,tipoPessoa) values ('" + pessoa.getNome() + "','" + pessoa.getEndereco()+ "', '" + pessoa.getTelefone()+ "','" + pessoa.getEmail()+ "', " + pessoa.getRestauranteCod()+ ",'"+tipo+"')");
          
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    private void closeResources(Connection conn, Statement st) {
      try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
    }

}
