package action;

import PadraoChainOfResponsibility.ChefeEasy;
import PadraoChainOfResponsibility.ChefeHard;
import PadraoChainOfResponsibility.ChefeMedium;
import PadraoChainOfResponsibility.Funcionario;
import PadraoStateObserverMemento.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;
import persistence.PedidoDAO;
import persistence.PessoaDAO;

public class AcessoChefeAction implements controller.Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idRestaurante = Integer.parseInt(request.getParameter("id"));
        Integer idUsuario = Integer.parseInt(request.getParameter("id2"));

        Funcionario funcionari = null;
        List<Funcionario> funcionariosEasy = new ArrayList<>();
        List<Funcionario> funcionariosMedium = new ArrayList<>();
        List<Funcionario> funcionariosHard = new ArrayList<>();
        List<Pessoa> pessoas = PessoaDAO.getInstance().buscaFuncionarioRestaurante(idRestaurante);

        for (Pessoa pessoa : pessoas) {
            Funcionario func;
            switch (pessoa.getTipoPessoa()) {
                case 3: {
                    func = new ChefeEasy(pessoa.getPessoaCod(), pessoa.getRestauranteCod(), pessoa.getNome(), pessoa.getEndereco(), pessoa.getEmail(), pessoa.getTelefone());
                    funcionariosEasy.add(func);
                    break;
                }
                case 4: {
                    func = new ChefeMedium(pessoa.getPessoaCod(), pessoa.getRestauranteCod(), pessoa.getNome(), pessoa.getEndereco(), pessoa.getEmail(), pessoa.getTelefone());
                    funcionariosMedium.add(func);
                    break;
                }
                case 5: {
                    func = new ChefeHard(pessoa.getPessoaCod(), pessoa.getRestauranteCod(), pessoa.getNome(), pessoa.getEndereco(), pessoa.getEmail(), pessoa.getTelefone());
                    funcionariosHard.add(func);
                    break;
                }
                default: {
                    func = new ChefeHard(pessoa.getPessoaCod(), pessoa.getRestauranteCod(), pessoa.getNome(), pessoa.getEndereco(), pessoa.getEmail(), pessoa.getTelefone());
                }
            }
            if (pessoa.getPessoaCod() == idUsuario) {
                funcionari = func;
            }
        }

        for (Funcionario funcionario : funcionariosEasy) {
            for (Funcionario funcionario1 : funcionariosMedium) {
                funcionario.getFuncionarioSuperior().add(funcionario1);
            }
            for (Funcionario funcionario1 : funcionariosHard) {
                funcionario.getFuncionarioSuperior().add(funcionario1);
            }
        }

        for (Funcionario funcionario : funcionariosMedium) {
            for (Funcionario funcionario1 : funcionariosHard) {
                funcionario.getFuncionarioSuperior().add(funcionario1);
            }
        }

        List<Pedido> pedidosPegar = new ArrayList<>();
        List<Pedido> pedidos = PedidoDAO.getInstance().searchPedidoRestaurante(idRestaurante);
        
        for (Pedido pedido : pedidos) {
            if ((pedido.getEstado().getNomeEstado().equals("Aberto") || pedido.getEstado().getNomeEstado().equals("Preparar")) && funcionari.pegarPedido(pedido)) {
                pedidosPegar.add(pedido);
            }
        }

        request.setAttribute("pedidos", pedidosPegar);
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-chefe.jsp");
        dispatcher.forward(request, response);
    }
}
