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

import javax.servlet.http.HttpServletRequest;
import model.dao.UsuarioDAO;
import model.bean.Usuario;

public class GravarInsercaoUsuario {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {            
            Usuario usuario = new Usuario();
            
            Boolean create = UsuarioDAO.create(usuario);
            if(create != false){
                jsp = ListarUsuario.execute(request);    
            }else{
                String erro = "Não foi possível gravar esse registro!";
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
