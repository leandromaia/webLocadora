/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.bean.Estado;
import javax.servlet.http.HttpServletRequest;
import model.dao.EstadoDAO;

/**
 *
 * @author Everton Barros
 */
public class ExcluirEstado {
     
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo a Sigla do estado para exclusão
            String cod = request.getParameter("cod");
            Estado estado = EstadoDAO.getById(cod);
            boolean delete = EstadoDAO.delete(estado);
            if(delete != false){
                jsp = ListarEstados.execute(request);
            }else{
                String erro = "Ocorreu erro ao Excluir Estado!";
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
