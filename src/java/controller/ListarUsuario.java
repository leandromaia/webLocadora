package controller;
/*
 * ListarUsuarios.java
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
import model.dao.UsuarioDAO;
import model.bean.Usuario;

public class ListarUsuario {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            ArrayList<Usuario> listUsuario = UsuarioDAO.getAll();
             if(listUsuario != null){
                request.setAttribute("listUsuario", listUsuario);
                jsp = "/listarusuario.jsp";
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
