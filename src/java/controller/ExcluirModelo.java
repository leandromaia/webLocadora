package controller;
/*
 * ListarModelos.java
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
import model.dao.ModeloDAO;
import model.bean.Modelo;

public class ExcluirModelo {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodModelo que se deseja alterar
            String cod = request.getParameter("cod");
            Modelo modelo = ModeloDAO.getById(Integer.parseInt(cod));
            boolean delete = ModeloDAO.delete(modelo);
            if(delete != false){
                jsp = ListarModelo.execute(request);
            }else{
                String erro = "Ocorreu erro ao Excluir Modelo!";
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
