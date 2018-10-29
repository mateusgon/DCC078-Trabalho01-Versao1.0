package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Pessoa;

public class PessoaDAO {

    private static PessoaDAO instance = new PessoaDAO();
    private PreparedStatement operacaoLoginUsuario;
    private PreparedStatement operacaoCriarUsuario;

    public static PessoaDAO getInstance() {
        return instance;
    }

    public Pessoa Autentica(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        operacaoLoginUsuario =  DatabaseLocator.getInstance().getConnection().prepareStatement("select * from pessoa where nome = ? and senha = ?");
        operacaoLoginUsuario.clearParameters();
        operacaoLoginUsuario.setString(1, pessoa.getNome());
        operacaoLoginUsuario.setString(2, pessoa.getSenha());
        ResultSet resultado = operacaoLoginUsuario.executeQuery();
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
            st.execute("insert into pessoa(nome, endereco,  telefone,  email,  restaurantecod,tipoPessoa) values ('" + pessoa.getNome() + "','" + pessoa.getEndereco() + "', '" + pessoa.getTelefone() + "','" + pessoa.getEmail() + "', " + pessoa.getRestauranteCod() + ",'" + tipo + "')");

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
