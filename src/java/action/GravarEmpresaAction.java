package action;

import controller.Action;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;
import model.Empresa;
import persistence.AlunoDAO;
import persistence.EmpresaDAO;

public class GravarEmpresaAction implements Action{

    public GravarEmpresaAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.sendRedirect("GravarEmpresa.jsp");
    }
    
}
