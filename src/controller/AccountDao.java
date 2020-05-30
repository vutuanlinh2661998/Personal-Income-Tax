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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Account;

/**
 *
 * @author BVCN 88
 */
public class AccountDao {
    Connection con;
    DAO dao;
    PreparedStatement pr;
    
   public AccountDao (){
       dao = new DAO();
       con = dao.getInstance();
   }
   
   public int insertAccount(String username, String password, int taxcode) throws SQLException{
       int status = -1;
        try {
            String sql = "INSERT INTO account (username, password,tax_code,active) VALUES (?,?,?,?)";
            pr = con.prepareStatement(sql);
            pr.setString(1, username);
            pr.setString(2, password);
            pr.setInt(3, taxcode);
            pr.setBoolean(4, false);
            status = pr.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mã số thuế không tồn tại!");
        }
       
        return status;
   }
   
   public ArrayList<Object> selectAccount (String username, String password) throws SQLException{
       ArrayList<Object> account = new ArrayList<>();
       ResultSet rs= null;
       String sql = "SELECT * FROM account WHERE username = ? AND password = ?";
       try {
           pr = con.prepareStatement(sql);
           pr.setString(1, username);
           pr.setString(2, password);
           rs = pr.executeQuery();
           while (rs.next()){
               account.add(rs.getInt(1));
               account.add(rs.getString(2));
               account.add(rs.getString(3));
               account.add(rs.getInt(4));
               account.add(rs.getBoolean(5));
               
           }
       } catch (Exception e) {
       }
       
       return account;
   }
   public int updateAccount (Account acc) throws SQLException{
       int status = -1;
       String sql = "UPDATE account SET username = ?, password = ?, tax_code = ? WHERE account_id = ?";
       try {
           pr = con.prepareStatement(sql);
           pr.setString(1, acc.getUsername());
           pr.setString(2, acc.getPassword());
           pr.setInt(3, acc.getTaxcode().getTaxcode());
           pr.setInt(4, acc.getId());
           status= pr.executeUpdate();
       } catch (Exception e) {
       }
       finally{
           con.close();
       }
       return status;
   }
   
   public int updateStatusAccount (int accountID, boolean active) {
       String sql = "UPDATE account SET active = ? WHERE account_id = ?";
       int status = -1;
       
       try {
           pr = con.prepareStatement(sql);
           pr.setBoolean(1, active);
           pr.setInt(2, accountID);
           status = pr.executeUpdate();
           
       } catch (Exception e) {
       }
       return status;
   }
   
   public int deleteAccount (int id) throws SQLException{
       int status = -1;
       String sql = "DELETE FROM account WHERE id = ?";
       try {
           pr= con.prepareStatement(sql);
           pr.setInt(1, id);
           status = pr.executeUpdate();
       } catch (Exception e) {
       }
      
       return status;
   }
   public ArrayList <Integer> getAllTaxCode () throws SQLException{
       ArrayList <Integer>listtax = new ArrayList<>();
       String sql = "SELECT tax_code FROM tax_code";
       try {
           pr= con.prepareStatement(sql);
           ResultSet rs= pr.executeQuery();
           while(rs.next()){
               listtax.add(rs.getInt("tax_code"));
           }
       } catch (Exception e) {
       }
       
       return  listtax;
   }
   
   
   public ArrayList <Integer> getAllTaxCodeFromAccount () throws SQLException{
       ArrayList <Integer>listtax = new ArrayList<>();
       String sql = "SELECT tax_code FROM account";
       try {
           pr= con.prepareStatement(sql);
           ResultSet rs= pr.executeQuery();
           while(rs.next()){
               listtax.add(rs.getInt("tax_code"));
           }
       } catch (Exception e) {
       }
       
       return  listtax;
   }
    public static void main(String[] args) throws SQLException {
        System.out.println(new AccountDao().selectAccount("tuanlinh", "123").get(0));
    }
}
