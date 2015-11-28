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

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.dao.ModeloDAO;
import model.bean.Modelo;

public class ListarModelo {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            ArrayList<Modelo> listModelo = ModeloDAO.getAll();
            if(listModelo != null){
                request.setAttribute("listModelo", listModelo);
                jsp = "/listarmodelo.jsp";
            }else{
                String erro = "Nao existe registro!";
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
