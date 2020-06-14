/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestAccountUtil;

import controller.AccountDao;
import controller.DAO;
import controller.TaxCodeDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Account;
import model.TaxCode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import view.ActivationFrame;
import view.Login;
import view.MainScreen;

/**
 *
 * @author BVCN 88
 */
public class NewAccountJUnitTest {
    DAO dao = new DAO();
    Connection con = dao.getInstance();
    PreparedStatement pr ;
    static  AccountDao accDao = new AccountDao();
    int status = -1;
    
    
    public NewAccountJUnitTest() {
        
    }
    
    @Test
    public void addNewAcountValid (){
        try {
            String username = "vũ hữu";
            String password = "123";
            int taxcode = 678910;
            con.setAutoCommit(false);
            String sql = "INSERT INTO account (username, password,tax_code,active) VALUES (?,?,?,?);";
            pr = con.prepareStatement(sql);
            pr.setString(1, username);
            pr.setString(2, password);
            pr.setInt(3, taxcode);
            pr.setBoolean(4, false);
            status = pr.executeUpdate();
            con.rollback();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        assertEquals(1, status);
    } 
    
    @Test
    public void addNewAcountInvalid (){
        try {
            String username = "linh";
            String password = "123";
            int taxcode = 12345;
            con.setAutoCommit(false);
            if(checkTaxcode(taxcode) == true){
                status = 0;
            }else{
               status =  accDao.insertAccount(username, password, taxcode);
            }         
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        assertEquals(0, status);
    }
    
    @Test
    public void addNewActivateCode(){
        
        try {
            String token = "TJSnẹe2";
            int accountID = 1;
            con.setAutoCommit(false);
            String sql = "INSERT INTO activate_code_account (token, expire_date, account_id) VALUES (?,?,?)";
            pr = con.prepareStatement(sql);
            pr.setString(1, token);
            pr.setDate(2, new java.sql.Date(new java.util.Date().getTime() + 12 * 3600));
            pr.setInt(3, accountID);
            status = pr.executeUpdate();
            con.rollback();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        assertEquals(1, status);
    }
    
    @Test
    public void testLoginValid(){
        int accountID = -1 ;
            String username = "vanlong";
            String password = "123";
        try {          
            AccountDao accDao = new AccountDao();
                TaxCodeDao taxDao = new TaxCodeDao(); 
                accountID = (int) accDao.selectAccount(username, password).get(0);

        } catch (SQLException ex) {
            Logger.getLogger(NewAccountJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(23, accountID);
        
    }
    
    @Test 
    public void testLoginWrongUsername (){
        int lenArray = -1 ;
            String username = "vanlong2";
            String password = "123";
        try {          
            AccountDao accDao = new AccountDao();
                TaxCodeDao taxDao = new TaxCodeDao(); 
                ArrayList<Object> listAccount = accDao.selectAccount(username, password);
                if (listAccount.size() == 0)
                    lenArray = 0;

        } catch (SQLException ex) {
            Logger.getLogger(NewAccountJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(0, lenArray);
        
    }
    
    @Test 
    public void testLoginWrongPassword(){
        int lenArray = -1 ;
            String username = "vanlong";
            String password = "1234";
        try {          
            AccountDao accDao = new AccountDao();
                TaxCodeDao taxDao = new TaxCodeDao(); 
                ArrayList<Object> listAccount = accDao.selectAccount(username, password);
                if (listAccount.size() == 0)
                    lenArray = 0;

        } catch (SQLException ex) {
            Logger.getLogger(NewAccountJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(0, lenArray);
        
    }
    
    @Test
    public void testLoginAccountNotActivated (){
        boolean activated = true ;
            String username = "ha";
            String password = "123";
        try {          
            AccountDao accDao = new AccountDao();
                TaxCodeDao taxDao = new TaxCodeDao(); 
                activated = (boolean) accDao.selectAccount(username, password).get(4);

        } catch (SQLException ex) {
            Logger.getLogger(NewAccountJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(false, activated);
    }
    
    
    public static boolean checkTaxcode (int taxcode) throws SQLException{
        boolean status = false;
        ArrayList<Integer> listTax = accDao.getAllTaxCode();
        if (listTax.contains(taxcode))
            status = true;
        return status;
    }

}
