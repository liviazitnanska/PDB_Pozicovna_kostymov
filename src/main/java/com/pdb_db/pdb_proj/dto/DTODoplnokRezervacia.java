package com.pdb_db.pdb_proj.dto;

import java.time.LocalDate;

public class DTODoplnokRezervacia
{

    private LocalDate casPozicania;
    private LocalDate casVratenia;
    private Integer vratenie;
    private Integer uzivid;
    private Integer doplnokid;

    public DTODoplnokRezervacia(LocalDate casPozicania, LocalDate casVratenia, Integer vratenie, Integer uzivid, Integer doplnokid) {
        this.casPozicania = casPozicania;
        this.casVratenia = casVratenia;
        this.vratenie = vratenie;
        this.uzivid = uzivid;
        this.doplnokid = doplnokid;
    }

    public LocalDate getCasPozicania() {
        return casPozicania;
    }

    public void setCasPozicania(LocalDate casPozicania) {
        this.casPozicania = casPozicania;
    }

    public LocalDate getCasVratenia() {
        return casVratenia;
    }

    public void setCasVratenia(LocalDate casVratenia) {
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


