/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stopnstock.DAO;

import stopnstock.DbConnInterface;
import stopnstock.model.ProductsModel;

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
public class ProductDAO implements DbConnInterface{
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
    
    //add product
    public String addProduct(ProductsModel p){
        try{
            getConnection();
            String query = "INSERT INTO products(pname, description, price, cost_price, cid) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setString(1, p.getPname());
            pst.setString(2, p.getDescription());
            pst.setDouble(3, p.getPrice());
            pst.setDouble(4, p.getCostPrice());
            pst.setInt(5, p.getCid());
            
            
            int rowsEffected = pst.executeUpdate();
            System.out.println(rowsEffected+" record added");
            return (rowsEffected+" record added");
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return ("ERROR: "+e);
        }
    }
    
    //read all products
    public List<ProductsModel> getAllProducts(){
        List<ProductsModel> products = new ArrayList<>();
        try{
            getConnection();
            String query = "SELECT * FROM products";
            PreparedStatement pst = conn.prepareStatement(query);
            
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                ProductsModel p = new ProductsModel(
                        rs.getInt("pid"),
                        rs.getString("pname"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getDouble("cost_price"),
                        rs.getInt("stock_qty"),
                        rs.getInt("cid")
                );
                products.add(p);
            }
            
            for(ProductsModel p:products){
                System.out.println(p.getPid());
                System.out.println(p.getPname());
                System.out.println(p.getDescription());
                System.out.println(p.getPrice());
                System.out.println(p.getCostPrice());
                System.out.println(p.getStockQty());
                System.out.println(p.getCid());
            }
            return products;
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return null;
        }
    }
    
    //read product by id
    public ProductsModel getProductById(int pid){
        try{
            getConnection();
            String query = "SELECT * FROM products WHERE pid = ?";
            PreparedStatement pst = conn.prepareCall(query);
            pst.setInt(1, pid);
            ResultSet rs =  pst.executeQuery();
            
            if(rs.next()){
                ProductsModel p = new ProductsModel(
                        rs.getInt("pid"),
                        rs.getString("pname"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getDouble("cost_price"),
                        rs.getInt("stock_qty"),
                        rs.getInt("cid")
                );
                
                return p;
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
    
    //update product
    public String updateProduct(ProductsModel p){
        try{
            getConnection();
            String query = "UPDATE products SET pname = ?, description = ?, price = ?, cost_price = ?, stock_qty = ?, cid = ? WHERE pid = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, p.getPname());
            pst.setString(2, p.getDescription());
            pst.setDouble(3, p.getPrice());
            pst.setDouble(4, p.getCostPrice());
            pst.setInt(5, p.getStockQty());
            pst.setInt(6, p.getCid());
            pst.setInt(7, p.getPid());
            
            int rowsEffected = pst.executeUpdate();
            System.out.println(rowsEffected+" record updated");
            return (rowsEffected+" record updated");
            
        }
        catch(Exception e){
            System.out.println("ERROR: "+e);
            return ("ERROR: "+e);
        }
    }
    
    //delete product
    public String deleteProduct(int pid){
        try{
            getConnection();
            String query = "DELETE FROM products WHERE pid = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, pid);
            
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
