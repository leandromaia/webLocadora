/*
 * InserirVeiculo.java
 *
 * Created on 31 de Março de 2008, 20:50
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;

import controller.vo.Marca;
import controller.vo.Modelo;
import controller.vo.Categoria;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.MarcaDAO;
import model.ModeloDAO;
import model.CategoriaDAO;

/**
 *
 * @author ebarros
 */
public class InserirVeiculo {
     public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            //lista de marcas
            ArrayList<Marca> listMarca = MarcaDAO.getAll();
            request.setAttribute("listMarca", listMarca);
            //lista de modelos
            ArrayList<Modelo> listModelo = ModeloDAO.getAll();
            request.setAttribute("listModelo", listModelo);
            //lista de categorias
            ArrayList<Categoria> listCategoria = CategoriaDAO.getAll();
            if(listMarca ==null || listModelo == null || listCategoria == null ){
                String erro = "Nao existe registro!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            }else{
                request.setAttribute("listCategoria", listCategoria);                      
                jsp = "/inserirveiculo.jsp";    
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}