/*
 * InserirCliente.java
 *
 * Created on 31 de Mar�o de 2008, 18:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;

import controller.vo.Cidade;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.CidadeDAO;

/**
 *
 * @author Everton Barros
 */
public class InserirCliente {
     public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            ArrayList<Cidade> listCidade = CidadeDAO.getAll();
            if(listCidade != null){                
                request.setAttribute("listCidade", listCidade);
                jsp = "/inserircliente.jsp";
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
