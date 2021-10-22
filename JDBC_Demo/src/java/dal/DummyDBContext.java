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
import model.Dummy;

/**
 *
 * @author Duy Hiep
 */
public class DummyDBContext extends DBContext{
    public ArrayList<Dummy> getDumies(int pagesize,int pageindex){
        ArrayList<Dummy> dummies = new ArrayList<>();
        try {
            String sql = "SELECT id,name FROM \n" +
            "(SELECT ROW_NUMBER() OVER (ORDER BY id asc) as rownum, id,name\n" +
            "FROM DummyTable) t\n" +
            "WHERE \n" +
            "rownum >= (? - 1)*? + 1 AND rownum <= ? * ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Dummy d = new Dummy();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                dummies.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DummyDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dummies;
    }
    
    public int getRowCount(){
        try {
            String sql = "Select count(*) as Total from DummyTable";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                return rs.getInt("Total");
            }
            } catch (SQLException ex) {
            Logger.getLogger(DummyDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
            
}
