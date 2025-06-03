/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stopnstock.model;

/**
 *
 * @author Vnihe
 */
public class SaleItemsModel {
    private int siid;
    private int sid;
    private int pid;
    private int qty;
    private double unitPrice;
    private double subtotal;

    public SaleItemsModel() {
    }

    public SaleItemsModel(int siid, int sid, int pid, int qty, double unitPrice, double subtotal) {
        this.siid = siid;
        this.sid = sid;
        this.pid = pid;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    public int getSiid() {
        return siid;
    }

    public void setSiid(int siid) {
        this.siid = siid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
