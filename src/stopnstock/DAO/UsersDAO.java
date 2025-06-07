/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stopnstock.DAO;

import stopnstock.DbConnInterface;
import stopnstock.model.UsersModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 /*
 * @author Vnihe
 */
public class UsersDAO implements DbConnInterface{
    
    Connection conn;
    
    @Override
    public void getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usr, pass);
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
        }
    }
    
    //create user
    public String addUser(UsersModel user){
        try{
            getConnection();
            String query = "INSERT INTO users(fname, lname, role, bday, phone, address, email, password, hiredate) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setString(1, user.getFname());
            pst.setString(2, user.getLname());
            pst.setString(3, user.getRole());
            pst.setDate(4, user.getbDay());
            pst.setString(5, user.getPhone());
            pst.setString(6, user.getAddress());
            pst.setString(7, user.getEmail());
            pst.setString(8, user.getPassword());
            pst.setDate(9, user.getHireDate());
            
            int rowsUpdated = pst.executeUpdate();
            System.out.println(rowsUpdated+" record added");
            return (rowsUpdated+" record added");
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return "ERROR"+e;
        }
    }
    
    //read all users
    public List<UsersModel> getAllUsers(){
        List<UsersModel> users = new ArrayList<>();
        
        try{
            getConnection();
            String query = "SELECT * FROM users";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                UsersModel user = new UsersModel(
                        rs.getInt("uid"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("role"),
                        rs.getDate("bday"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getDate("hiredate"),
                        rs.getBoolean("isactive"),
                        rs.getTimestamp("createdat")
                );
                users.add(user);
            }
            for(UsersModel um :users){
                System.out.println(um);
            }
            return users;
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return null;
        }
    }
    
    //read user by id
    public UsersModel getUserById(int uid){
        try{
            getConnection();
            String query = "SELECT * FROM users WHERE uid = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, uid);
            ResultSet rs = pst.executeQuery();
            
            
            if(rs.next()){
                UsersModel user = new UsersModel(
                        rs.getInt("uid"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("role"),
                        rs.getDate("bday"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getDate("hiredate"),
                        rs.getBoolean("isactive"),
                        rs.getTimestamp("createdat")
                );
                return user;
            }
            else{
                System.out.println("ERROR: IF failed");
                return null;
            }
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return null;
        }
    }
    
    //update user
    public String updateUser(UsersModel user){
        try{
            getConnection();
            String query = "UPDATE users SET fname = ?, lname = ?, role = ?, bday = ?, phone = ?, address = ?, email = ?, password = ?, hiredate = ?, isactive = ?, createdat = ? WHERE uid = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setString(1, user.getFname());
            pst.setString(2, user.getLname());
            pst.setString(3, user.getRole());
            pst.setDate(4, user.getbDay());
            pst.setString(5, user.getPhone());
            pst.setString(6, user.getAddress());
            pst.setString(7, user.getEmail());
            pst.setString(8, user.getPassword());
            pst.setDate(9, user.getHireDate());
            pst.setBoolean(10, user.isIsActive());
            pst.setTimestamp(11, user.getCreatedAt());
            pst.setInt(12, user.getUid());
            
            int rowsUpdated = pst.executeUpdate();
            System.out.println(rowsUpdated+" record updated");
            return (rowsUpdated+" record added");
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return "ERROR"+e;
        }
    }
    
    //delete user
    public String deleteUser(int uid){
        try{
            getConnection();
            String query = "DELETE FROM users WHERE uid = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, uid);
            int rowsUpdated = pst.executeUpdate();
            System.out.println(rowsUpdated+" record deleted");
            return (rowsUpdated+" record deleted");
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return "ERROR"+e;
        }
    }
}
