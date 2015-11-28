/*
 * ListarVeiculo.java
 *
 * Created on 31 de Março de 2008, 20:56
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */


package controller;

import model.bean.Veiculo;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.dao.VeiculoDAO;

/**
 *
 * @author Everton Barros
 */
public class ListarVeiculo {

     public static String execute(HttpServletRequest request) {
        
        try {
            ArrayList<Veiculo> listVeiculo = VeiculoDAO.getAll();
            if(listVeiculo != null){
                request.setAttribute("listVeiculo", listVeiculo);
                jsp = "/listarveiculo.jsp";    
            }else{
                String erro="Não existe Veiculo!";
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