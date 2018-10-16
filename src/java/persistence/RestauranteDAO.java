package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Restaurante;


public class RestauranteDAO {

    private static RestauranteDAO instance = new RestauranteDAO();

    public static RestauranteDAO getInstance() {
        return instance;
    }

    public void save(Restaurante restaurante) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into restaurante(nome, nomeFantasia,  telefone,  endereco,  sigla) values ('" + restaurante.getNome() + "','" + restaurante.getNomeFantasia() + "', '" + restaurante.getTelefone() + "','" + restaurante.getEndereco() + "', '" + restaurante.getSigla() + "')");

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

    public List<Restaurante> listAll() throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;
        List<Restaurante> restaurantes = new ArrayList<>();

        conn = DatabaseLocator.getInstance().getConnection();
        st = conn.createStatement();
        ResultSet resultado = st.executeQuery("select * from restaurante");
        while (resultado.next()) {
            Restaurante restaurante = new Restaurante(resultado.getString("nome"), resultado.getString("nomefantasia"), resultado.getString("telefone"), resultado.getString("endereco"), resultado.getString("sigla"));
            restaurante.setRestaurantecod(resultado.getInt("restaurantecod"));

            restaurantes.add(restaurante);
        }

        return restaurantes;
    }

    public void delete(Integer restauranteCod) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("delete from restaurante where restaurantecod=" + restauranteCod + "");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

    }
}
