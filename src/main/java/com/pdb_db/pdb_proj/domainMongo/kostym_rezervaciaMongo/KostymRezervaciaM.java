package com.pdb_db.pdb_proj.domainMongo.kostym_rezervaciaMongo;

import com.pdb_db.pdb_proj.utilities.rest_operationType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class KostymRezervaciaM {

    @Id
    private Integer id;
    private Integer uzivid;
    private Integer kostymid;

    private java.util.Date casPozicania;
    private java.util.Date casVratenia;
    private Integer vratenie;
    public KostymRezervaciaM(){}
    public KostymRezervaciaM(Integer id){
        this.id = id;
    }


    public KostymRezervaciaM(Integer id,
                             Integer uzivid,
                             Integer kostymid,
                             java.util.Date casPozicania,
                             java.util.Date casVratenia,
                             Integer vratenie)
    {
        this.id = id;
        this.uzivid = uzivid;
        this.kostymid = kostymid;
        this.casPozicania = casPozicania;
        this.casVratenia = casVratenia;
        this.vratenie = vratenie;
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



    public Integer getKostymid() {
        return kostymid;
    }

    public void setKostymid(Integer kostymid) {
        this.kostymid = kostymid;
    }


    public String toString()
    {
        return "DoplnokRezervacia{" +
                "id=" + id+
                "uzivid=" + uzivid+ '\'' +
                "kostymid=" + kostymid +'}';
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


