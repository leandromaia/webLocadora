/*
 * GravarAlteracaoVeiculo.java
 *
 * Created on 31 de Março de 2008, 20:39
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author Everton Barros
 */
import model.bean.Veiculo;
import javax.servlet.http.HttpServletRequest;
import model.dao.CategoriaDAO;
import model.dao.MarcaDAO;
import model.dao.ModeloDAO;
import model.dao.VeiculoDAO;

public class GravarAlteracaoVeiculo {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // 
            String placa = request.getParameter("placa");
            // lendo o NomeVeiculo que se deseja alterar
            String codModelo = request.getParameter("codmodelo");
            String codMarca = request.getParameter("codmarca");
            String codCategoria = request.getParameter("codcategoria");
            String descricao = request.getParameter("descricao");            
            Veiculo veiculo = new Veiculo();
            
            veiculo.setPlaca(placa);
            veiculo.setModelo(ModeloDAO.getById(Integer.parseInt(codModelo)));
            veiculo.setMarca(MarcaDAO.getById(Integer.parseInt(codMarca)));
            veiculo.setCategoria(CategoriaDAO.getById(Integer.parseInt(codCategoria)));
            veiculo.setDescricao(descricao);
            
            Boolean delete = VeiculoDAO.update(veiculo);
            if(delete!=false)
                jsp = ListarVeiculo.execute(request);
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
