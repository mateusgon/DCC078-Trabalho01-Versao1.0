package action;

import controller.Action;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;
import persistence.AlunoDAO;
import persistence.EmpresaDAO;

public class GravarContatoAction implements Action{

    public GravarContatoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("empresas", EmpresaDAO.getInstance().getAllEmpresas());
        RequestDispatcher dispatcher = request.getRequestDispatcher("GravarContato.jsp");
        dispatcher.forward(request, response);
    }
    
}
