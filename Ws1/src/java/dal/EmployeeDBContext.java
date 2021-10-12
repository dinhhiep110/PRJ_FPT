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
import model.Employee;

/**
 *
 * @author Duy Hiep
 */
public class EmployeeDBContext extends DBContext{
    public ArrayList<Employee> getEmployee(){
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            String sql = "Select * from Employee";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setDob(rs.getDate("dob"));
                e.setGender(rs.getBoolean("gender"));
                e.setDid(rs.getString("did"));
                employees.add(e);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return employees;
        
    }
}
