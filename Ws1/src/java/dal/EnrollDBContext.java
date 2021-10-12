/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Enrollment;

/**
 *
 * @author Duy Hiep
 */
public class EnrollDBContext extends DBContext {
    public int insert(Enrollment r){
        int row = 0;
        try {
            String sql = "INSERT INTO [Enrollment]\n" +
"           ([from]\n" +
"           ,[to]\n" +
"           ,[cid]\n" +
"           ,[eid]\n" +
"           ,[active]\n" +
"           ,[note])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, r.getFrom());
            stm.setDate(2, r.getTo());
            stm.setInt(3, r.getEid().getId());
            stm.setInt(4, r.getCid().getId());
            stm.setBoolean(5, r.isActive());
            if(r.getNote() == null){
                r.setNote("No note");
            }
            stm.setString(6, r.getNote());
            row = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EnrollDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return row;
    }
}
