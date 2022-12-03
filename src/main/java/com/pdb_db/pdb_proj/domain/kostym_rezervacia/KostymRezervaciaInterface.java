package com.pdb_db.pdb_proj.domain.kostym_rezervacia;

public interface KostymRezervaciaInterface {

    Integer getId();

    void setId(Integer id);


    Integer getUzivid();

    void setUzivid(Integer uzivid);


    Integer getKostymid();

    void setKostymid(Integer kostymid);

    Integer getRezervaciaid();

    void setRezervaciaid(Integer rezervaciaid);


    java.util.Date getCasPozicania();

    void setCasPozicania(java.util.Date casPozicania);

    java.util.Date getCasVratenia();

    void setCasVratenia(java.util.Date casVratenia);

    Integer getVratenie();

    void setVratenie(Integer vratenie);
}
