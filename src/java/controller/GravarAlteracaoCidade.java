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
import model.dao.EstadoDAO;

public class GravarAlteracaoCidade {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // 
            String codCidade = request.getParameter("codCidade");
            // lendo o NomeCidade que se deseja alterar
            String nome = request.getParameter("nome");
            // lendo o CodDepartamento que se deseja alterar
            String sigla = request.getParameter("sigla");
            Cidade cidade = new Cidade();
            cidade.setCodCidade(Integer.parseInt(codCidade));
            cidade.setNome(nome);
            cidade.setEstado(EstadoDAO.getById(sigla));
            Boolean delete = CidadeDAO.update(cidade);
            if(delete!=false)
                jsp = ListarCidade.execute(request);
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
