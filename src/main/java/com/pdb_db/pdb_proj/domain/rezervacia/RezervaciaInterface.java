package com.pdb_db.pdb_proj.domain.rezervacia;

import java.time.LocalDate;

public interface RezervaciaInterface {

    Integer getId();

    void setId(Integer id);


    LocalDate getCasPozicania();

    void setCasPozicania(LocalDate casPozicania);


    LocalDate getCasVratenia();

    void setCasVratenia(LocalDate casVratenia);


    Integer getVratenie();

    void setVratenie(Integer vratenie);


    Integer getUzivid();

    void setUzivid(Integer uzivid);

}
