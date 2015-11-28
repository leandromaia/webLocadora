/*
 * ListarVeiculoCliente.java
 *
 * Created on 31 de Março de 2008, 20:56
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */


package controller;

import model.bean.VeiculoCliente;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.dao.VeiculoClienteDAO;

/**
 *
 * @author Everton Barros
 */
public class ListarVeiculoCliente {

     public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            ArrayList<VeiculoCliente> listVeiculoCliente = VeiculoClienteDAO.getAll();
            if(listVeiculoCliente != null){
                request.setAttribute("listVeiculoCliente", listVeiculoCliente);
                jsp = "/listarveiculocliente.jsp";    
            }else{
                String erro="Não existe VeiculoCliente!";
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