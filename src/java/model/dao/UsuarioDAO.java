/*
 * UsuarioDAO.java
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
import model.bean.Usuario;

public class UsuarioDAO {
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    
    public static boolean create(Usuario usuario) {
        try {
            usuario.setCodUsuario(Conexao.getAutoInc("Usuario"));
            pstmt = Conexao.getConnection().prepareStatement(
                    "Insert Into Usuario(CodUsuario, Senha, Nome, NomeCompleto, email) Values(?,?,?,?,?)");
            pstmt.setInt(1, usuario.getCodUsuario());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setString(3,usuario.getNome());
            pstmt.setString(4, usuario.getNomeCompleto());
            pstmt.setString(5, usuario.getEmail());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean update(Usuario usuario) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Update Usuario Set Senha=?, Nome=?, NomeCompleto=?, email=? Where CodUsuario = ?");
            pstmt.setString(1, usuario.getSenha());            
            pstmt.setString(2, usuario.getNome());
            pstmt.setString(3, usuario.getNomeCompleto());
            pstmt.setString(4, usuario.getEmail());
            pstmt.setInt(5, usuario.getCodUsuario());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean delete(Usuario usuario) {
        try {
            pstmt = Conexao.getConnection().prepareStatement(
                    "Delete From Usuario Where CodUsuario = ?");
            pstmt.setInt(1, usuario.getCodUsuario());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<Usuario> getAll() {
        try {
            ArrayList<Usuario> listAll = null;
            Usuario usuario = new Usuario();
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From Usuario Order By Nome");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                listAll = new ArrayList<Usuario>();
                do {
                    usuario = new Usuario();
                    usuario.setCodUsuario(rs.getInt("CodUsuario"));
                    usuario.setSenha(rs.getString("Senha"));
                    usuario.setNome(rs.getString("Nome"));
                    usuario.setNomeCompleto(rs.getString("NomeCompleto"));
                    usuario.setEmail(rs.getString("Email"));
                    listAll.add(usuario);
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
    
    public static Usuario getById(int Id) {
        try {
            Usuario usuario = null;
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From Usuario Where CodUsuario = ?");
            pstmt.setInt(1, Id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setCodUsuario(rs.getInt("CodUsuario"));
                usuario.setSenha(rs.getString("Senha"));
                usuario.setNome(rs.getString("Nome"));
                usuario.setNomeCompleto(rs.getString("NomeCompleto"));
                usuario.setEmail(rs.getString("Email"));
            }
            rs.close();
            pstmt.close();
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Usuario getUserLogin(String nome, String senha){
        try {
            Usuario user = null;
            
            pstmt = Conexao.getConnection().prepareStatement(
                    "Select * From Usuario Where Nome=? AND Senha=?");
            pstmt.setString(1, nome);
            pstmt.setString(2, senha);
            rs = pstmt.executeQuery();
            if(rs.next()){
                user = new Usuario();
                user.setCodUsuario(rs.getInt("CodUsuario"));
                user.setSenha(rs.getString("Senha"));
                user.setNome(rs.getString("Nome"));
                user.setNomeCompleto(rs.getString("NomeCompleto"));
                user.setEmail(rs.getString("Email"));
            }
            
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }
            
    
    
}