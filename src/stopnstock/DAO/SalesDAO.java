/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stopnstock.DAO;

import stopnstock.DbConnInterface;
import stopnstock.model.SalesModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Vnihe
 */
public class SalesDAO implements DbConnInterface{
    Connection conn;
    
    @Override
    public void getConnection(){
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usr, pass);
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
        }
    }
    
    //add sale
    public String addSale(SalesModel s){
        try{
            getConnection();
            String query = "INSERT INTO sales(total, paymethod, uid) VALUES(?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setDouble(1, s.getTotal());
            pst.setString(2, s.getPayMethod());
            pst.setInt(3, s.getUid());
            
            
            int rowsEffected = pst.executeUpdate();
            System.out.println(rowsEffected+" record added");
            return (rowsEffected+" record added");
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return ("ERROR: "+e);
        }
    }
    
    //read all sales
    public List<SalesModel> getAllSales(){
        List<SalesModel> sales = new ArrayList<>();
        try{
            getConnection();
            String query = "SELECT * FROM sales";
            PreparedStatement pst = conn.prepareStatement(query);
            
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                SalesModel s = new SalesModel(
                        rs.getInt("sid"),
                        rs.getDouble("total"),
                        rs.getString("paymethod"),
                        rs.getTimestamp("saletime"),
                        rs.getInt("uid")
                );
                sales.add(s);
            }
            
            for(SalesModel s:sales){
                System.out.println(s.getSid());
                System.out.println(s.getTotal());
                System.out.println(s.getPayMethod());
                System.out.println(s.getSaleTime());
                System.out.println(s.getUid());
            }
            return sales;
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return null;
        }
    }
    
    //read sale by id
    public SalesModel getSaleById(int sid){
        try{
            getConnection();
            String query = "SELECT * FROM sales WHERE sid = ?";
            PreparedStatement pst = conn.prepareCall(query);
            pst.setInt(1, sid);
            ResultSet rs =  pst.executeQuery();
            
            if(rs.next()){
                SalesModel s = new SalesModel(
                        rs.getInt("sid"),
                        rs.getDouble("total"),
                        rs.getString("paymethod"),
                        rs.getTimestamp("saletime"),
                        rs.getInt("uid")
                );
                
                return s;
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
    
    //update sale
    public String updateSale(SalesModel s){
        try{
            getConnection();
            String query = "UPDATE sales SET total = ?, paymethod = ?, saledate = ?, uid = ? WHERE sid = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setDouble(1, s.getTotal());
            pst.setString(2, s.getPayMethod());
            pst.setTimestamp(3, s.getSaleTime());
            pst.setInt(4, s.getUid());
            pst.setInt(5, s.getSid());
            
            int rowsEffected = pst.executeUpdate();
            System.out.println(rowsEffected+" record updated");
            return (rowsEffected+" record updated");
            
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return ("ERROR: "+e);
        }
    }
    
    //delete sale
    public String deleteSale(int sid){
        try{
            getConnection();
            String query = "DELETE FROM sales WHERE sid = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, sid);
            
            int rowsEffected = pst.executeUpdate();
            System.out.println(rowsEffected+" record deleted");
            return (rowsEffected+" record deleted");
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return ("ERROR: "+e);
        }
    }
}
