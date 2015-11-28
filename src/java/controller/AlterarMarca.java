/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.bean.Marca;
import javax.servlet.http.HttpServletRequest;
import model.dao.MarcaDAO;

/**
 *
 * @author Everton Barros
 */
public class AlterarMarca {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo a Sigla do Marca que deseja alterar
            String codMarca = request.getParameter("CodMarca");
            Marca marca = MarcaDAO.getById(Integer.parseInt(codMarca));
            if(marca != null){
                request.setAttribute("marca",marca);
                jsp = "/alterarmarca.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Marca!";
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
