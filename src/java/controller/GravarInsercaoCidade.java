/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author Everton Barros
 */
import controller.vo.Cidade;
import javax.servlet.http.HttpServletRequest;
import model.CidadeDAO;
import model.EstadoDAO;
public class GravarInsercaoCidade {
     public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // 
            String nome = request.getParameter("nome");
            // 
            String sigla = request.getParameter("sigla");
            Cidade cidade = new Cidade();
            cidade.setNome(nome);
            cidade.setEstado(EstadoDAO.getById(sigla));
            
            Boolean create = CidadeDAO.create(cidade);
            if(create != false){
                jsp = ListarCidade.execute(request);    
            }else{
                String erro = "Não foi possível gravar esse registro!";
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
