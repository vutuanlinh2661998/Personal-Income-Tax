/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author BVCN 88
 */
public class ActivationCodeDao {
    Connection con;
    DAO dao;
    PreparedStatement pr;

    public ActivationCodeDao() {
        dao = new DAO();
        con = dao.getInstance();
    }
     public int insertActivationCode (String token, Date expireDate, int accountID) throws SQLException{
         int status = -1;
        try {
            String sql = "INSERT INTO activate_code_account (token, expire_date, account_id) VALUES (?,?,?)";
            pr = con.prepareStatement(sql);
            pr.setString(1, token);
            pr.setDate(2, new java.sql.Date(new java.util.Date().getTime() + 12 * 3600));
            pr.setInt(3, accountID);
            status = pr.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mã số thuế không tồn tại!");
        }
//        finally{
//            con.close();
//        }
        return status;
     }
    public  String findByAccountID (int accountID) throws SQLException{
        
            String sql = "SELECT * FROM activate_code_account WHERE account_id = ? ";
             pr = con.prepareStatement(sql);
             pr.setInt(1, accountID);
             ResultSet rs = pr.executeQuery();
             if(rs.next()){
                  String token = rs.getString(2);
                  return token;
              }else
                 return null;
             
        
    }
    
    
}
