package com.pdb_db.pdb_proj.domainMongo.rezervaciaMongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
public class RezervaciaM
{
    @Id
    private Integer id;
    private Date casPozicania;
    private Date casVratenia;
    private Integer vratenie;
    private List<Integer> kostymyID;
    private List<Integer> doplnkyID;

    public RezervaciaM(Date casPozicania, Date casVratenia, Integer vratenie, List<Integer> kostymyID, List<Integer> doplnkyID) {
        this.casPozicania = casPozicania;
        this.casVratenia = casVratenia;
        this.vratenie = vratenie;
        this.kostymyID = kostymyID;
        this.doplnkyID = doplnkyID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCasPozicania() {
        return casPozicania;
    }

    public void setCasPozicania(Date casPozicania) {
        this.casPozicania = casPozicania;
    }

    public Date getCasVratenia() {
        return casVratenia;
    }

    public void setCasVratenia(Date casVratenia) {
        this.casVratenia = casVratenia;
    }

    public Integer getVratenie() {
        return vratenie;
    }

    public void setVratenie(Integer vratenie) {
        this.vratenie = vratenie;
    }

    public List<Integer> getKostymyID() {
        return kostymyID;
    }

    public void setKostymyID(List<Integer> kostymyID) {
        this.kostymyID = kostymyID;
    }

    public List<Integer> getDoplnkyID() {
        return doplnkyID;
    }

    public void setDoplnkyID(List<Integer> doplnkyID) {
        this.doplnkyID = doplnkyID;
    }
}
