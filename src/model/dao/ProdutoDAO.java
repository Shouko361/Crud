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
    
}
