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
            // lendo o NomeUsuario que se deseja alterar
            String nome = request.getParameter("nome");
            String nomeCompleto = request.getParameter("nomecompleto");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setNomeCompleto(nomeCompleto);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            
            Boolean create = UsuarioDAO.create(usuario);
            if(create != false){
                jsp = ListarUsuario.execute(request);    
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
