/*
 * ClienteDAO.java
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

import controller.FormatUtils;
import java.sql.*;
import java.util.ArrayList;
import model.bean.Cliente;

public class ClienteDAO {
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    
    public static boolean create(Cliente cliente) {
        try {
            cliente.setCodCliente(Conexao.getAutoInc("Cliente"));
            
            String dataNasc = cliente.getDataNasc();
            
            dataNasc = FormatUtils.formatDateJdbc(dataNasc);
            
            pstmt = Conexao.getConnection().prepareStatement(
                    "Insert Into Cliente(CodCliente, CodCidade, Nome, cpf, dataNasc, endereco, bairro, fone, email) " +
                    "Values(?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, cliente.getCodCliente());
            pstmt.setInt(2, cliente.getCidade().getCodCidade());
            pstmt.setString(3, cliente.getNome());
            pstmt.setString(4, cliente.getCpf());
            pstmt.setString(5, dataNasc);
            pstmt.setString(6, cliente.getEndereco());
            pstmt.setString(7, cliente.getBairro());
            pstmt.setString(8, cliente.getFone());
            pstmt.setString(9, cliente.getEmail());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean update(Cliente cliente) {
        String dataNasc = cliente.getDataNasc();
        
        dataNasc = FormatUtils.formatDateJdbc(dataNasc);
        
        try {            
            pstmt = Conexao.getConnection().prepareStatement(
                    "Update Cliente Set CodCidade=?, Nome=?, cpf=?, dataNasc=?, endereco=?, bairro=?, fone=?, email=? Where CodCliente = ?");
            pstmt.setInt(1, cliente.getCidade().getCodCidade());
            pstmt.setString(2, cliente.getNome());            
            pstmt.setString(3, cliente.getCpf());
            pstmt.setString(4, dataNasc);
            pstmt.setString(5, cliente.getEndereco());
            pstmt.setString(6, cliente.getBairro());
            pstmt.setString(7, cliente.getFone());
            pstmt.setString(8, cliente.getEmail());
            pstmt.setInt(9, cliente.getCodCliente());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean delete(Cliente cliente) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Delete From Cliente Where CodCliente = ?");
            pstmt.setInt(1, cliente.getCodCliente());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<Cliente> getAll() {       
        try {
            ArrayList<Cliente> listAll = null;
            Cliente cliente = new Cliente();            
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From Cliente Order By Nome");
            rs = pstmt.executeQuery();           
            
            if (rs.next()) {
                listAll = new ArrayList<Cliente>();
                do {                    
                    cliente = new Cliente();
                    
                    /*formata data*/
                    String dataNasc = rs.getDate("DataNasc").toString();
                    dataNasc = FormatUtils.formatDateUser(dataNasc);
                    
                    cliente.setCodCliente(rs.getInt("CodCliente"));
                    cliente.setCidade(CidadeDAO.getById(rs.getInt("CodCidade")));                    
                    cliente.setNome(rs.getString("Nome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setDataNasc(dataNasc);
                    cliente.setEndereco(rs.getString("Endereco"));
                    cliente.setBairro(rs.getString("Bairro"));
                    cliente.setFone(rs.getString("Fone"));
                    cliente.setEmail(rs.getString("Email"));
                    listAll.add(cliente);
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
    
    public static Cliente getById(int Id) {
        try {
            Cliente cliente = null;
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From Cliente Where CodCliente = ?");
            pstmt.setInt(1, Id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                    
                /*formata data*/
                String dataNasc = rs.getDate("DataNasc").toString();
                dataNasc = FormatUtils.formatDateUser(dataNasc);

                cliente.setCodCliente(rs.getInt("CodCliente"));
                cliente.setCidade(CidadeDAO.getById(rs.getInt("CodCidade")));                    
                cliente.setNome(rs.getString("Nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setDataNasc(dataNasc);
                cliente.setEndereco(rs.getString("Endereco"));
                cliente.setBairro(rs.getString("Bairro"));
                cliente.setFone(rs.getString("Fone"));
                cliente.setEmail(rs.getString("Email"));
        }
            rs.close();
            pstmt.close();
            return cliente;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}