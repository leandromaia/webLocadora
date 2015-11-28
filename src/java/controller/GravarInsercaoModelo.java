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

public class GravarInsercaoModelo {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // lendo o NomeModelo que se deseja alterar
            String descricao = request.getParameter("descricao");
            Modelo modelo = new Modelo();
            modelo.setDescricao(descricao);
            
            Boolean create = ModeloDAO.create(modelo);
            if(create != false){
                jsp = ListarModelo.execute(request);    
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
