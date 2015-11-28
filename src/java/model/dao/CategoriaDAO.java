/*
 * Categoria.java
 *
 * Created on 20 de Março de 2008, 19:28
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
import model.bean.Categoria;

public class CategoriaDAO {
    
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    
    public static boolean create(Categoria categoria) {
        try {
            categoria.setCodCategoria(Conexao.getAutoInc("Categoria"));
            pstmt = Conexao.getConnection().prepareStatement(
                    "Insert Into Categoria(CodCategoria, Descricao) Values(?,?)");
            pstmt.setInt(1, categoria.getCodCategoria());
            pstmt.setString(2, categoria.getDescricao());            
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean update(Categoria categoria) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Update Categoria Set Descricao = ? Where CodCategoria = ?");
            pstmt.setString(1, categoria.getDescricao());            
            pstmt.setInt(2, categoria.getCodCategoria());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean delete(Categoria categoria) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Delete From Categoria Where CodCategoria = ?");
            pstmt.setInt(1, categoria.getCodCategoria());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<Categoria> getAll() {
        try {
            ArrayList<Categoria> listAll = null;
            Categoria categoria = new Categoria();
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From Categoria Order By Descricao");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                listAll = new ArrayList<Categoria>();
                do {
                    categoria = new Categoria();
                    categoria.setCodCategoria(rs.getInt("CodCategoria"));
                    categoria.setDescricao(rs.getString("Descricao"));                    
                    listAll.add(categoria);
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
    
    public static Categoria getById(int Id) {
        try {
            Categoria categoria = null;
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From Categoria Where CodCategoria = ?");
            pstmt.setInt(1, Id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                categoria = new Categoria();
                categoria.setCodCategoria(rs.getInt("CodCategoria"));
                categoria.setDescricao(rs.getString("Descricao"));                
            }
            rs.close();
            pstmt.close();
            return categoria;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
}
