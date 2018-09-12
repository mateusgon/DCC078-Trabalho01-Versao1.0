package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Empresa;

public class EmpresaDAO {

    private static EmpresaDAO instance = new EmpresaDAO();

    public static EmpresaDAO getInstance() {
        return instance;
    }

    public void save(Empresa empresa) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into empresa(id_empresa, nome) values (" + empresa.getCodigo() + ", '" + empresa.getNome() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public List<Empresa> getAllEmpresas() throws SQLException, ClassNotFoundException {
        List<Empresa> empresas = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet resultado = st.executeQuery("select * from empresa");
            while (resultado.next())
            {
                Empresa empresa = new Empresa(resultado.getInt("id_empresa"), resultado.getString("nome"));
                empresas.add(empresa);
            }
            return empresas;
        }
        catch(SQLException e){
            throw e;
        } finally{
            closeResources(conn, st);
        }
    
    }

    public void closeResources(Connection conn, Statement st) {
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
