package com.pdb_db.pdb_proj.domain.recenzia_doplnok;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

public interface RecenziaDoplnokInterface {

    Integer getId();

    void setId(Integer id);


    String getNazov();

    void setNazov(String nazov);


    String getPopis();

    void setPopis(String popis);


    Integer getSuhlas();

    void setSuhlas(Integer suhlas);


    Integer getNesuhlas();

    void setNesuhlas(Integer nesuhlas);


    Integer getUzivid();

    void setUzivid(Integer uzivid);


    Integer getDoplnokid();

    void setDoplnokid(Integer doplnokid);

}
