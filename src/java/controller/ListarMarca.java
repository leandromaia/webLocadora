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

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.dao.MarcaDAO;
import model.bean.Marca;

public class ListarMarca {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            ArrayList<Marca> listMarca = MarcaDAO.getAll();
            if(listMarca != null){    
                request.setAttribute("listMarca", listMarca);
                jsp = "/listarmarca.jsp";
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
