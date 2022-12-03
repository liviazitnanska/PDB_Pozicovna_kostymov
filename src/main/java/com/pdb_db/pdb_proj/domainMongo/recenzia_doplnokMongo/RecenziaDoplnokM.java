package com.pdb_db.pdb_proj.domainMongo.recenzia_doplnokMongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.criteria.CriteriaBuilder;

@Data
@Document
public class RecenziaDoplnokM
{
    @Id
    private Integer id;
    private String nazov;
    private String popis;
    private Integer suhlas;
    private Integer nesuhlas;
    private Integer uzivid;
    private Integer doplnokid;

    public RecenziaDoplnokM(){};
    public RecenziaDoplnokM(Integer id){
        this.id = id;
    };

    public RecenziaDoplnokM(Integer id, String nazov, String popis, Integer suhlas, Integer nesuhlas, Integer uzivid,
                            Integer doplnokid) {
        this.id = id;
        this.nazov = nazov;
        this.popis = popis;
        this.suhlas = suhlas;
        this.nesuhlas = nesuhlas;
        this.uzivid = uzivid;
        this.doplnokid = doplnokid;
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

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public Integer getSuhlas() {
        return suhlas;
    }

    public void setSuhlas(Integer suhlas) {
        this.suhlas = suhlas;
    }

    public Integer getNesuhlas() {
        return nesuhlas;
    }

    public void setNesuhlas(Integer nesuhlas) {
        this.nesuhlas = nesuhlas;
    }


    public Integer getDoplnokid() {
        return doplnokid;
    }

    public void setDoplnokid(Integer doplnokid) {
        this.doplnokid = doplnokid;
    }

}
