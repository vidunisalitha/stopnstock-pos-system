/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stopnstock.model;

import java.sql.Date;
import java.sql.Timestamp;
/**
 *
 * @author Vnihe
 */
public class UsersModel {
    private int uid;
    private String fname;
    private String lname;
    private String role;
    private Date bDay;
    private String phone;
    private String address;
    private String email;
    private String password;
    private Date hireDate;
    private boolean isActive;
    private Timestamp createdAt;

    public UsersModel() {
    }

    public UsersModel(String fname, String lname, String role, Date bDay, String phone, String address, String email, String password, Date hireDate) {
        this.fname = fname;
        this.lname = lname;
        this.role = role;
        this.bDay = bDay;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.password = password;
        this.hireDate = hireDate;
    }

    public UsersModel(int uid, String fname, String lname, String role, Date bDay, String phone, String address, String email, String password, Date hireDate, boolean isActive, Timestamp createdAt) {
        this.uid = uid;
        this.fname = fname;
        this.lname = lname;
        this.role = role;
        this.bDay = bDay;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.password = password;
        this.hireDate = hireDate;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }
    
    

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getbDay() {
        return bDay;
    }

    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    
    
}
