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
public class InventoryLogsModel {
    private int lid;
    private int pid;
    private String changeType;
    private int qty;
    private String note;
    private Timestamp changedAt;

    public InventoryLogsModel() {
    }

    public InventoryLogsModel(int pid, String changeType, int qty, String note) {
        this.pid = pid;
        this.changeType = changeType;
        this.qty = qty;
        this.note = note;
    }

    
    public InventoryLogsModel(int lid, int pid, String changeType, int qty, String note, Timestamp changedAt) {
        this.lid = lid;
        this.pid = pid;
        this.changeType = changeType;
        this.qty = qty;
        this.note = note;
        this.changedAt = changedAt;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Timestamp getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(Timestamp changedAt) {
        this.changedAt = changedAt;
    }
    
    
}
