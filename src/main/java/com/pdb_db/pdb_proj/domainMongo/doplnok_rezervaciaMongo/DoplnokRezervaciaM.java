package com.pdb_db.pdb_proj.domainMongo.doplnok_rezervaciaMongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class DoplnokRezervaciaM {

    @Id
    private Integer id;
    private Integer uzivid;
    private Integer doplnokid;


    private java.util.Date casPozicania;
    private java.util.Date casVratenia;
    private Integer vratenie;

    public DoplnokRezervaciaM(){}
    public DoplnokRezervaciaM(Integer id){
        this.id = id;
    }


    public DoplnokRezervaciaM(Integer id,
                             Integer uzivid,
                             Integer doplnokid,
                             java.util.Date casPozicania,
                             java.util.Date casVratenia,
                             Integer vratenie)
    {
        this.id = id;
        this.uzivid = uzivid;
        this.doplnokid = doplnokid;
        this.casPozicania=casPozicania;
        this.casVratenia=casVratenia;
        this.vratenie=vratenie;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setDoplnokid(Integer doplnokid) {
        this.doplnokid = doplnokid;
    }


    public String toString()
    {
        return "DoplnokRezervacia{" +
                "id=" + id+
                "uzivid=" + uzivid+ '\'' +
                "doplnokid=" + doplnokid +'}';
    }


    public java.util.Date getCasPozicania() {
        return casPozicania;
    }

    public void setCasPozicania(java.util.Date casPozicania) {
        this.casPozicania = casPozicania;
    }



    public java.util.Date getCasVratenia() {
        return casVratenia;
    }

    public void setCasVratenia(java.util.Date casVratenia) {
        this.casVratenia = casVratenia;
    }



    public Integer getVratenie() {
        return vratenie;
    }

    public void setVratenie(Integer vratenie) {
        this.vratenie = vratenie;
    }

}
