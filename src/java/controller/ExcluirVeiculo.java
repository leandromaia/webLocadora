/*
 * ExcluirVeiculo.java
 *
 * Created on 31 de Março de 2008, 20:37
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
 * @author Everton Barros
 */
public class ExcluirVeiculo {
     
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo a Sigla do veiculo para exclusão
            String cod = request.getParameter("cod");
            Veiculo veiculo = VeiculoDAO.getById(cod);
           boolean delete = VeiculoDAO.delete(veiculo);
            if(delete != false){
                jsp = ListarVeiculo.execute(request);
            }else{
                String erro = "Ocorreu erro ao Excluir Veiculo!";
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