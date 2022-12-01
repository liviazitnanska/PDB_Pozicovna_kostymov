package com.pdb_db.pdb_proj.domain.uzivatel;

public interface UzivatelInterface {

    Integer getId();

    void setId(Integer id);


    String getMeno();

    void setMeno(String meno);


    String getPriezvisko();

    void setPriezvisko(String priezvisko);


    String getEmail();

    void setEmail(String email);


    String getTelefon();

    void setTelefon(String telefon);


    String getStat();

    void setStat(String stat);


    String getMesto();

    void setMesto(String mesto);


    String getUlica();

    void setUlica(String ulica);


    Integer getCislodomu();

    void setCislodomu(Integer cislodomu);


    Integer getPsc();

    void setPsc(Integer psc);

}
