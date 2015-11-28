/*
 * EstadoDAO.java
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
import model.bean.Estado;

public class EstadoDAO {
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    
    public static boolean create(Estado estado) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Insert Into Estado(siglaCod, sigla, nome) Values(?,?,?)");
            pstmt.setString(1, estado.getSigla());
            pstmt.setString(2, estado.getSigla());
            pstmt.setString(3, estado.getNome());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean update(Estado estado) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Update Estado Set Sigla=?, Nome = ? Where Sigla = ?");
            pstmt.setString(1, estado.getSigla());
            pstmt.setString(2, estado.getNome());
            pstmt.setString(3, estado.getSiglaCod());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean delete(Estado estado) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Delete From Estado Where sigla = ?");
            pstmt.setString(1, estado.getSigla());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<Estado> getAll() {
        try {
            ArrayList<Estado> listAll = null;
            Estado estado = new Estado();
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From Estado Order By Nome");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                listAll = new ArrayList<Estado>();
                do {
                    estado = new Estado();
                    estado.setSigla(rs.getString("Sigla"));
                    estado.setNome(rs.getString("Nome"));
                    listAll.add(estado);
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
    
    public static Estado getById(String sigla) {
        try {
            Estado estado = null;
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From Estado Where siglaCod = ?");
            pstmt.setString(1, sigla);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                estado = new Estado();
                estado.setSigla(rs.getString("Sigla"));
                estado.setNome(rs.getString("Nome"));
            }
            rs.close();
            pstmt.close();
            return estado;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}