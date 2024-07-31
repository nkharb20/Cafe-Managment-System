/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;
import com.mysql.cj.conf.PropertyKey;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author nikit
 */
public class UserDao {
    public static void save(User user){
        
        String query = "insert into user(name,email,mobile,address,password,securityquestion,answer,status)values('"+user.getName()+"','"+user.getEmail()+"','"+user.getMobile()+"','"+user.getAddrss()+"','"+user.getPassword()+"','"+user.getSecurityquestion()+"','"+user.getAnswer()+"','false')";
        System.out.println(query);
        DbOpertions.setDataOrDelete(query, "Registered Sucessfully wait for admin approbal");
        
    }
    
    public static  User login(String email, String password ){
        User user= null;
        try{
            ResultSet rs = DbOpertions.getData("select *from user where email ='"+email+"' and password ='"+password+"' ");
            while(rs.next()){
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            
        }
        
        return user;
    }
    
    public static User getSecurityQuestion(String email){
        User user = null;
        try{
            ResultSet rs = DbOpertions.getData("select *from user where email= '"+email+"'");
            while(rs.next()){
                user = new User();
                user.setSecurityquestion(rs.getString("securityquestion"));
                user.setAnswer(rs.getString("answer"));
            }
        }
    
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    
    public static void update(String email,String newPassword){
        String query = "update user set password = '"+newPassword+"' where email = '"+email+"'";
        DbOpertions.setDataOrDelete(query, "Password changed sucessfully");  
    }
    
    public static ArrayList<User> getALLRecords(String email){
        ArrayList<User> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOpertions.getData("select *from user where email like '%"+email+"%'");
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobile(rs.getString("mobile"));
                user.setAddrss(rs.getString("address"));
                user.setSecurityquestion(rs.getString("securityquestion"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);
            }
                
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return arrayList;
    }



    public static void changeStatus(String email, String status){
        String query = "update user set status = '"+status+"' where email = '"+email+"' ";
        DbOpertions.setDataOrDelete(query, "Status updated sucesfully");
        
    }
  
    public static void changePassword(String email, String oldPassword,String newPassword){
        try{
            ResultSet rs = DbOpertions.getData("select *from user where email = '"+email+"' and password = '"+oldPassword+"'");
            if(rs.next()){
                update(email,newPassword);
            }
            else
                JOptionPane.showMessageDialog(null, "Old password is wrong");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void changeSecurityQuestion(String email, String password,String securityQuestion,String answer){
        try{
            ResultSet rs = DbOpertions.getData("select *from user where email = '"+email+"' and password = '"+password+"'");
            if(rs.next()){
                update(email, securityQuestion, answer);
            }
            else
                JOptionPane.showMessageDialog(null, "Password is wrong");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void update(String email, String securityQuestion,String answer){
        
        String query = "update user set securityQuestion = '"+securityQuestion+"', answer = '"+answer+"'where email = '"+email+"'";
        DbOpertions.setDataOrDelete(query, "Security Question changes sucessfully.");
    }
    

}
