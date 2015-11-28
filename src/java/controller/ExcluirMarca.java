package controller;
/*
 * ListarMarcas.java
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
import model.dao.MarcaDAO;
import model.bean.Marca;

public class ExcluirMarca {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodMarca que se deseja alterar
            String cod = request.getParameter("cod");
            Marca marca = MarcaDAO.getById(Integer.parseInt(cod));
            boolean delete = MarcaDAO.delete(marca);
            if(delete != false){
                jsp = ListarMarca.execute(request);
            }else{
                String erro = "Ocorreu erro ao Excluir Marca!";
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
