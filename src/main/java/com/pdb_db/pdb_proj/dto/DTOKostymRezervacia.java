package com.pdb_db.pdb_proj.dto;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;


@Table
public class DTOKostymRezervacia
{
    private Date casPozicania;
    private Date casVratenia;
    private Integer vratenie;
    private Integer uzivid;
    private Integer kostymid;

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

    public DTOKostymRezervacia(Date casPozicania, Date casVratenia, Integer vratenie, Integer uzivid, Integer kostymid) {
        this.casPozicania = casPozicania;
        this.casVratenia = casVratenia;
        this.vratenie = vratenie;
        this.uzivid = uzivid;
        this.kostymid = kostymid;


    }
}
