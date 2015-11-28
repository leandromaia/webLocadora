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

public class ExcluirUsuario {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodUsuario que se deseja alterar
            String cod = request.getParameter("cod");
            Usuario usuario = UsuarioDAO.getById(Integer.parseInt(cod));
            boolean delete = UsuarioDAO.delete(usuario);
            if(delete != false){
                jsp = ListarUsuario.execute(request);
            }else{
                String erro = "Ocorreu erro ao Excluir Usuario!";
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
