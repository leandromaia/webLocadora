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
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.dao.CidadeDAO;
public class ListarCidade {
     
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            ArrayList<Cidade> listCidade = CidadeDAO.getAll();
            if(listCidade != null){
                request.setAttribute("listCidade", listCidade);
                jsp = "/listarcidade.jsp";    
            }else{
                String erro="Não existe Cidades!";
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
