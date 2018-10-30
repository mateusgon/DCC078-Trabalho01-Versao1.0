package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Pessoa;

public class PessoaDAO {

    private static PessoaDAO instance = new PessoaDAO();
    private PreparedStatement operacaoLoginUsuarioSistema;
    private PreparedStatement operacaoCriarCliente;
    private PreparedStatement operacaoListarUsuario;

    public static PessoaDAO getInstance() {
        return instance;
    }

    public void Autentica(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        operacaoLoginUsuarioSistema =  DatabaseLocator.getInstance().getConnection().prepareStatement("select * from pessoa where nome = ? and senha = ?");
        operacaoLoginUsuarioSistema.clearParameters();
        operacaoLoginUsuarioSistema.setString(1, pessoa.getEmail());
        operacaoLoginUsuarioSistema.setString(2, pessoa.getSenha());
        ResultSet resultado = operacaoLoginUsuarioSistema.executeQuery();
        while (resultado.next()) {
            pessoa.setNome(resultado.getString("nome"));
            pessoa.setEmail(resultado.getString("email"));
            pessoa.setEndereco(resultado.getString("endereco"));
            pessoa.setPessoaCod(resultado.getInt("pessoaCod"));
            pessoa.setRestauranteCod(resultado.getInt("restauranteCod"));
            pessoa.setTipoPessoa(resultado.getInt("tipoPessoa"));
        }
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
    
    public void saveCliente(Pessoa pessoa) throws SQLException, ClassNotFoundException 
    {
        operacaoCriarCliente = DatabaseLocator.getInstance().getConnection().prepareStatement("insert into pessoa(nome, endereco, telefone, email, tipoPessoa, senha) values (?, ?, ?, ?, ?, ?)");
        operacaoListarUsuario = DatabaseLocator.getInstance().getConnection().prepareStatement("select pessoacod from pessoa where email = ? and senha = ?");
        operacaoCriarCliente.clearParameters();
        operacaoListarUsuario.clearParameters();
        operacaoCriarCliente.setString(1, pessoa.getNome());
        operacaoCriarCliente.setString(2, pessoa.getEndereco());
        operacaoCriarCliente.setString(3, pessoa.getTelefone());
        operacaoCriarCliente.setString(4, pessoa.getEmail());
        operacaoCriarCliente.setInt(5, pessoa.getTipoPessoa());
        operacaoCriarCliente.setString(6, pessoa.getSenha());    
        operacaoCriarCliente.execute();
        operacaoListarUsuario.setString(1, pessoa.getEmail());
        operacaoListarUsuario.setString(2, pessoa.getSenha());
        ResultSet resultado = operacaoListarUsuario.executeQuery();
        resultado.next();
        pessoa.setPessoaCod(resultado.getInt("pessoacod"));
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
