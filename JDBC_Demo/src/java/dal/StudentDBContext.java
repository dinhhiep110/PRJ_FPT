/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Certificate;
import model.Department;
import model.Student;
import model.StudentCertificate;

/**
 *
 * @author 84344
 */
public class StudentDBContext extends DBContext {
    public ArrayList<Student> getStudents()
    {
        
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT id,name,dob,gender,Department.did,dname FROM Student"
                    + " INNER JOIN Department\n" +
                    "ON Student.did = Department.did";
            
            //day cau lenh va thuc  thi cau lenh
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            //output tra ve
            while(rs.next())
            {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));
                Department d = new Department();
                d.setDid(rs.getInt("did"));
                d.setDname(rs.getString("dname"));
                s.setDepartment(d);
                students.add(s);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    
    public void insert(Student s)
    {
        try {
            //set the transaction for not only one commit to commit many query
            connection.setAutoCommit(false);
            String sql = "INSERT INTO [Student]\n" +
                    "           ([name]\n" +
                    "           ,[gender]\n" +
                    "           ,[dob]\n" +
                    "           ,[did])\n" +
                    "     VALUES\n" +
                    "           (?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, s.getName());
            stm.setBoolean(2, s.isGender());
            stm.setDate(3, s.getDob());
            stm.setInt(4, s.getDepartment().getDid());
            stm.executeUpdate();
            
            //get the id of students that is newest
            String sql_get_id = "Select @@IDENTITY as sid"; // @@IDENTITY is a system function that returns the last-inserted identity value.
            PreparedStatement stm_get_id = connection.prepareStatement(sql_get_id);
            ResultSet rs = stm_get_id.executeQuery();
            if (rs.next()) {
                s.setId(rs.getInt("sid"));
            }
            
            //insert into StudentCertificate
            for (StudentCertificate cert : s.getCerts()) {
                String sql_sc = "INSERT INTO [StudentCertificate]\n" +
                                        "           ([cid]\n" +
                                        "           ,[sid])\n" +
                                        "     VALUES\n" +
                                        "           (?\n" +
                                        "           ,?)";
                PreparedStatement stm_sc = connection.prepareStatement(sql_sc);
                stm_sc.setInt(2, s.getId());
                stm_sc.setInt(1, cert.getCertificate().getCid());
                stm_sc.executeUpdate();
            }
            
            //commit all the query that has previously done
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        //set again the autocomit
        finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Student getDetailStudent(int id) {
         try {
            String sql = "SELECT id,name,dob,gender,Department.did,dname FROM Student"
                    + " INNER JOIN Department\n" +
                    "ON Student.did = Department.did where id = ?";
            
            //day cau lenh va thuc  thi cau lenh
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            
            //output tra ve
            if(rs.next())
            {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));
                Department d = new Department();
                d.setDid(rs.getInt("did"));
                d.setDname(rs.getString("dname"));
                s.setDepartment(d);
                return s;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Integer> getIdStudentCertificate(int id){
        ArrayList<Integer> list_id = new ArrayList<>();
        try {
            String sql = "SELECT [cid]\n"+
                    "  FROM [StudentCertificate] where sid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Certificate c = new Certificate();
                c.setCid(rs.getInt("cid"));
                list_id.add(c.getCid());
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_id;
    }
    
    //c1
    public ArrayList<Certificate> getStudentCertificate(int id){
        ArrayList<Certificate> studentCertificate = new ArrayList<>();
        try {
            String sql = "SELECT Certificate.cid,Certificate.name\n" +
                        "  FROM [StudentCertificate] inner join Certificate\n" +
                        "  on StudentCertificate.cid = Certificate.cid\n" +
                        "  where sid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Certificate c = new Certificate();
                c.setCid(rs.getInt("cid"));
                c.setName(rs.getString("name"));
                studentCertificate.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studentCertificate;
    }
    
    //c2
    public Student getDetailAboutStudent(int id) {
         try {
            String sql = "SELECT s.id,s.name,s.dob,s.gender,d.did,d.dname,c.cid,c.name as cname FROM Student s\n" +
                        " INNER JOIN Department d\n" +
                        "ON s.did = d.did\n" +
                        "left join StudentCertificate sc on sc.sid = s.id\n" +
                        "left join Certificate c on sc.cid = c.cid\n" +
                        "where s.id = ?";
            
            //day cau lenh va thuc  thi cau lenh
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            Student s = null;
            //output tra ve
            while(rs.next())
            {
                if(s == null){
                    s = new Student();
                    s.setId(rs.getInt("id"));
                    s.setName(rs.getString("name"));
                    s.setDob(rs.getDate("dob"));
                    s.setGender(rs.getBoolean("gender"));
                    Department d = new Department();
                    d.setDid(rs.getInt("did"));
                    d.setDname(rs.getString("dname"));
                    s.setDepartment(d);
                }
                int cid = rs.getInt("cid");
                if (cid != 0) {
                    Certificate c = new Certificate();
                    c.setCid(cid);
                    c.setName(rs.getString("cname"));
                    StudentCertificate sc = new StudentCertificate();
                    sc.setStudent(s);
                    sc.setCertificate(c);
                    s.getCerts().add(sc);
                }
            }
            return s;
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
     
     public ArrayList<Integer> getIDStudent(){
        ArrayList<Integer> listID = new ArrayList<>();        
        try {
            String sql = "Select id from Student";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                listID.add(rs.getInt("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listID;
     }
    
    
    
    
    public void update(Student s){
        try {
            connection.setAutoCommit(false);
            String sql = "UPDATE [Student]\n" +
                        "   SET [name] = ?\n" +
                        "      ,[dob] = ?\n" +
                        "      ,[gender] = ?\n" +
                        "      ,[did] = ?\n" +
                        " WHERE id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, s.getName());
            stm.setBoolean(3, s.isGender());
            stm.setDate(2, s.getDob());
            stm.setInt(4, s.getDepartment().getDid());
            stm.setInt(5, s.getId());
            stm.executeUpdate();
            
            deleteStudentCertificate(s.getId());
            for (StudentCertificate cert : s.getCerts()) {
                String sql_sc = "INSERT INTO [StudentCertificate]\n" +
                                        "           ([cid]\n" +
                                        "           ,[sid])\n" +
                                        "     VALUES\n" +
                                        "           (?\n" +
                                        "           ,?)";
                PreparedStatement stm_sc = connection.prepareStatement(sql_sc);
                stm_sc.setInt(2, s.getId());
                stm_sc.setInt(1, cert.getCertificate().getCid());
                stm_sc.executeUpdate();
            }
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void updateStudentCertificate(int sid,int cid){
        try {
            String sql = "INSERT INTO [StudentCertificate]\n" +
                    "           ([cid]\n" +
                    "           ,[sid])\n" +
                    "     VALUES\n" +
                    "           (?\n" +
                    "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(2, sid);
            stm.setInt(1, cid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void deleteStudentCertificate(int id){
         try {
            String sql = "Delete from StudentCertificate where sid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Student> getSearchByDept(int did){
        ArrayList<Student> listStudent = new ArrayList<>();
        PreparedStatement stm;
        try {
            String sql;
            if(did != 0){
                sql = "SELECT s.id,s.name,s.dob,s.gender,d.did,d.dname,c.cid,c.name as cname FROM Student s\n" +
                        "INNER JOIN Department d\n" +
                        "ON s.did = d.did\n" +
                        "left join StudentCertificate sc on sc.sid = s.id\n" +
                        "left join Certificate c on sc.cid = c.cid\n" +
                        "where s.did = ?";
                stm = connection.prepareStatement(sql);
                stm.setInt(1, did);
            }
            else{
                sql = "SELECT s.id,s.name,s.dob,s.gender,d.did,d.dname,c.cid,c.name as cname FROM Student s\n" +
                        "INNER JOIN Department d\n" +
                        "ON s.did = d.did\n" +
                        "left join StudentCertificate sc on sc.sid = s.id\n" +
                        "left join Certificate c on sc.cid = c.cid";
                stm = connection.prepareStatement(sql);
            }
            ResultSet rs = stm.executeQuery();
            Student s = new Student();
            s.setId(-1);
            while (rs.next()) {                
                int sid = rs.getInt("id");
                if (s.getId() != sid) {
                    s = new Student();
                    s.setId(sid);
                    s.setName(rs.getString("name"));
                    s.setDob(rs.getDate("dob"));
                    s.setGender(rs.getBoolean("gender"));
                    Department d = new Department();
                    d.setDid(rs.getInt("did"));
                    d.setDname(rs.getString("dname"));
                    s.setDepartment(d);
                    listStudent.add(s);
                }
                int cid = rs.getInt("cid");
                if (cid != 0) {
                    StudentCertificate sc = new StudentCertificate();
                    Certificate c = new Certificate();
                    c.setCid(cid);
                    c.setName(rs.getString("cname"));
                    sc.setCertificate(c);
                    sc.setStudent(s);
                    s.getCerts().add(sc);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStudent; 
    }
    
    public void delete(int id){
        try {
            String sql = "Delete from Student where id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// id = -1,name = null or blank,from and to null, did =-1
    public ArrayList<Student> search(int id, String name,Boolean gender,Date from,Date to,int did){
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT id,name,dob,gender,Department.did,dname FROM Student\n" +
                    "                            INNER JOIN Department\n" +
                    "                            ON Student.did = Department.did\n" +
                    "                            where (1 = 1) ";
            int paramIndex = 0;
            HashMap<Integer,Object[]> params = new HashMap<>();
            if (id != -1) {
                sql += " AND id = ?";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Integer.class.getName();
                param[1] = id;
                params.put(paramIndex, param);
            }
            if (name != null) {
                sql += " AND name like '%' + ? + '%'";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = String.class.getName();
                param[1] = name;
                params.put(paramIndex, param);
            }
            if (gender != null) {
                sql += " AND gender = ?";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Boolean.class.getName();
                param[1] = gender;
                params.put(paramIndex, param);
            }
            if (from != null) {
                sql += " AND dob >= ?";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Date.class.getName();
                param[1] = from;
                params.put(paramIndex, param);
            }
            if (to != null) {
                sql += " AND dob <= ?";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Date.class.getName();
                param[1] = to;
                params.put(paramIndex, param);
                
            }
            if (did != -1) {
                sql += " AND Department.did = ?";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Integer.class.getName();
                param[1] = did;
                params.put(paramIndex, param);
            }
            
            PreparedStatement stm = connection.prepareStatement(sql);
            for (Map.Entry<Integer, Object[]> entry : params.entrySet()) {
                Integer index = entry.getKey();
                Object[] value = entry.getValue();
                String type = value[0].toString();
                if (type.equals(Integer.class.getName())) {
                    stm.setInt(index, (Integer) value[1]);
                }
                if (type.equals(String.class.getName())) {
                    stm.setString(index,  value[1].toString());
                }
                if (type.equals(Boolean.class.getName())) {
                    stm.setBoolean(index, (Boolean) value[1]);
                }
                if (type.equals(Date.class.getName())) {
                    stm.setDate(index, (Date) value[1]);
                }
            }
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));
                Department d = new Department();
                d.setDid(rs.getInt("did"));
                d.setDname(rs.getString("dname"));
                s.setDepartment(d);
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return students;
        
    }
    
    public ArrayList<Student> getSearchCertificate(String cids[]){
        ArrayList<Student> list = new ArrayList<>();
        try {
            String sql = "Select distinct s.id,s.name,s.dob,s.gender,d.did,d.dname,c.cid,c.name as cname from Student s \n" +
                        "left join Department d on s.did = d.did\n" +
                        "left join StudentCertificate sc on s.id = sc.sid\n" +
                        "left join Certificate c on sc.cid = c.cid\n";
            if(cids != null){
                sql += "Where c.cid = ? ";
                for (int i = 1;i < cids.length;i++) {
                    sql += "or c.cid = ? ";
                } 
            }
            sql += " order by s.name asc";
            PreparedStatement stm = connection.prepareStatement(sql);
            if(cids != null){
                int count = 0;
                while(count < cids.length){
                    stm.setInt(count + 1, Integer.parseInt(cids[count]));
                    count += 1;
                }
            } 
            ResultSet rs = stm.executeQuery();
            Student s = new Student();
            s.setId(-1);
            while (rs.next()) {                
                int sid = rs.getInt("id");
                if (s.getId() != sid) {
                    s = new Student();
                    s.setId(sid);
                    s.setName(rs.getString("name"));
                    s.setDob(rs.getDate("dob"));
                    s.setGender(rs.getBoolean("gender"));
                    Department d = new Department();
                    d.setDid(rs.getInt("did"));
                    d.setDname(rs.getString("dname"));
                    s.setDepartment(d);
                    list.add(s);
                }
                int cid = rs.getInt("cid");
                if (cid != 0) {
                    StudentCertificate sc = new StudentCertificate();
                    Certificate c = new Certificate();
                    c.setCid(cid);
                    c.setName(rs.getString("cname"));
                    sc.setCertificate(c);
                    sc.setStudent(s);
                    s.getCerts().add(sc);
                }
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}

