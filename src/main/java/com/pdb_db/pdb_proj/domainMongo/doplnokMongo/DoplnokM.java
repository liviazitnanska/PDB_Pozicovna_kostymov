package com.pdb_db.pdb_proj.domainMongo.doplnokMongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.util.List;

@Data
@Document
public class DoplnokM
{
    @Id
    private Integer id;
    @Indexed(unique = true)
    private String nazov;
    private String popis;
    private String material;
    private String kategoria;
    private java.sql.Date vyroba;
    private List<Integer> recenzieDoplnkovID;

    public DoplnokM( Integer id, String nazov, String popis, String material, String kategoria, Date vyroba, List<Integer> recenzieDoplnkovID) {
        this.id = id;
        this.nazov = nazov;
        this.popis = popis;
        this.material = material;
        this.kategoria = kategoria;
        this.vyroba = vyroba;
        this.recenzieDoplnkovID = recenzieDoplnkovID;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public Date getVyroba() {
        return vyroba;
    }

    public void setVyroba(Date vyroba) {
        this.vyroba = vyroba;
    }

    public List<Integer> getRecenzieDoplnkovID() {
        return recenzieDoplnkovID;
    }

    public void setRecenzieDoplnkovID(List<Integer> recenzieDoplnkovID) {
        this.recenzieDoplnkovID = recenzieDoplnkovID;
    }
}
