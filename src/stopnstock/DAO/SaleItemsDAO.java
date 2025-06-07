/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stopnstock.DAO;

import stopnstock.DbConnInterface;
import stopnstock.model.SaleItemsModel;

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
public class SaleItemsDAO implements DbConnInterface{
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
    
    //add sale item
    public String addItem(SaleItemsModel si){
        try{
            getConnection();
            String query = "INSERT INTO saleitems(sid, pid, qty, unit_price, subtotal) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setInt(1, si.getSid());
            pst.setInt(2, si.getPid());
            pst.setInt(3, si.getQty());
            pst.setDouble(4, si.getUnitPrice());
            pst.setDouble(5, si.getSubtotal());
            
            int rowsEffected = pst.executeUpdate();
            System.out.println(rowsEffected+" record added");
            return (rowsEffected+" record added");
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return ("ERROR: "+e);
        }
    }
    
    //read all sale items
    public List<SaleItemsModel> getAllItems(){
        List<SaleItemsModel> items = new ArrayList<>();
        try{
            getConnection();
            String query = "SELECT * FROM saleitems";
            PreparedStatement pst = conn.prepareStatement(query);
            
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                SaleItemsModel si = new SaleItemsModel(
                        rs.getInt("siid"),
                        rs.getInt("sid"),
                        rs.getInt("pid"),
                        rs.getInt("qty"),
                        rs.getDouble("unit_price"),
                        rs.getDouble("subtotal")
                        
                );
                items.add(si);
            }
            
            for(SaleItemsModel si:items){
                System.out.println(si.getSiid());
                System.out.println(si.getSid());
                System.out.println(si.getPid());
                System.out.println(si.getQty());
                System.out.println(si.getUnitPrice());
                System.out.println(si.getSubtotal());
            }
            return items;
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return null;
        }
    }
    
    //read item by id
    public SaleItemsModel getItemById(int siid){
        try{
            getConnection();
            String query = "SELECT * FROM saleitems WHERE siid = ?";
            PreparedStatement pst = conn.prepareCall(query);
            pst.setInt(1, siid);
            ResultSet rs =  pst.executeQuery();
            
            if(rs.next()){
                SaleItemsModel si = new SaleItemsModel(
                        rs.getInt("siid"),
                        rs.getInt("sid"),
                        rs.getInt("pid"),
                        rs.getInt("qty"),
                        rs.getDouble("unit_price"),
                        rs.getDouble("subtotal")
                        
                );
                return si;
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
    
    //update item
    public String updateItem(SaleItemsModel si){
        try{
            getConnection();
            String query = "UPDATE saleitems SET sid = ?, pid = ?, qty = ?, unit_price = ?, subtotal = ? WHERE siid = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, si.getSid());
            pst.setInt(2, si.getPid());
            pst.setInt(3, si.getQty());
            pst.setDouble(4, si.getUnitPrice());
            pst.setDouble(5, si.getSubtotal());
            pst.setInt(6, si.getSiid());
            
            int rowsEffected = pst.executeUpdate();
            System.out.println(rowsEffected+" record updated");
            return (rowsEffected+" record updated");
            
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return ("ERROR: "+e);
        }
    }
    
    //delete item
    public String deleteItem(int siid){
        try{
            getConnection();
            String query = "DELETE FROM saleitems WHERE siid = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, siid);
            
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
