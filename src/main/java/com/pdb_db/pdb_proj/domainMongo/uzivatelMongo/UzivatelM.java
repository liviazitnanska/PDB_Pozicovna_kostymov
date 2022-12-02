package com.pdb_db.pdb_proj.domainMongo.uzivatelMongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Document
public class UzivatelM
{
    @Id
    private Integer id;
    private String meno;
    private String priezvisko;
    @Indexed(unique = true)
    private String email;
    private String telefon;
    private String stat;
    private String mesto;
    private String ulica;
    private Integer cislodomu;
    private Integer psc;
    private List<String> wishlistyNazov;
    private List<Integer> recenzieDoplnkov;
    private List<Integer> recenzieKostymov;

    public UzivatelM(String meno, String priezvisko, String email, String telefon, String stat, String mesto, String ulica, Integer cislodomu, Integer psc, List<String> wishlistyNazov, List<Integer> recenzieDoplnkov, List<Integer> recenzieKostymov) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.email = email;
        this.telefon = telefon;
        this.stat = stat;
        this.mesto = mesto;
        this.ulica = ulica;
        this.cislodomu = cislodomu;
        this.psc = psc;
        this.wishlistyNazov = wishlistyNazov;
        this.recenzieDoplnkov = recenzieDoplnkov;
        this.recenzieKostymov = recenzieKostymov;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public Integer getCislodomu() {
        return cislodomu;
    }

    public void setCislodomu(Integer cislodomu) {
        this.cislodomu = cislodomu;
    }

    public Integer getPsc() {
        return psc;
    }

    public void setPsc(Integer psc) {
        this.psc = psc;
    }

    public List<String> getWishlistyNazov() {
        return wishlistyNazov;
    }

    public void setWishlistyNazov(List<String> wishlistyNazov) {
        this.wishlistyNazov = wishlistyNazov;
    }

    public List<Integer> getRecenzieDoplnkov() {
        return recenzieDoplnkov;
    }

    public void setRecenzieDoplnkov(List<Integer> recenzieDoplnkov) {
        this.recenzieDoplnkov = recenzieDoplnkov;
    }

    public List<Integer> getRecenzieKostymov() {
        return recenzieKostymov;
    }

    public void setRecenzieKostymov(List<Integer> recenzieKostymov) {
        this.recenzieKostymov = recenzieKostymov;
    }
}
