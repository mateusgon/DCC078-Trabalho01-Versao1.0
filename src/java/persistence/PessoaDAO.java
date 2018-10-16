
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import model.Pessoa;
import model.Restaurante;


public class PessoaDAO {
      private static PessoaDAO instance = new PessoaDAO();

    public static PessoaDAO getInstance() {
        return instance;
    }
    
    public Pessoa Autentica(Pessoa pessoa) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Pessoa pessoaAutenticada=null;
        Statement st = null;
        conn = DatabaseLocator.getInstance().getConnection();
        st = conn.createStatement();
        ResultSet resultado = st.executeQuery("select * from pessoa where nome='" + pessoa.getNome()  +"'");
        while (resultado.next()) {
                
                 
                pessoa.setNome(resultado.getString("nome"));
                pessoa.setEmail(resultado.getString("email"));
                pessoa.setEndereco(resultado.getString("endereco"));
                pessoa.setPessoaCod(resultado.getInt("pessoaCod"));
                pessoa.setRestauranteCod(resultado.getInt("restauranteCod"));
                pessoa.setTipoPessoa(resultado.getString("tipoPessoa"));
       
        }

        return pessoa;
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
