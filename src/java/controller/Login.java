/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author ebarros
 */

import model.bean.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.UsuarioDAO;
        
public class Login {
     
    @SuppressWarnings("static-access")
    public static String execute(HttpServletRequest request) {        
        
        String erro="";        
        String jsp="";        
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        
        Usuario usr = new Usuario();
        UsuarioDAO usrDAO = new UsuarioDAO();        
        try {
            usr = usrDAO.getUserLogin(nome, senha);
            if(usr == null){
                erro="Usuário não encontrado!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            }               
            else{
                request.getSession().setAttribute("codUsuario", usr.getCodUsuario());                
                jsp = "/menu.jsp";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;        
     }
    
    public static void validarSessao(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        Integer codUsuario = (Integer) request.getSession().getAttribute("codUsuario");
        String jsp="";
        if(codUsuario == null ){
            jsp = "/index.jsp";
             //Redirecionando pagina
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.forward(request, response);
        }        
    }
}
