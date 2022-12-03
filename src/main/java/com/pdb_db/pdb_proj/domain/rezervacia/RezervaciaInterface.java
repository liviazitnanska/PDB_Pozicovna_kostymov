package com.pdb_db.pdb_proj.domain.rezervacia;

import java.time.LocalDate;
import java.util.Date;

public interface RezervaciaInterface {

    Integer getId();

    void setId(Integer id);


    Date getCasPozicania();

    void setCasPozicania(Date casPozicania);


    Date getCasVratenia();

    void setCasVratenia(Date casVratenia);


    Integer getVratenie();

    void setVratenie(Integer vratenie);


    Integer getUzivid();

    void setUzivid(Integer uzivid);

}
