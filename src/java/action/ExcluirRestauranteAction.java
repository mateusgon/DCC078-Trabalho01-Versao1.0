/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.RestauranteDAO;

/**
 *
 * @author cassio
 */
public class ExcluirRestauranteAction  implements Action  {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
  
       Integer restauranteCod = Integer.parseInt(request.getParameter("id"));
    
       try
            {
         RestauranteDAO.getInstance().delete(restauranteCod);      
               response.sendRedirect("acesso-restrito.jsp");
            }
            catch (SQLException ex)
            {
             response.sendRedirect("erro.jsp");
            }
        }
    }
    
        
    
    
    
    
    

