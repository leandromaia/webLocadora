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
import model.MarcaDAO;
import controller.vo.Marca;

public class GravarInsercaoMarca {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o NomeMarca que se deseja alterar
            String descricao = request.getParameter("descricao");
            Marca marca = new Marca();
            marca.setDescricao(descricao);
            
            Boolean create = MarcaDAO.create(marca);
            if(create != false){
                jsp = ListarMarca.execute(request);    
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
