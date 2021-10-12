/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duy Hiep
 */

//class to connect to database
public class DBContext {
    protected Connection connection;
    public DBContext(){
        //tien hanh ket noi  
        try {
            String user = "duyhiep";
            String password = "12345";
            String url = "jdbc:sqlserver://DESKTOP-VPGGRSG\\SQLEXPRESS:1433;databaseName=JDBCTest";
            
            //First load microsoft jdbc driver from library
            //register this driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            //Second
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            //occur when we forget to add jdbc driver
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
