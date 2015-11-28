/*
 * InserirVeiculo.java
 *
 * Created on 31 de Março de 2008, 20:50
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;

import model.bean.Cliente;
import model.bean.Veiculo;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.dao.ClienteDAO;
import model.dao.VeiculoDAO;


/**
 *
 * @author ebarros
 */
public class InserirVeiculoCliente{
     public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            //lista de marcas
            ArrayList<Cliente> listCliente = ClienteDAO.getAll();
            request.setAttribute("listCliente", listCliente);
            //lista de modelos
            ArrayList<Veiculo> listVeiculo = VeiculoDAO.getAll();
            if(listCliente == null || listVeiculo == null){
                String erro = "Nao existe registro!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            }else{
                request.setAttribute("listVeiculo", listVeiculo);                        
                jsp = "/inserirveiculocliente.jsp";    
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}