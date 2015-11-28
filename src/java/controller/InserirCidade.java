/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.bean.Estado;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.dao.EstadoDAO;

/**
 *
 * @author ebarros
 */
public class InserirCidade {
     public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            ArrayList<Estado> listEstado = EstadoDAO.getAll();
            if(listEstado != null){
                request.setAttribute("listEstado", listEstado);
                jsp = "/inserircidade.jsp";    
            }else{
                String erro = "Nao existe registros!";
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
