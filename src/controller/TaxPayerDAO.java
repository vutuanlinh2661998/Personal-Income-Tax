/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.TaxCode;
import model.TaxDeclare;
import model.TaxPayer;
import view.Tax_Receipt;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thaik
 */
public class TaxPayerDAO {

      Connection con;
      DAO dao;
      PreparedStatement ps;

    public TaxPayerDAO() {
        dao = new DAO();
        con= dao.getInstance();
    }
      
      
      
    public ArrayList<TaxPayer> fillTaxPayer(int user_id, String tax_period) throws SQLException {
        TaxPayer tp = null;
        ArrayList<TaxPayer> list = new ArrayList<>();
//        dao = new DAO();
//        con= dao.getInstance();
        

      
        String sql = "SELECT a.tax_code,td.user_id,tc.name,tc.address,td.tax_period,td.total,td.time_update\n" +
"                                FROM tax_declare td\n" +
"                               JOIN account a\n" +
"                              ON a.account_id=td.user_id\n" +
"                           JOIN tax_code tc \n" +
"                              ON tc.tax_code = a.tax_code\n" +
"                         WHERE a.account_id = ?\n" +
"                         AND td.tax_period LIKE ?";

        PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ps.setInt(1, user_id);
        ps.setString(2, tax_period);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
//
            TaxCode taxCode = new TaxCode(rs.getInt("tax_code"), rs.getInt("user_id"), rs.getString("name"), null, null, null, null, rs.getString("address"), true);
            TaxDeclare declare = new TaxDeclare(rs.getString("tax_period"), rs.getFloat("total"), rs.getString("time_update"));
            tp = new TaxPayer();

            tp.setTaxDeclare(declare);
            tp.setTax_code(taxCode);

            list.add(tp);
        }

        return list;
    }

    public  void insertDB(String bank, String bankCode, String currency, Timestamp time, int tax_code, int user_id) {

        
        String sql = "INSERT into Tax_Payer( bank, bankCode, currency, date, tax_code, user_id) value(?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, bank);
            ps.setString(2, bankCode);
            ps.setString(3, currency);
            ps.setTimestamp(4, time);
            ps.setInt(5, tax_code);
            ps.setInt(6, user_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaxPayerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) throws SQLException {
        TaxPayerDAO aO = new TaxPayerDAO();
       
//        aO.fillTaxPayer(3);
//        System.out.println("Total" + aO.fillTaxPayer(3).getTaxDeclare().getTotal());
        ArrayList<TaxPayer> list = new ArrayList<>();
        list = aO.fillTaxPayer(2,"Quý 2 ( Từ tháng 4 đến tháng 6)");
        int size = list.size();
        System.out.println(size);
        System.out.println("Total: " + list.get(size-1).getTaxDeclare().getTotal());

    }
}
