/*
 * GravarInsercaoVeiculo.java
 *
 * Created on 31 de Mar�o de 2008, 20:46
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author Everton Barros
 */
import controller.vo.Veiculo;
import javax.servlet.http.HttpServletRequest;
import model.CategoriaDAO;
import model.MarcaDAO;
import model.ModeloDAO;
import model.VeiculoDAO;

public class GravarInsercaoVeiculo{
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
            
            Boolean create = VeiculoDAO.create(veiculo);
            if(create != false){
                jsp = ListarVeiculo.execute(request);    
            }else{
                String erro = "N�o foi poss�vel gravar esse registro!";
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
