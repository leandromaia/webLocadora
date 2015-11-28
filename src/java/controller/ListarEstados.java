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
 * @author Everton Barros
 */
public class ListarEstados {

     public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            ArrayList<Estado> listEstado = EstadoDAO.getAll();
            if(listEstado != null){
                request.setAttribute("listEstado", listEstado);
                jsp = "/listarestado.jsp";    
            }else{
                String erro="N�o existe Estados!";
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
