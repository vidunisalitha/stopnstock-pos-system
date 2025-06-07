/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stopnstock.model;

import java.sql.Timestamp;
/**
 *
 * @author Vnihe
 */
public class SalesModel {
    private int sid;
    private double total;
    private String payMethod;
    private Timestamp saleTime;
    private int uid;

    public SalesModel() {
    }

    public SalesModel(double total, String payMethod, int uid) {
        this.total = total;
        this.payMethod = payMethod;
        this.uid = uid;
    }
    
    public SalesModel(int sid, double total, String payMethod, Timestamp saleTime, int uid) {
        this.sid = sid;
        this.total = total;
        this.payMethod = payMethod;
        this.saleTime = saleTime;
        this.uid = uid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public Timestamp getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Timestamp saleTime) {
        this.saleTime = saleTime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    
    
}
