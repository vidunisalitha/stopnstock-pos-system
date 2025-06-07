/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stopnstock.DAO;

import stopnstock.DbConnInterface;
import stopnstock.model.InventoryLogsModel;

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
public class InventoryLogsDAO implements DbConnInterface{
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
    
    //add log
    public String addLog(InventoryLogsModel il){
        try{
            getConnection();
            String query = "INSERT INTO inventorylogs(pid, change_type, qty, note) VALUES(?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setInt(1, il.getPid());
            pst.setString(2, il.getChangeType());
            pst.setInt(3, il.getQty());
            pst.setString(4, il.getNote());
            
            
            int rowsEffected = pst.executeUpdate();
            System.out.println(rowsEffected+" record added");
            return (rowsEffected+" record added");
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return ("ERROR: "+e);
        }
    }
    
    //read all logs
    public List<InventoryLogsModel> getAllLogs(){
        List<InventoryLogsModel> logs = new ArrayList<>();
        try{
            getConnection();
            String query = "SELECT * FROM inventorylogs";
            PreparedStatement pst = conn.prepareStatement(query);
            
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                InventoryLogsModel il = new InventoryLogsModel(
                        rs.getInt("lid"),
                        rs.getInt("pid"),
                        rs.getString("change_type"),
                        rs.getInt("qty"),
                        rs.getString("note"),
                        rs.getTimestamp("changedat")
                );
                logs.add(il);
            }
            
            for(InventoryLogsModel il:logs){
                System.out.println(il.getLid());
                System.out.println(il.getPid());
                System.out.println(il.getChangeType());
                System.out.println(il.getQty());
                System.out.println(il.getNote());
                System.out.println(il.getChangedAt());
            }
            return logs;
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return null;
        }
    }
    
    //read log by id
    public InventoryLogsModel getLogById(int lid){
        try{
            getConnection();
            String query = "SELECT * FROM inventorylogs WHERE lid = ?";
            PreparedStatement pst = conn.prepareCall(query);
            pst.setInt(1, lid);
            ResultSet rs =  pst.executeQuery();
            
            if(rs.next()){
                InventoryLogsModel il = new InventoryLogsModel(
                        rs.getInt("lid"),
                        rs.getInt("pid"),
                        rs.getString("change_type"),
                        rs.getInt("qty"),
                        rs.getString("note"),
                        rs.getTimestamp("changedat")
                );
                
                return il;
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
    
    //update log
    public String updateLog(InventoryLogsModel il){
        try{
            getConnection();
            String query = "UPDATE inventorylogs SET pid = ?, change_type = ?, qty = ?, note = ?, changedat = ? WHERE lid = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, il.getPid());
            pst.setString(2, il.getChangeType());
            pst.setInt(3, il.getQty());
            pst.setString(4, il.getNote());
            pst.setTimestamp(5, il.getChangedAt());
            pst.setInt(6, il.getLid());
            
            int rowsEffected = pst.executeUpdate();
            System.out.println(rowsEffected+" record updated");
            return (rowsEffected+" record updated");
            
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return ("ERROR: "+e);
        }
    }
    
    //delete log
    public String deleteLog(int lid){
        try{
            getConnection();
            String query = "DELETE FROM inventorylogs WHERE lid = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, lid);
            
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
