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

public class GravarAlteracaoUsuario {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodUsuario que se deseja alterar
            String codUsuario = request.getParameter("codusuario");
            String nome = request.getParameter("nome");
            String nomeCompleto = request.getParameter("nomecompleto");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            Usuario usuario = new Usuario();
            usuario.setCodUsuario(Integer.parseInt(codUsuario));
            usuario.setNome(nome);
            usuario.setNomeCompleto(nomeCompleto);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            
            Boolean delete = UsuarioDAO.update(usuario);
            if(delete!=false)
                jsp = ListarUsuario.execute(request);
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
