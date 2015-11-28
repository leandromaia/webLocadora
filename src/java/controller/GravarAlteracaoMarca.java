package controller;
/*
 * ListarMarcas.java
 *
 * Created on 26 de Fevereiro de 2008, 20:38
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Everton Barros
 */

import javax.servlet.http.HttpServletRequest;
import model.dao.MarcaDAO;
import model.bean.Marca;

public class GravarAlteracaoMarca {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodMarca que se deseja alterar
            String codMarca = request.getParameter("codmarca");
            // lendo o NomeMarca que se deseja alterar
            String descricao = request.getParameter("descricao");
            Marca marca = new Marca();
            marca.setCodMarca(Integer.parseInt(codMarca));
            marca.setDescricao(descricao);
            
            Boolean delete = MarcaDAO.update(marca);
            if(delete!=false)
                jsp = ListarMarca.execute(request);
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
