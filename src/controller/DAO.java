/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author BVCN 88
 */
public class DAO {
    private  Connection con;
    
    public  Connection getInstance(){
        String url="jdbc:mysql://localhost:3306/personal_income_tax?useUniCode=yes&characterEncoding=UTF-8";
        String driver="com.mysql.jdbc.Driver";
        try{
            Class.forName(driver);
            con=DriverManager.getConnection(url, "root", null);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
    
}
