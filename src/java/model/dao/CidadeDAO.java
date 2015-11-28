/*
 * CidadeDAO.java
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
import model.bean.Cidade;

public class CidadeDAO {
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    
    public static boolean create(Cidade cidade) {
        try {
            cidade.setCodCidade(Conexao.getAutoInc("Cidade"));
            pstmt = Conexao.getConnection().prepareStatement(
                    "Insert Into Cidade(CodCidade, Nome, Sigla) Values(?,?,?)");
            pstmt.setInt(1, cidade.getCodCidade());
            pstmt.setString(2, cidade.getNome());
            pstmt.setString(3,cidade.getEstado().getSigla());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean update(Cidade cidade) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Update Cidade Set Nome = ?, sigla=? Where CodCidade = ?");
            pstmt.setString(1, cidade.getNome());
            pstmt.setString(2, cidade.getEstado().getSigla());
            pstmt.setInt(3, cidade.getCodCidade());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean delete(Cidade cidade) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Delete From Cidade Where CodCidade = ?");
            pstmt.setInt(1, cidade.getCodCidade());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<Cidade> getAll() {
        try {
            ArrayList<Cidade> listAll = null;
            Cidade cidade = new Cidade();
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From Cidade Order By Nome");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                listAll = new ArrayList<Cidade>();
                do {
                    cidade = new Cidade();
                    cidade.setCodCidade(rs.getInt("CodCidade"));
                    cidade.setNome(rs.getString("Nome"));
                    cidade.setEstado(EstadoDAO.getById(rs.getString("sigla")));
                    listAll.add(cidade);
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
    
    public static Cidade getById(int Id) {
        try {
            Cidade cidade = null;
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From Cidade Where CodCidade = ?");
            pstmt.setInt(1, Id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                cidade = new Cidade();
                cidade.setCodCidade(rs.getInt("CodCidade"));
                cidade.setNome(rs.getString("Nome"));
                cidade.setEstado(EstadoDAO.getById(rs.getString("sigla")));
            }
            rs.close();
            pstmt.close();
            return cidade;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}