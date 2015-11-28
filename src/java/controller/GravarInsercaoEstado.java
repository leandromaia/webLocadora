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
public class GravarInsercaoEstado {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo a Sigla do Estado que deseja incluir
            String sigla = request.getParameter("sigla");
            // lendo o Nome do Estado que deseja incluir
            String nome = request.getParameter("nome");
            
            Estado estado = new Estado();
            estado.setSigla(sigla);
            estado.setNome(nome);
            
            Boolean create = EstadoDAO.create(estado);
            if(create != false){
                jsp = ListarEstados.execute(request);    
            }else{
                String erro = "Não foi possível gravar esse registro!";
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
