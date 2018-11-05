package action;

import PadraoChainOfResponsibility.ChefeEasy;
import PadraoChainOfResponsibility.ChefeHard;
import PadraoChainOfResponsibility.ChefeMedium;
import PadraoChainOfResponsibility.Funcionario;
import PadraoStateObserverMemento.Pedido;
import com.sun.xml.wss.saml.assertion.saml11.jaxb10.Action;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;
import persistence.PedidoDAO;
import persistence.PessoaDAO;

public class LoginFuncionarioPostAction implements controller.Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String email = request.getParameter("email");
            String senha = request.getParameter("password");
            boolean flagAutenticado = false;
            if (email.equals("") || senha.equals("")) {
                response.sendRedirect("erro.jsp"); //tratar erro1
            } else {
                Pessoa p = new Pessoa(email, senha);
                PessoaDAO.getInstance().Autentica(p);
                request.setAttribute("pessoa", p);
//                HttpSession session = request.getSession();
//                session.setAttribute("authUser", pessoa.getNome());
//                session.setAttribute("idUser", pessoa.getPessoaCod());
                if (p.getTipoPessoa() == 2) {
                    Integer idRestaurante = p.getRestauranteCod();
                    request.setAttribute("pedidos", PedidoDAO.getInstance().searchPedidoRestaurante(idRestaurante));
                    RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-atendente.jsp");
                    dispatcher.forward(request, response);
                } else if (p.getTipoPessoa() >= 3 && p.getTipoPessoa() <= 5) {
                    Integer idRestaurante = p.getRestauranteCod();
                    Integer idUsuario = p.getPessoaCod();

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
                        if ((pedido.getNomeEstado().equals("Aberto") || pedido.getNomeEstado().equals("Preparar") || pedido.getNomeEstado().equals("Pronto")) && funcionari.pegarPedido(pedido)) {
                            pedidosPegar.add(pedido);
                        }
                    }

                    request.setAttribute("idChefe", funcionari.getPessoaCod());
                    request.setAttribute("pedidos", pedidosPegar);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-chefe.jsp");
                    dispatcher.forward(request, response);

                } else if (p.getTipoPessoa() == 6) {
                    Integer idRestaurante = p.getRestauranteCod();
                    List<Pedido> pedidos = PedidoDAO.getInstance().searchPedidoRestaurante(idRestaurante);
                    List<Pedido> pedidosLista = new ArrayList<>();
                    for (Pedido pedido : pedidos) {
                        if (pedido.getNomeEstado().equals("Enviar")) {
                            pedidosLista.add(pedido);
                        }
                    }
                    request.setAttribute("motoboyCod", p.getPessoaCod());
                    request.setAttribute("pedidos", pedidosLista);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-motoqueiro.jsp");
                    dispatcher.forward(request, response);
                } else {
                    RequestDispatcher dispacher = request.getRequestDispatcher("form-login-funcionarios.jsp");
                    dispacher.forward(request, response);
                }
            }
        } catch (Exception ex) {
            RequestDispatcher dispacher = request.getRequestDispatcher("form-login-funcionarios.jsp");
            dispacher.forward(request, response);
        }
    }
}
