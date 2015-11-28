/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.bean.Categoria;
import javax.servlet.http.HttpServletRequest;
import model.dao.CategoriaDAO;

/**
 *
 * @author Everton Barros
 */
public class AlterarCategoria {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo a Sigla do Categoria que deseja alterar
            String codCategoria = request.getParameter("CodCategoria");
            Categoria categoria = CategoriaDAO.getById(Integer.parseInt(codCategoria));
            if(categoria != null){
                request.setAttribute("categoria",categoria);
                jsp = "/alterarcategoria.jsp";
            }else{
               String erro = "Ocorreu erro ao alterar a categoria";
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
