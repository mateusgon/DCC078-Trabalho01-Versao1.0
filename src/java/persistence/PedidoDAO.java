package persistence;

import PadraoStateObserverMemento.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PedidoDAO {

    private static PedidoDAO instance = new PedidoDAO();
    private PreparedStatement inserePedido;
    private PreparedStatement buscaPedido;

    public static PedidoDAO getInstance() {
        return instance;
    }

    public Integer savePedido(Pedido pedido) throws SQLException, ClassNotFoundException {
        inserePedido = DatabaseLocator.getInstance().getConnection().prepareStatement("insert into pedido (estado, datapedido, restaurantecod, pessoacod) values (?, ?, ?, ?)");
        inserePedido.clearParameters();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Calendar cal = Calendar.getInstance();
        Date data = new Date();
        cal.setTime(data);
        java.sql.Timestamp dataSqlCriacao;
        dataSqlCriacao = new java.sql.Timestamp(data.getTime());
        inserePedido.setInt(1, 1);
        inserePedido.setTimestamp(2, dataSqlCriacao);
        inserePedido.setInt(3, pedido.getIdRestaurante());
        inserePedido.setInt(4, pedido.getIdCliente());
        inserePedido.execute();

        buscaPedido = DatabaseLocator.getInstance().getConnection().prepareStatement("select pedidocod from pedido where estado = ? and datapedido = ? and restaurantecod = ? and pessoacod = ?");
        buscaPedido.clearParameters();
        buscaPedido.setInt(1, 1);
        buscaPedido.setTimestamp(2, dataSqlCriacao);
        buscaPedido.setInt(3, pedido.getIdRestaurante());
        buscaPedido.setInt(4, pedido.getIdCliente());
        ResultSet resutaldo = buscaPedido.executeQuery();
        resutaldo.next();
        return resutaldo.getInt("pedidocod");
    }

}
