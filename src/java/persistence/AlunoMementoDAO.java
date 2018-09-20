package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import model.Aluno;
import padraostatememento.AlunoMemento;

public class AlunoMementoDAO {

    private static AlunoMementoDAO instance = new AlunoMementoDAO();

    public static AlunoMementoDAO getInstance() {
        return instance;
    }

    public void save(AlunoMemento alunoMemento) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
            Calendar cal = Calendar.getInstance();
            Date data = new Date();
            cal.setTime(data);
            java.sql.Timestamp dataSqlCriacao;
            dataSqlCriacao = new java.sql.Timestamp(data.getTime());
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into alunoMemento(estado, data, fkcodigoAluno) values ('"+ alunoMemento.getEstado().getNomeEstado() + "', '"+dataSqlCriacao+"', "+alunoMemento.getCodigoAluno()+")");
        } catch (SQLException e) {
            throw e;
        } finally {
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
