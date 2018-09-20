package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import padraostatememento.AlunoEstado;
import padraostatememento.AlunoEstadoMatriculado;
import padraostatememento.AlunoEstadoTrancado;

public class AlunoDAO {

    private static AlunoDAO instance = new AlunoDAO();

    public static AlunoDAO getInstance() {
        return instance;
    }

    public void save(Aluno aluno) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into aluno(nome, estado) values ('" + aluno.getNome() + "', '" + aluno.getNomeEstado() + "')");
            aluno.setCodigoAluno(listCodigoUsuario());
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public List<Aluno> listAll() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        List<Aluno> alunos = new ArrayList<>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet resultado = st.executeQuery("select * from aluno");
            while (resultado.next()) {
                Aluno aluno = new Aluno(resultado.getString("nome"));
                aluno.setCodigoAluno(resultado.getInt("codigoAluno"));
                String nomeEstado = resultado.getString("estado");
                if (nomeEstado.equals("Matriculado")) {
                    AlunoEstado estado = new AlunoEstadoMatriculado();
                    aluno.setEstado(estado);
                } else if (nomeEstado.equals("Formado")) {
                    AlunoEstado estado = new AlunoEstadoTrancado();
                    aluno.setEstado(estado);
                } else if (nomeEstado.equals("Trancado")) {
                    AlunoEstado estado = new AlunoEstadoTrancado();
                    aluno.setEstado(estado);
                } else {

                }
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return alunos;
    }

    public Integer listCodigoUsuario() throws SQLException, ClassNotFoundException {
        Integer idCriado = -1;
        Connection conn = null;
        Statement st = null;
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet resultado = st.executeQuery("select codigoAluno from aluno");
            while (resultado.next()) {
                idCriado = resultado.getInt("codigoAluno");
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return idCriado;
    }

    public Aluno list(Integer codigoAluno) throws SQLException, ClassNotFoundException 
    {
        Connection conn = null;
        Statement st = null;
        Aluno aluno = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet resultado = st.executeQuery("select * from aluno where codigoAluno = "+codigoAluno+"");
            while (resultado.next()) {
                aluno = new Aluno(resultado.getString("nome"));
                aluno.setCodigoAluno(resultado.getInt("codigoAluno"));
                String nomeEstado = resultado.getString("estado");
                if (nomeEstado.equals("Matriculado")) {
                    AlunoEstado estado = new AlunoEstadoMatriculado();
                    aluno.setEstado(estado);
                } else if (nomeEstado.equals("Formado")) {
                    AlunoEstado estado = new AlunoEstadoTrancado();
                    aluno.setEstado(estado);
                } else if (nomeEstado.equals("Trancado")) {
                    AlunoEstado estado = new AlunoEstadoTrancado();
                    aluno.setEstado(estado);
                } else {

                }
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return aluno;
    }
    
    /*
    
    public void change (Aluno aluno) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update aluno set email='"+aluno.getEmail()+"' where nome='"+aluno.getNome()+"'");
        } catch(SQLException e){
            throw e;
        } finally{
            closeResources(conn, st);
        }
    }
    
    public void delete(Aluno aluno) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("delete from aluno where nome='"+aluno.getNome()+"'");
        } catch(SQLException e){
            throw e;
        } finally{
            closeResources(conn, st);
        }
    
    }*/
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
