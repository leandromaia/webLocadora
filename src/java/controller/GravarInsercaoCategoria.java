package controller;
/*
 * ListarCategorias.java
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
import model.CategoriaDAO;
import controller.vo.Categoria;

public class GravarInsercaoCategoria {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o NomeCategoria que se deseja alterar
            String descricao = request.getParameter("descricao");
            Categoria categoria = new Categoria();
            categoria.setDescricao(descricao);
            Boolean create = CategoriaDAO.create(categoria);
            if(create != false){
                jsp = ListarCategoria.execute(request);    
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
