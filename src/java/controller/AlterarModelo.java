/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.bean.Modelo;
import javax.servlet.http.HttpServletRequest;
import model.dao.ModeloDAO;

/**
 *
 * @author Everton Barros
 */
public class AlterarModelo {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo a Sigla do Modelo que deseja alterar
            String codModelo = request.getParameter("CodModelo");
            Modelo modelo = ModeloDAO.getById(Integer.parseInt(codModelo));
            if(modelo != null){
                request.setAttribute("modelo",modelo);
                jsp = "/alterarmodelo.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Modelo!";
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
