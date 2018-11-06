package persistence;

import PadraoStateObserverMemento.PedidoMemento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PedidoMementoDAO {

    private static PedidoMementoDAO instance = new PedidoMementoDAO();
    private PreparedStatement inserePedido;
    private PreparedStatement buscaPedido;
    private PreparedStatement atualizaPedido;
    private PreparedStatement deletePedido;

    public static PedidoMementoDAO getInstance() {
        return instance;
    }

    public void saveMemento(PedidoMemento pm) throws ClassNotFoundException, SQLException {
        buscaPedido = DatabaseLocator.getInstance().getConnection().prepareStatement("update pedidomemento set atual = ? where pedidocod = ?");
        buscaPedido.clearParameters();
        buscaPedido.setInt(1, 0);
        buscaPedido.setInt(2, pm.getNumeroPedido());
        buscaPedido.executeUpdate();
        inserePedido = DatabaseLocator.getInstance().getConnection().prepareStatement("insert into pedidomemento (estado, atual, data, pedidocod) values (?, ?, ?, ?)");
        inserePedido.clearParameters();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Calendar cal = Calendar.getInstance();
        Date data = new Date();
        cal.setTime(data);
        java.sql.Timestamp dataSqlCriacao;
        dataSqlCriacao = new java.sql.Timestamp(data.getTime());
        switch (pm.getEstado().getNomeEstado()) {
            case "Aberto":
                inserePedido.setInt(1, 1);
            case "Preparando":
                inserePedido.setInt(1, 2);
                break;
            case "Pronto":
                inserePedido.setInt(1, 3);
                break;
            case "Enviado":
                inserePedido.setInt(1, 4);
                break;
            case "Recebido":
                inserePedido.setInt(1, 5);
                break;
            default:
                break;
        }
        inserePedido.setInt(2, 1);
        inserePedido.setTimestamp(3, dataSqlCriacao);
        inserePedido.setInt(4, pm.getNumeroPedido());
        inserePedido.execute();
    }
}
