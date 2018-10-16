
package action;

import controller.Action;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Restaurante;
import persistence.RestauranteDAO;


public class CadastrarSuperUsuarioAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
        Integer restauranteCod = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("restauranteCod", restauranteCod);
        RequestDispatcher dispatcher = request.getRequestDispatcher("form-cadastro-super-usuario.jsp");
        dispatcher.forward(request, response);
        }
        
        
    }
  
    
    

