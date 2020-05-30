/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author 98ngu
 */

import controller.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.User;
import model.TaxCode;
import java.sql.Connection;

public class UserDAO {
    Connection con;
    controller.DAO dao;
    PreparedStatement pr;
    public UserDAO() {
         dao = new controller.DAO();
        con = dao.getInstance();
    }
    
public int addUser(User user,TaxCode tax){
      
        String sql2 ="INSERT INTO `user`( `tax_code`, `user_type`, `active`)"
                + "VALUES(?,?,?)";
        int returnValue2 = 0;
        try{
            PreparedStatement ps = con.prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, Integer.toString(tax.getTaxcode()));
            ps.setString(2, user.getType());
            ps.setBoolean(3, user.isActive());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                returnValue2 = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue2;
                   
        }


    }