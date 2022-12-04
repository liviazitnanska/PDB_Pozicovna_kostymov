package com.pdb_db.pdb_proj.domainMongo.wishlist_doplnokMongo;

import org.springframework.data.annotation.Id;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class WishlistDoplnokM {
    @Id
    private Integer id;
    private String nazov;
    private Integer uzivid;
    private Integer doplnokid;

    public WishlistDoplnokM(){}
    public WishlistDoplnokM(Integer id){
        this.id = id;
    }
    public WishlistDoplnokM(Integer id, String nazov, Integer uzivid, Integer doplnokid){
        this.id = id;
        this.nazov = nazov;
        this.uzivid = uzivid;
        this.doplnokid = doplnokid;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id)
    {
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



    public Integer getDoplnokid() {
        return doplnokid;
    }


    public void setDoplnokmid(Integer kostymid)
    {
        this.doplnokid = doplnokid;
    }

}
