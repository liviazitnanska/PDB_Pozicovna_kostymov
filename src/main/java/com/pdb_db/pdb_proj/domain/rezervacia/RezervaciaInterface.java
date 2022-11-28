package com.pdb_db.pdb_proj.domain.rezervacia;

public interface RezervaciaInterface {

    String getId();

    void setId(String id);


    java.sql.Date getCasPozicania();

    void setCasPozicania(java.sql.Date casPozicania);


    java.sql.Date getCasVratenia();

    void setCasVratenia(java.sql.Date casVratenia);


    String getVratenie();

    void setVratenie(String vratenie);


    String getUzivid();

    void setUzivid(String uzivid);

}
