/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author Everton Barros
 */

import model.bean.Cidade;
import javax.servlet.http.HttpServletRequest;
import model.dao.CidadeDAO;
public class ExcluirCidade {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo repectiva cidade a ser excluida
            String cod = request.getParameter("cod");
            Cidade cidade = CidadeDAO.getById(Integer.parseInt(cod));                            
            boolean delete = CidadeDAO.delete(cidade);
            if(delete != false){
                jsp = ListarCidade.execute(request);
            }else{
                String erro = "Ocorreu erro ao Excluir Cidade!";
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
