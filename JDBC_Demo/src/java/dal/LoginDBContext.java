/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Feature;

/**
 *
 * @author Duy Hiep
 */
public class LoginDBContext extends DBContext{
    public Account getAcount(String username,String password){
        try {
            String sql = "Select a.username,a.password,a.displayname,f.fid,f.furl from Account a \n" +
                "left join GroupAccount ga on a.username = ga.username\n" +
                "left join [Group] g on ga.grid = g.grid\n" +
                "left join GroupFeature gf on gf.grid = g.grid\n" +
                "left join Feature f on gf.fid = f.fid\n" +
                "where a.username = ? and a.password = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            Account  account = null;
            while(rs.next()){
                if (account == null) {
                    account = new Account();
                    account.setUsername(rs.getString("username"));
                    account.setPassword(rs.getString("password"));
                    account.setDisplayName(rs.getString("displayname"));
                }
                int fid = rs.getInt("fid");
                if(fid != 0){
                    Feature f = new Feature();
                    f.setFid(fid);
                    f.setUrl(rs.getString("furl"));
                    account.getFeature().add(f);
                }   
            }
            
            return account;
           
        } catch (SQLException ex) {
            Logger.getLogger(LoginDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void insert(int totalusers){
        try {
            String sql = "Insert into CountTotalLogin([count])"
                    + "values(?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, totalusers);
            stm.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(LoginDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}