/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.UserRequest;

/**
 *
 * @author Duy Hiep
 */
public class UserRequestDBContext extends DBContext {
    public ArrayList<UserRequest> getUserRequest(){
       ArrayList<UserRequest> list = new ArrayList<>();
        try {
            String sql = "SELECT [requestid]\n" +
                    "      ,[reason]\n" +
                    "      ,[requestDate]\n" +
                    "      ,[username]\n" +
                    "  FROM [UserRequest]";
            PreparedStatement stm = connection.prepareStatement(sql);
           ResultSet rs = stm.executeQuery();
           while(rs.next()){
               UserRequest ur = new UserRequest();
               ur.setId(rs.getInt("requestid"));
               ur.setReason(rs.getString("reason"));
               ur.setRequestDate(rs.getDate("requestDate"));
               Account account = new Account();
               account.setUsername(rs.getString("username"));
               ur.setAccount(account);
               list.add(ur);
           }
        } catch (SQLException ex) {
            Logger.getLogger(UserRequestDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    
}
