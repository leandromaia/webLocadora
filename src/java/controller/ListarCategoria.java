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

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.dao.CategoriaDAO;
import model.bean.Categoria;

public class ListarCategoria {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            ArrayList<Categoria> listCategoria = CategoriaDAO.getAll();
            if(listCategoria != null){
                request.setAttribute("listCategoria", listCategoria);
                jsp = "/listarcategoria.jsp";    
            }else{
                String erro = "Nao existe registro!";
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
