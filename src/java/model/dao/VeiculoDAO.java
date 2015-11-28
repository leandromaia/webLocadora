/*
 * VeiculoDAO.java
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
import model.bean.Veiculo;

public class VeiculoDAO {
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    
    public static boolean create(Veiculo veiculo) {
        try {
            //veiculo.setCodVeiculo(Conexao.getAutoInc("Veiculo"));
            pstmt = Conexao.getConnection().prepareStatement(
                    "Insert Into Veiculo(Placa, CodModelo, CodMarca, CodCategoria, Descricao) Values(?,?,?,?,?)");
            pstmt.setString(1, veiculo.getPlaca());
            pstmt.setInt(2, veiculo.getModelo().getCodModelo());
            pstmt.setInt(3,veiculo.getMarca().getCodMarca());
            pstmt.setInt(4, veiculo.getCategoria().getCodCategoria());
            pstmt.setString(5, veiculo.getDescricao());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    public static boolean delete(Veiculo veiculo) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Delete From Veiculo Where Placa = ?");
            pstmt.setString(1, veiculo.getPlaca());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<Veiculo> getAll() {
        try {
            ArrayList<Veiculo> listAll = null;
            Veiculo veiculo = new Veiculo();
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From Veiculo Order By Descricao");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                listAll = new ArrayList<Veiculo>();
                do {
                    veiculo = new Veiculo();
                    veiculo.setPlaca(rs.getString("Placa"));
                    veiculo.setModelo(ModeloDAO.getById(rs.getInt("CodModelo")));
                    veiculo.setMarca(MarcaDAO.getById(rs.getInt("CodMarca")));
                    veiculo.setCategoria(CategoriaDAO.getById(rs.getInt("CodCategoria")));
                    veiculo.setDescricao(rs.getString("Descricao"));
                    listAll.add(veiculo);
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
    
    public static Veiculo getById(String placa) {
        try {
            Veiculo veiculo = null;
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From Veiculo Where Placa = ?");
            pstmt.setString(1, placa);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                veiculo = new Veiculo();
                veiculo.setPlaca(rs.getString("Placa"));
                veiculo.setModelo(ModeloDAO.getById(rs.getInt("CodModelo")));
                veiculo.setMarca(MarcaDAO.getById(rs.getInt("CodMarca")));
                veiculo.setCategoria(CategoriaDAO.getById(rs.getInt("CodCategoria")));
                veiculo.setDescricao(rs.getString("Descricao"));
            }
            rs.close();
            pstmt.close();
            return veiculo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Boolean update(Veiculo veiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}