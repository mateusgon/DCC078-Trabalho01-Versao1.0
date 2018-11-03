package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.MensagemDAO;

public class ListarMensagensAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idUsuario = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("mensagens", MensagemDAO.getInstance().searchMensagem(idUsuario));
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-cliente-listar-mensagens.jsp");
        dispatcher.forward(request, response);
    }

}
