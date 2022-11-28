package com.pdb_db.pdb_proj.domain.kostym;

public interface KostymInterface {

    String getId();

    void setId(String id);


    String getNazov();

    void setNazov(String nazov);


    String getPopis();

    void setPopis(String popis);


    String getMaterial();

    void setMaterial(String material);


    String getKategoria();

    void setKategoria(String kategoria);


    String getVelkost();

    void setVelkost(String velkost);


    java.sql.Date getVyroba();

    void setVyroba(java.sql.Date vyroba);

}
