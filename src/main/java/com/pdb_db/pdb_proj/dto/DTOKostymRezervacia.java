package com.pdb_db.pdb_proj.dto;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


@Table
public class DTOKostymRezervacia
{
    private LocalDate casPozicania;
    private LocalDate casVratenia;
    private Integer vratenie;
    private Integer uzivid;
    private Integer kostymid;

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

    public Integer getKostymid() {
        return kostymid;
    }

    public void setKostymid(Integer kostymid) {
        this.kostymid = kostymid;
    }

    public DTOKostymRezervacia(LocalDate casPozicania, LocalDate casVratenia, Integer vratenie, Integer uzivid, Integer kostymid) {
        this.casPozicania = casPozicania;
        this.casVratenia = casVratenia;
        this.vratenie = vratenie;
        this.uzivid = uzivid;
        this.kostymid = kostymid;


    }
}
