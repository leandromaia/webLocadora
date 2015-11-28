/*
 * ExcluirVeiculo.java
 *
 * Created on 31 de Março de 2008, 20:37
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
public class ExcluirVeiculoCliente {
     
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo a Sigla do veiculo para exclusão
            String cod = request.getParameter("cod");
            VeiculoCliente veiculoCliente = VeiculoClienteDAO.getById(Integer.parseInt(cod));
            boolean delete = VeiculoClienteDAO.delete(veiculoCliente);
            if(delete != false){
                jsp = ListarVeiculoCliente.execute(request);
            }else{
                String erro = "Ocorreu erro ao Excluir VeiculoCliente!";
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