package com.pdb_db.pdb_proj.domainMongo.wishlist_kostymMongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class WishlistKostymM {

    @Id
    private Integer id;
    private String nazov;
    private Integer uzivid;

    private Integer kostymid;

    public WishlistKostymM(){}
    public WishlistKostymM(Integer id){
        this.id = id;
    }
    public WishlistKostymM(Integer id, String nazov, Integer uzivid, Integer kostymid){
        this.id = id;
        this.nazov = nazov;
        this.uzivid = uzivid;
        this.kostymid = kostymid;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }



    public Integer getUzivid() {
        return uzivid;
    }

    public void setUzivid(Integer uzivid) {
        this.uzivid = uzivid;
    }


    public Integer getKostymid() {
        return kostymid;
    }


    public void setKostymid(Integer kostymid)
    {
        this.kostymid=kostymid;
    }

}
