package com.pdb_db.pdb_proj.dto;

import java.time.LocalDate;
import java.util.Date;

public class DTODoplnokRezervacia
{

    private Date casPozicania;
    private Date casVratenia;
    private Integer vratenie;
    private Integer uzivid;
    private Integer doplnokid;

    public DTODoplnokRezervacia(Date casPozicania, Date casVratenia, Integer vratenie, Integer uzivid, Integer doplnokid) {
        this.casPozicania = casPozicania;
        this.casVratenia = casVratenia;
        this.vratenie = vratenie;
        this.uzivid = uzivid;
        this.doplnokid = doplnokid;
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
}


