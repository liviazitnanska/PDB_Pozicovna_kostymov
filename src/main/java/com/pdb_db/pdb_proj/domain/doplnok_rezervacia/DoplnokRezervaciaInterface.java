package com.pdb_db.pdb_proj.domain.doplnok_rezervacia;

public interface DoplnokRezervaciaInterface {

    Integer getId();

    void setId(Integer id);


    Integer getUzivid();

    void setUzivid(Integer uzivid);


    Integer getDoplnokid();

    void setDoplnokid(Integer doplnokid);


    java.util.Date getCasPozicania();

    void setCasPozicania(java.util.Date casPozicania);

    java.util.Date getCasVratenia();

    void setCasVratenia(java.util.Date casVratenia);

    Integer getVratenie();

    void setVratenie(Integer vratenie);
}
