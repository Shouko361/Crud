/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Usuario;

/**
 *
 * @author shouko3613
 */
public class UsuarioDAO {
    
    public void createUser(Usuario u){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
        
            stmt = con.prepareStatement("INSERT INTO user (name, email, password, cep, bairro, rua, cidade, estado) VALUES (?,?,?,?,?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getPassword());
            stmt.setString(4, u.getCep());
            stmt.setString(5, u.getBairro());
            stmt.setString(6, u.getRua());
            stmt.setString(7, u.getCidade());
            stmt.setString(8, u.getEstado());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuario Salvo com sucesso!");
        
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao salvar o usuario!");
        
        } finally {
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
    }
    
    public void updateUser(Usuario u){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
        
            stmt = con.prepareStatement("UPDATE user SET name = ?, email = ?, cep = ?, bairro = ?, rua = ?, cidade = ? , estado = ?, WHERE id = ?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getCep());
            stmt.setString(4, u.getBairro());
            stmt.setString(5, u.getRua());
            stmt.setString(6, u.getCidade());
            stmt.setString(7, u.getEstado());
            stmt.setInt(8, u.getId());            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso!");
        
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o usuario!"+e);
        
        } finally {
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
    }
    
    public void deleteUser(Usuario u){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
        
            stmt = con.prepareStatement("DELETE FROM user WHERE id = ?");
            stmt.setInt(1, u.getId());            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuario excluido com sucesso!");
        
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao excluir o usuario!"+e);
        
        } finally {
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
    }
    
    public List<Usuario> searchUser(String email){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> users = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM user WHERE email LIKE ?");
            stmt.setString(1, "%"+email+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Usuario user = new Usuario();
                
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setCep(rs.getString("cep"));
                user.setBairro(rs.getString("bairro"));
                user.setRua(rs.getString("rua"));
                user.setCidade(rs.getString("cidade"));
                user.setEstado(rs.getString("estado"));
                
                users.add(user);
                
            }
        
        } catch (SQLException ex) {
        
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return users;
        
    }
    
    public boolean checkLogin(String email, String pass){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean  status = false;
        
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM user WHERE name = ? OR email = ? and password = ?");
            stmt.setString(1, email);
            stmt.setString(2, email);
            stmt.setString(3, pass);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                
                status = true;
                
            }
        
        } catch (SQLException ex) {
        
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return status;
        
    }
    
    public List<Usuario> listUser(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> users = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM user");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Usuario user = new Usuario();
                
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setCep(rs.getString("cep"));
                user.setBairro(rs.getString("bairro"));
                user.setRua(rs.getString("rua"));
                user.setCidade(rs.getString("cidade"));
                user.setEstado(rs.getString("estado"));
                
                users.add(user);
                
            }
        
        } catch (SQLException ex) {
        
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return users;
        
    }
    
}
