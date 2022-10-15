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
import model.bean.Cep;
/**
 *
 * @author shouko3613
 */
public class CepDAO {
    
    public void createCep(Cep c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
        
            stmt = con.prepareStatement("INSERT INTO ceps (cep, bairro, rua, cidade, uf) VALUES (?,?,?,?,?)");
            stmt.setString(1, c.getCep());
            stmt.setString(2, c.getBairro());
            stmt.setString(3, c.getRua());
            stmt.setString(4, c.getCidade());
            stmt.setString(5, c.getUf());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "CEP Salvo com sucesso!");
        
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao salvar o CEP!\nJá existe este CEP cadastrado!");
        
        } finally {
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
    }
    
    public void updateCep(Cep c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
        
            stmt = con.prepareStatement("UPDATE ceps SET cep = ?, bairro = ?, rua = ?, cidade = ? , uf = ?, WHERE id = ?");
            stmt.setString(1, c.getCep());
            stmt.setString(2, c.getBairro());
            stmt.setString(3, c.getRua());
            stmt.setString(4, c.getCidade());
            stmt.setString(5, c.getUf());
            stmt.setInt(6, c.getId());            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "CEP atualizado com sucesso!");
        
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o CEP!"+e);
        
        } finally {
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
    }
    
    public void deleteCep(Cep c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
        
            stmt = con.prepareStatement("DELETE FROM ceps WHERE id = ?");
            stmt.setInt(1, c.getId());            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "CEP excluido com sucesso!");
        
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao excluir o CEP!"+e);
        
        } finally {
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
    }
    
    public List<Cep> searchCep(String cep){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cep> ceps = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM ceps WHERE cep LIKE ?");
            stmt.setString(1, "%"+cep+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Cep CEP = new Cep();
                
                CEP.setId(rs.getInt("id"));
                CEP.setCep(rs.getString("cep"));
                CEP.setBairro(rs.getString("bairro"));
                CEP.setRua(rs.getString("rua"));
                CEP.setCidade(rs.getString("cidade"));
                CEP.setUf(rs.getString("uf"));
                
                ceps.add(CEP);
                
            }
        
        } catch (SQLException ex) {
        
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return ceps;
        
    }
    
    public List<Cep> listCep(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cep> ceps = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM ceps");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Cep CEP = new Cep();
                
                CEP.setId(rs.getInt("id"));
                CEP.setCep(rs.getString("cep"));
                CEP.setBairro(rs.getString("bairro"));
                CEP.setRua(rs.getString("rua"));
                CEP.setCidade(rs.getString("cidade"));
                CEP.setUf(rs.getString("uf"));
                
                ceps.add(CEP);
                
            }
        
        } catch (SQLException ex) {
        
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return ceps;
        
    }
    
}
