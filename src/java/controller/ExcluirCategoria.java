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
import model.dao.CategoriaDAO;
import model.bean.Categoria;

public class ExcluirCategoria {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodCategoria que se deseja alterar
            String cod = request.getParameter("cod");
            Categoria categoria = CategoriaDAO.getById(Integer.parseInt(cod));            
            boolean delete = CategoriaDAO.delete(categoria);
            if(delete != false){    
                jsp = ListarCategoria.execute(request);
             }else{
                String erro = "Ocorreu erro ao Excluir Categoria!";
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
