/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stopnstock.model;

/**
 *
 * @author Vnihe
 */
public class ProductCatergoriesModel {
    private int cid;
    private String cname;

    public ProductCatergoriesModel() {
    }

    public ProductCatergoriesModel(String cname) {
        this.cname = cname;
    }
    
    public ProductCatergoriesModel(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
    
    
}
