/*
 * ListarCliente.java
 *
 * Created on 31 de Março de 2008, 18:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author Everton Barros
 */
import controller.vo.Cliente;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.ClienteDAO;

public class ListarCliente {
     
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            ArrayList<Cliente> listCliente = ClienteDAO.getAll();
            if(listCliente != null){
                request.setAttribute("listCliente", listCliente);
                jsp = "/listarcliente.jsp";    
            }else{
                String erro="Não existe Clientes!";
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
