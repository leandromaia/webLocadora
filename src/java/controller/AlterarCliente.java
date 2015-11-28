/*
 * AlterarCliente.java
 *
 * Created on 31 de Março de 2008, 18:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;

import model.bean.Cliente;
import javax.servlet.http.HttpServletRequest;
import model.dao.ClienteDAO;

/**
 *
 * @author ebarros
 */
public class AlterarCliente {
 
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodCliente que se deseja alterar
            String codCliente = request.getParameter("CodCliente");
            Cliente cliente = ClienteDAO.getById(Integer.parseInt(codCliente));
            if(cliente !=null){
                request.setAttribute("cliente",cliente);
                jsp = "/alterarcliente.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Cliente!";
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