package com.pdb_db.pdb_proj.domain.doplnok;

public interface DoplnokInterface {

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


    java.sql.Date getVyroba();

    void setVyroba(java.sql.Date vyroba);

}
