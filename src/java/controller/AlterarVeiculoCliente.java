/*
 * Veiculo.java
 *
 * Created on 31 de Março de 2008, 20:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;

import model.bean.VeiculoCliente;
import javax.servlet.http.HttpServletRequest;
import model.dao.VeiculoClienteDAO;

/**
 *
 * @author Everton Barros
 */
public class AlterarVeiculoCliente {
 
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodVeiculo que se deseja alterar
            String codVeiculoCliente = request.getParameter("CodVeiculoCliente");
            VeiculoCliente veiculoCliente = VeiculoClienteDAO.getById(Integer.parseInt(codVeiculoCliente));
            if(veiculoCliente != null){
                request.setAttribute("veiculoCliente",veiculoCliente);
                jsp = "/alterarveiculocliente.jsp";
             }else{
                String erro = "Ocorreu erro ao Alterar VeiculoCliente!";
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
