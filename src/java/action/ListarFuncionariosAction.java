package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.PessoaDAO;

public class ListarFuncionariosAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idRestaurante = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("listFuncionarios", PessoaDAO.getInstance().buscaFuncionarioRestaurante(idRestaurante));
        System.out.println(PessoaDAO.getInstance().buscaFuncionarioRestaurante(idRestaurante).size());
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-superusuario-listar-funcionarios.jsp");
        dispatcher.forward(request, response);
    }

}
