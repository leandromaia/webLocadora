/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import controller.vo.Estado;
import javax.servlet.http.HttpServletRequest;
import model.EstadoDAO;

/**
 *
 * @author Everton Barros
 */
public class AlterarEstado {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo a Sigla do Estado que deseja alterar
            String Sigla = request.getParameter("Sigla");
            Estado estado = EstadoDAO.getById(Sigla);
            if(estado!=null){    
                request.setAttribute("estado",estado);
                jsp = "/alterarestado.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Estado!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
