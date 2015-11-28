/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.bean.Usuario;
import javax.servlet.http.HttpServletRequest;
import model.dao.UsuarioDAO;

/**
 *
 * @author Everton Barros
 */
public class AlterarUsuario {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo a Sigla do Usuario que deseja alterar
            String codUsuario = request.getParameter("CodUsuario");
            Usuario usuario = UsuarioDAO.getById(Integer.parseInt(codUsuario));
            if(usuario != null){
                request.setAttribute("usuario",usuario);
                jsp = "/alterarusuario.jsp";
            }else{
                String erro = "Ocorreu erro ao Alterar Usuário!";
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
