package com.pdb_db.pdb_proj.domainMongo.doplnokMongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
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
    private java.util.Date vyroba;
    private ArrayList<Integer> rezervaciaIdList;

    public DoplnokM(){}
    public DoplnokM(Integer id){
        this.id = id;
    }
    public DoplnokM(Integer id, String nazov, String popis, String material, String kategoria, java.util.Date vyroba, ArrayList<Integer> rezervaciaIdList) {
        this.id = id;
        this.nazov = nazov;
        this.popis = popis;
        this.material = material;
        this.kategoria = kategoria;
        this.vyroba = vyroba;
        this.rezervaciaIdList = rezervaciaIdList;
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

    public  java.util.Date getVyroba() {
        return vyroba;
    }

    public void setVyroba( java.util.Date vyroba) {
        this.vyroba = vyroba;
    }

    public ArrayList<Integer> getRecenzieDoplnkovID() {
        return rezervaciaIdList;
    }

    public void setRecenzieDoplnkovID(ArrayList<Integer> rezervaciaIdList) {
        this.rezervaciaIdList = rezervaciaIdList;
    }

    public void setNewIdToRezervaciaIdList(Integer id){
        this.rezervaciaIdList.add(id);
    }

    public void deleteIdFromRezervaciaIdList(Integer id){
        this.rezervaciaIdList.remove(id);
    }

    public boolean ifExistsIdInRezervaciaIdList(Integer id){
        return this.rezervaciaIdList.contains(id);
    }
}
