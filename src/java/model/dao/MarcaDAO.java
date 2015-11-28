/*
 * MarcaDAO.java
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
import model.bean.Marca;

public class MarcaDAO {
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    
    public static boolean create(Marca marca) {
        try {
            marca.setCodMarca(Conexao.getAutoInc("Marca"));
            pstmt = Conexao.getConnection().prepareStatement(
                    "Insert Into Marca(CodMarca, Descricao) Values(?,?)");
            pstmt.setInt(1, marca.getCodMarca());
            pstmt.setString(2, marca.getDescricao());            
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean update(Marca marca) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Update Marca Set Descricao = ? Where CodMarca = ?");
            pstmt.setString(1, marca.getDescricao());            
            pstmt.setInt(2, marca.getCodMarca());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean delete(Marca marca) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Delete From Marca Where CodMarca = ?");
            pstmt.setInt(1, marca.getCodMarca());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<Marca> getAll() {
        try {
            ArrayList<Marca> listAll = null;
            Marca marca = new Marca();
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From Marca Order By Descricao");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                listAll = new ArrayList<Marca>();
                do {
                    marca = new Marca();
                    marca.setCodMarca(rs.getInt("CodMarca"));
                    marca.setDescricao(rs.getString("Descricao"));                    
                    listAll.add(marca);
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
    
    public static Marca getById(int Id) {
        try {
            Marca marca = null;
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From Marca Where CodMarca = ?");
            pstmt.setInt(1, Id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                marca = new Marca();
                marca.setCodMarca(rs.getInt("CodMarca"));
                marca.setDescricao(rs.getString("Descricao"));                
            }
            rs.close();
            pstmt.close();
            return marca;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}