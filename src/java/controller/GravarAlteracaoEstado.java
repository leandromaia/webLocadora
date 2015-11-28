/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.bean.Estado;
import javax.servlet.http.HttpServletRequest;
import model.dao.EstadoDAO;

/**
 *
 * @author Everton Barros
 */
public class GravarAlteracaoEstado {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            //lendo Sigla chave
            String siglaCod = request.getParameter("siglacod");
            // lendo a Sigla do Estado que deseja alterar
            String sigla = request.getParameter("sigla");
            // lendo o Nome do Estado que deseja alterar
            String nome = request.getParameter("nome");
            Estado estado = new Estado();
            estado.setSiglaCod(siglaCod);
            estado.setSigla(sigla);
            estado.setNome(nome);
            
            Boolean delete = EstadoDAO.update(estado);
            if(delete!=false)
                jsp = ListarEstados.execute(request);
            else{
                String erro = "Não foi possível gravar a alteração desse registro";
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
