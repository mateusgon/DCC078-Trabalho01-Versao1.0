package action;

import controller.Action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ComboDAO;

public class ExcluirComboAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer idCombo = Integer.parseInt(request.getParameter("id"));
        Integer idRestaurante = Integer.parseInt(request.getParameter("id2"));
        ComboDAO.getInstance().deleteCombo(idCombo);
        request.setAttribute("idRest", idRestaurante);
        RequestDispatcher dispatcher = request.getRequestDispatcher("acesso-restrito-superusuario-listar-combos.jsp");
        dispatcher.forward(request, response);
    }

}
