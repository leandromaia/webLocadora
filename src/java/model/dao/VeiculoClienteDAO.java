/*
 * VeiculoClienteDAO.java
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
import model.bean.VeiculoCliente;

public class VeiculoClienteDAO {
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    
    public static boolean create(VeiculoCliente veiculoCliente) {
        try {
            veiculoCliente.setCodVeiculoCliente(Conexao.getAutoInc("VeiculoCliente"));
            pstmt = Conexao.getConnection().prepareStatement(
                    "Insert Into VeiculoCliente(CodVeiculoCliente, CodCliente, Placa) Values(?,?,?)");
            pstmt.setInt(1, veiculoCliente.getCodVeiculoCliente());
            pstmt.setInt(2,veiculoCliente.getCliente().getCodCliente());            
            pstmt.setString(3, veiculoCliente.getVeiculo().getPlaca());            
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean update(VeiculoCliente veiculoCliente) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Update VeiculoCliente Set CodCliente=?, Placa=? Where CodVeiculoCliente =?");                        
            pstmt.setInt(1,veiculoCliente.getCliente().getCodCliente());            
            pstmt.setString(2, veiculoCliente.getVeiculo().getPlaca());            
            pstmt.setInt(3, veiculoCliente.getCodVeiculoCliente());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean delete(VeiculoCliente veiculoCliente) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Delete From VeiculoCliente Where CodVeiculoCliente = ?");
            pstmt.setInt(1, veiculoCliente.getCodVeiculoCliente());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<VeiculoCliente> getAll() {
        try {
            ArrayList<VeiculoCliente> listAll = null;
            VeiculoCliente veiculoCliente = new VeiculoCliente();
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From VeiculoCliente Order By CodCliente");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                listAll = new ArrayList<VeiculoCliente>();
                do {
                    veiculoCliente = new VeiculoCliente();                    
                    veiculoCliente.setCodVeiculoCliente(rs.getInt("CodVeiculoCliente"));
                    veiculoCliente.setCliente(ClienteDAO.getById(rs.getInt("CodCliente")));
                    veiculoCliente.setVeiculo(VeiculoDAO.getById(rs.getString("Placa")));
                    listAll.add(veiculoCliente);
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
    
    public static VeiculoCliente getById(int Id) {
        try {
            VeiculoCliente veiculoCliente = null;
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From VeiculoCliente Where CodVeiculoCliente = ?");
            pstmt.setInt(1, Id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                veiculoCliente = new VeiculoCliente();
                veiculoCliente.setCodVeiculoCliente(rs.getInt("CodVeiculoCliente"));
                veiculoCliente.setCliente(ClienteDAO.getById(rs.getInt("CodCliente")));
                veiculoCliente.setVeiculo(VeiculoDAO.getById(rs.getString("Placa")));
            }
            rs.close();
            pstmt.close();
            return veiculoCliente;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}