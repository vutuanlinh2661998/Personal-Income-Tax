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
import java.sql.Statement;
import model.TaxCode;

/**
 *
 * @author BVCN 88
 */
public class TaxCodeDao {
    Connection con;
    DAO dao;
    PreparedStatement pr;

    public TaxCodeDao() {
        dao = new DAO();
        con = dao.getInstance();
    }
    
    public TaxCode getTaxCodebyCode (int code) throws SQLException{
        String sql = "SELECT * FROM tax_code WHERE tax_code = ?";
        ResultSet rs = null;
        TaxCode taxcode = null;
       
            pr = con.prepareStatement(sql);
            pr.setInt(1, code);
            rs = pr.executeQuery();
            System.out.println(rs.findColumn("tax_code"));
            while (rs.next()){
              
               String name = rs.getString(2);
               String sex = rs.getString(3);
               String nationality = rs.getString(4);
               String phone = rs.getString(5);
               String email = rs.getString(6);
               String adress = rs.getString(7);
               boolean status = rs.getBoolean(8);
               taxcode = new TaxCode(code, name, sex, nationality, phone, email, adress, status);       
            }
            if (taxcode != null)
                return taxcode;
            else 
                return  null;
       
    }
    
     public int addTaxCode(TaxCode tax) {
        String sql1 = "INSERT INTO tax_code (`tax_code`,`name`, `sex`, `nationality`, `phone`, `email`, `address`,`status`)"
                + "VALUES(?,?,?,?,?,?,?,?)";
        int returnValue1 = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, Integer.toString(tax.getTaxcode()));
            ps.setString(2, tax.getName());
            ps.setString(3, tax.getSex());
            ps.setString(4, tax.getNationality());
            ps.setString(5, tax.getPhone());
            ps.setString(6, tax.getEmail());
            ps.setString(7, tax.getAddress());
            ps.setBoolean(8, tax.isStatus());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                returnValue1 = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue1;
    }

    public boolean checkTaxcode(TaxCode taxcode) {
        boolean out = false;
        int check = taxcode.getTaxcode();
        String sql = "SELECT * FROM `tax_code` WHERE tax_code = ?";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT * FROM `tax_code` WHERE tax_code = " + check);
            if (rs.next()) {
                out = false;
            } else {
                out = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return out;
    }
    
}
