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
import model.ModeloDAO;
import controller.vo.Modelo;

public class GravarAlteracaoModelo {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o CodModelo que se deseja alterar
            String codModelo = request.getParameter("codmodelo");
            // lendo o NomeModelo que se deseja alterar
            String descricao = request.getParameter("descricao");
            Modelo modelo = new Modelo();
            modelo.setCodModelo(Integer.parseInt(codModelo));
            modelo.setDescricao(descricao);
            
            Boolean delete = ModeloDAO.update(modelo);
            if(delete!=false)
                jsp = ListarModelo.execute(request);
            else{
                String erro = "N�o foi poss�vel gravar a altera��o desse registro";
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
