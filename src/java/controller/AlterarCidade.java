/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.bean.Cidade;
import javax.servlet.http.HttpServletRequest;
import model.dao.CidadeDAO;

/**
 *
 * @author ebarros
 */
public class AlterarCidade {
 
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodCidade que se deseja alterar
            String codCidade = request.getParameter("CodCidade");
            Cidade cidade = CidadeDAO.getById(Integer.parseInt(codCidade));
            if(cidade != null){
                request.setAttribute("cidade",cidade);            
                jsp = "/alterarcidade.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Cidade!";
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
