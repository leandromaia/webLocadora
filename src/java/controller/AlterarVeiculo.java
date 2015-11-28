/*
 * Veiculo.java
 *
 * Created on 31 de Março de 2008, 20:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;

import model.bean.Veiculo;
import javax.servlet.http.HttpServletRequest;
import model.dao.VeiculoDAO;

/**
 *
 * @author ebarros
 */
public class AlterarVeiculo {
 
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodVeiculo que se deseja alterar
            String placa = request.getParameter("Placa");            
            Veiculo veiculo = VeiculoDAO.getById(placa);
            if(veiculo!=null){
                request.setAttribute("veiculo",veiculo);
                jsp = "/alterarveiculo.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Veiculo!";
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
