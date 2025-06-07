/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stopnstock.DAO;

import stopnstock.DbConnInterface;
import stopnstock.model.ProductCatergoriesModel;

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
public class ProductCategoriesDAO implements DbConnInterface{
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
    
    //add product category
    public String addCategory(ProductCatergoriesModel pc){
        try{
            getConnection();
            String query = "INSERT INTO productcategories(cname) VALUES(?)";
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setString(1, pc.getCname());
            
            int rowsEffected = pst.executeUpdate();
            System.out.println(rowsEffected+" record added");
            return (rowsEffected+" record added");
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return ("ERROR: "+e);
        }
    }
    
    //read all categories
    public List<ProductCatergoriesModel> getAllCategories(){
        List<ProductCatergoriesModel> categories = new ArrayList<>();
        try{
            getConnection();
            String query = "SELECT * FROM productcategories";
            PreparedStatement pst = conn.prepareStatement(query);
            
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                ProductCatergoriesModel pc = new ProductCatergoriesModel(
                        rs.getInt("cid"),
                        rs.getString("cname")
                );
                categories.add(pc);
            }
            
            for(ProductCatergoriesModel pc:categories){
                System.out.println(pc.getCid());
                System.out.println(pc.getCname());
            }
            return categories;
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return null;
        }
    }
    
    //read category by id
    public ProductCatergoriesModel getCategoryById(int cid){
        try{
            getConnection();
            String query = "SELECT * FROM productcategories WHERE cid = ?";
            PreparedStatement pst = conn.prepareCall(query);
            pst.setInt(1, cid);
            ResultSet rs =  pst.executeQuery();
            
            if(rs.next()){
                ProductCatergoriesModel pc = new ProductCatergoriesModel(
                        rs.getInt("cid"),
                        rs.getString("cname")
                );
                
                return pc;
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
    
    //update category
    public String updateCategory(ProductCatergoriesModel pc){
        try{
            getConnection();
            String query = "UPDATE productcategories SET cname = ? WHERE cid = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, pc.getCname());
            pst.setInt(2, pc.getCid());
            
            int rowsEffected = pst.executeUpdate();
            System.out.println(rowsEffected+" record updated");
            return (rowsEffected+" record updated");
            
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return ("ERROR: "+e);
        }
    }
    
    //delete category
    public String deleteCategory(int cid){
        try{
            getConnection();
            String query = "DELETE FROM productcategories WHERE cid = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, cid);
            
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
