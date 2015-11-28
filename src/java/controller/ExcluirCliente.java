/*
 * ExcluirCliente.java
 *
 * Created on 31 de Março de 2008, 18:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author Everton Barros
 */

import model.bean.Cliente;
import javax.servlet.http.HttpServletRequest;
import model.dao.ClienteDAO;
public class ExcluirCliente {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo repectiva cliente a ser excluida
            String cod = request.getParameter("cod");
            Cliente cliente = ClienteDAO.getById(Integer.parseInt(cod));
            boolean delete = ClienteDAO.delete(cliente);
            if(delete != false){
                jsp = ListarCliente.execute(request);
            }else{
                String erro = "Ocorreu erro ao Excluir Cliente!";
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
