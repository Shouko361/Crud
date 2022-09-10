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
import model.bean.Produto;

/**
 *
 * @author shouko3613
 */
public class ProdutoDAO {
    
    public void createProd(Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
        
            stmt = con.prepareStatement("INSERT INTO produtos (description, qtd, price) VALUES (?,?,?)");
            stmt.setString(1, p.getDescription());
            stmt.setInt(2, p.getQtd());
            stmt.setDouble(3, p.getPrice());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        
        } finally {
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
    }
    
    public void updateProd(Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
        
            stmt = con.prepareStatement("UPDATE produtos SET description = ?, qtd = ?, price = ? WHERE id = ?");
            stmt.setString(1, p.getDescription());
            stmt.setInt(2, p.getQtd());
            stmt.setDouble(3, p.getPrice());
            stmt.setInt(4, p.getId());            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!"+e);
        
        } finally {
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
    }
    public void deleteProd(Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
        
            stmt = con.prepareStatement("DELETE FROM produtos WHERE id = ?");
            stmt.setInt(1, p.getId());            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao excluir o dado!"+e);
        
        } finally {
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
    }
    
    public List<Produto> listProd(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> products = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM produtos");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Produto product = new Produto();
                
                product.setId(rs.getInt("id"));
                product.setDescription(rs.getString("description"));
                product.setQtd(rs.getInt("qtd"));
                product.setPrice(rs.getDouble("price"));
                
                products.add(product);
                
            }
        
        } catch (SQLException ex) {
        
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return products;
        
    }
    
}
