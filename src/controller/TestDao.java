/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author BVCN 88
 */
public class TestDao {
    
    public static void main(String[] args) throws SQLException {
       AccountDao acc= new AccountDao();
       TaxCodeDao taxDao = new TaxCodeDao();
        ArrayList<Object>account = acc.selectAccount("long", "123");
        System.out.println((int)account.get(0));
    }
    
    
}
