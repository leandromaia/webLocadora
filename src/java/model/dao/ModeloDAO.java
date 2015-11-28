/*
 * ModeloDAO.java
 *
 * Created on 10 de Mar�o de 2008, 19:05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.dao;

/**
 *
 * @author root
 */

import java.sql.*;
import java.util.ArrayList;
import model.bean.Modelo;

public class ModeloDAO {
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    
    public static boolean create(Modelo modelo) {
        try {
            modelo.setCodModelo(Conexao.getAutoInc("Modelo"));
            pstmt = Conexao.getConnection().prepareStatement(
                    "Insert Into Modelo(CodModelo, Descricao) Values(?,?)");
            pstmt.setInt(1, modelo.getCodModelo());
            pstmt.setString(2, modelo.getDescricao());            
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean update(Modelo modelo) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Update Modelo Set Descricao = ? Where CodModelo = ?");
            pstmt.setString(1, modelo.getDescricao());            
            pstmt.setInt(2, modelo.getCodModelo());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean delete(Modelo modelo) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Delete From Modelo Where CodModelo = ?");
            pstmt.setInt(1, modelo.getCodModelo());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<Modelo> getAll() {
        try {
            ArrayList<Modelo> listAll = null;
            Modelo modelo = new Modelo();
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From Modelo Order By Descricao");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                listAll = new ArrayList<Modelo>();
                do {
                    modelo = new Modelo();
                    modelo.setCodModelo(rs.getInt("CodModelo"));
                    modelo.setDescricao(rs.getString("Descricao"));                    
                    listAll.add(modelo);
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            return listAll;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Modelo getById(int Id) {
        try {
            Modelo modelo = null;
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From Modelo Where CodModelo = ?");
            pstmt.setInt(1, Id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                modelo = new Modelo();
                modelo.setCodModelo(rs.getInt("CodModelo"));
                modelo.setDescricao(rs.getString("Descricao"));                
            }
            rs.close();
            pstmt.close();
            return modelo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}