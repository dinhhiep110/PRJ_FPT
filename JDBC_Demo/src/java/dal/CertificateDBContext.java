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
import model.Certificate;

/**
 *
 * @author Duy Hiep
 */
public class CertificateDBContext extends DBContext{
    public ArrayList<Certificate> getCertificate(){
        ArrayList<Certificate> cert = new ArrayList<>();
        try {
            String sql = "SELECT [cid]\n" +
                    "      ,[name]\n" +
                    "  FROM [Certificate]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Certificate c = new Certificate();
                c.setCid(rs.getInt("cid"));
                c.setName(rs.getString("name"));
                cert.add(c);      
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CertificateDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cert;
    }
}
