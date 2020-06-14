/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextTaxDeclareUtil;

import controller.DAO;
import controller.TaxDeclareDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TaxDeclare;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BVCN 88
 */
public class TaxDeclareJUnitTest {
    
    DAO dao = new DAO();
    Connection con = dao.getInstance();
    PreparedStatement pr ;
    int status = -1;
    
    public TaxDeclareJUnitTest() {
    }
    
    @Test
    public void TestAddTaxDeclare (){
       
        try {
            
            int userID = 1;
            String taxPeriod = "Quý 1- 2020";
            boolean isFirsttime = true;
            String timeUpdate = null;
            float total = 10000;
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            con.setAutoCommit(false);
            String sql = "INSERT INTO tax_declare (user_id, tax_period,first_time,time_update, total,create_date) VALUES (?,?,?,?,?,?)";
            pr = con.prepareStatement(sql);
            pr.setInt(1,userID);
            pr.setString(2, taxPeriod);
            pr.setBoolean(3, isFirsttime);
            pr.setString(4,timeUpdate);
            pr.setFloat(5, total);
            pr.setTimestamp(6, timestamp);
            status = pr.executeUpdate();
            con.rollback();
     
        } catch (SQLException ex) {
            Logger.getLogger(TaxDeclareDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(1, status);
    }
    
}
