/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Restaurante;
import persistence.RestauranteDAO;

/**
 *
 * @author cassio
 */
public class CadastrarSuperUsuariosAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
            
        List <Restaurante> restaurantes =  RestauranteDAO.getInstance().listAll();
        request.setAttribute("restaurantes", restaurantes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ver-restaurantes.jsp");
        dispatcher.forward(request, response);


    }
    
}
