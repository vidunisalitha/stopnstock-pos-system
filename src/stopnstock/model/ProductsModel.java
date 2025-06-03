/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stopnstock.model;

/**
 *
 * @author Vnihe
 */
public class ProductsModel {
    private int pid;
    private String pname;
    private String description;
    private double price;
    private double costPrice;
    private int stockQty;
    private int cid;

    public ProductsModel() {
    }

    public ProductsModel(int pid, String pname, String description, double price, double costPrice, int stockQty, int cid) {
        this.pid = pid;
        this.pname = pname;
        this.description = description;
        this.price = price;
        this.costPrice = costPrice;
        this.stockQty = stockQty;
        this.cid = cid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
    
    
}
