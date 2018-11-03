package persistence;

import PadraoComposite.ItemDeVenda;
import PadraoStateObserverMemento.Cliente;
import PadraoStateObserverMemento.Pedido;
import PadraoStateObserverMemento.PedidoEstado;
import PadraoStateObserverMemento.PedidoEstadoAberto;
import PadraoStateObserverMemento.PedidoEstadoEnviar;
import PadraoStateObserverMemento.PedidoEstadoPreparar;
import PadraoStateObserverMemento.PedidoEstadoPronto;
import PadraoStateObserverMemento.PedidoEstadoReceber;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.Pessoa;

public class PedidoDAO {

    private static PedidoDAO instance = new PedidoDAO();
    private PreparedStatement inserePedido;
    private PreparedStatement buscaPedido;
    private PreparedStatement atualizaPedido;

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

    public void updatePedido(Pedido pedido) throws SQLException, ClassNotFoundException {
        atualizaPedido = DatabaseLocator.getInstance().getConnection().prepareStatement("update pedido set valor = ?, dificuldade = ? where pedidocod = ?");
        atualizaPedido.clearParameters();
        atualizaPedido.setDouble(1, pedido.getValor());
        atualizaPedido.setInt(2, pedido.getDificuldade());
        atualizaPedido.setInt(3, pedido.getNumeroPedido());
        atualizaPedido.execute();
    }

    public void savePedidoProduto(List<ItemDeVenda> itens, Integer pedido) throws SQLException, ClassNotFoundException {
        inserePedido = DatabaseLocator.getInstance().getConnection().prepareStatement("insert into pedido_produto (pedidocod, produtocod) values (?, ?)");
        for (ItemDeVenda iten : itens) {
            inserePedido.clearParameters();
            inserePedido.setInt(1, pedido);
            inserePedido.setInt(2, iten.getCodigo());
            inserePedido.execute();
        }
    }

    public void saveComboProduto(ItemDeVenda combo, Integer pedido) throws SQLException, ClassNotFoundException {
        inserePedido = DatabaseLocator.getInstance().getConnection().prepareStatement("insert into pedido_combo (pedidocod, combocod) values (?, ?)");
        inserePedido.clearParameters();
        inserePedido.setInt(1, pedido);
        inserePedido.setInt(2, combo.getCodigo());
        inserePedido.execute();
    }

    public List<Pedido> searchPedido(Integer idUsuario) throws SQLException, ClassNotFoundException {
        List<Pedido> pedidos = new ArrayList<>();
        buscaPedido = DatabaseLocator.getInstance().getConnection().prepareStatement("select * from pedido where pessoacod = ?");
        buscaPedido.clearParameters();
        buscaPedido.setInt(1, idUsuario);
        ResultSet resultado = buscaPedido.executeQuery();
        while (resultado.next()) {
            Pedido pedido = new Pedido();
            pedido.setNumeroPedido(resultado.getInt("pedidocod"));
            pedido.setValor(resultado.getDouble("valor"));
            pedido.setDificuldade(resultado.getInt("dificuldade"));
            pedido.setIdRestaurante(resultado.getInt("restaurantecod"));
            pedido.setDataPedido(resultado.getTimestamp("datapedido"));
            pedido.setIdCliente(idUsuario);
            iniciaEstado(resultado.getInt("estado"), pedido);
            pedidos.add(pedido);
            Pessoa pessoa = PessoaDAO.getInstance().buscaUsuario(idUsuario);
            Cliente cliente = new Cliente(pessoa.getPessoaCod(), pessoa.getTipoPessoa(), pessoa.getNome(), pessoa.getEndereco(), pessoa.getEmail(), null, pessoa.getTelefone(), pedido);
            pedido.preparar();
            pedido.pronto();
            pedido.enviar();
            pedido.receber();
        }
        return pedidos;
    }

    public void iniciaEstado(Integer codigoEstado, Pedido pedido) {
        switch (codigoEstado) {
            case 1: {
                PedidoEstado estado = new PedidoEstadoAberto(pedido);
                pedido.setEstado(estado);
                break;
            }
            case 2: {
                PedidoEstado estado = new PedidoEstadoPreparar();
                pedido.setEstado(estado);
                break;
            }
            case 3: {
                PedidoEstado estado = new PedidoEstadoPronto();
                pedido.setEstado(estado);
                break;
            }
            case 4: {
                PedidoEstado estado = new PedidoEstadoEnviar();
                pedido.setEstado(estado);
                break;
            }
            case 5: {
                PedidoEstado estado = new PedidoEstadoReceber();
                pedido.setEstado(estado);
                break;
            }
        }
    }
}
