/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.TaxDeclare;

/**
 *
 * @author BVCN 88
 */
public class TaxDeclareDao {
    DAO dao;
    Connection con;
    PreparedStatement pr;

    public TaxDeclareDao() {
        dao = new DAO();
        con = dao.getInstance();
    }
    
    public int insertTaxDeclare (TaxDeclare declare) {
        int status = -1;
        try {   
            String sql = "INSERT INTO tax_declare (user_id, tax_period,first_time,time_update, total,create_date) VALUES (?,?,?,?,?,?)";
            pr = con.prepareStatement(sql);
            pr.setInt(1, declare.getUser().getId());
            pr.setString(2, declare.getTaxPeriod());
            pr.setBoolean(3, declare.isFirstTime());
            pr.setString(4,declare.getTime_update());
            pr.setFloat(5, declare.getTotal());
            pr.setTimestamp(6, declare.getCreateDate());
            status = pr.executeUpdate();       
            return status;
        } catch (SQLException ex) {
            Logger.getLogger(TaxDeclareDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
}
