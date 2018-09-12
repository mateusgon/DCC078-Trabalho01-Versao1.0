/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdicionarAlunoAction implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
              response.sendRedirect("adicionar-aluno.jsp");
    }
    
}
