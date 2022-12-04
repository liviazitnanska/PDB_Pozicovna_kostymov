package com.pdb_db.pdb_proj.domain.doplnok_rezervacia;

import com.pdb_db.pdb_proj.utilities.rest_operationType;

import javax.persistence.*;

@Entity
@Table
public class DoplnokRezervacia implements DoplnokRezervaciaInterface {
  @Id
  @SequenceGenerator(
          name = "doplnokrezervacia_sequence",
          sequenceName = "doplnokrezervacia_sequence",
          allocationSize = 1
  )
  @GeneratedValue
          (strategy = GenerationType.SEQUENCE,
                  generator = "doplnokrezervacia_sequence"
          )

  private Integer id;
  private Integer uzivid;
  private Integer doplnokid;
  private java.util.Date casPozicania;
  private java.util.Date casVratenia;
  private Integer vratenie;

  @Transient
  private rest_operationType rest_operation;

  public DoplnokRezervacia(){}
  public DoplnokRezervacia(Integer id){
    this.id = id;
  }

  public DoplnokRezervacia(Integer uzivid,
                           Integer doplnokid,
                           java.util.Date casPozicania,
                           java.util.Date casVratenia,
                           Integer vratenie)
  {
    this.uzivid = uzivid;
    this.doplnokid = doplnokid;
    this.casPozicania = casPozicania;
    this.casVratenia = casVratenia;
    this.vratenie = vratenie;
  }

  public DoplnokRezervacia(Integer id,
                           Integer uzivid,
                           Integer doplnokid,
                           java.util.Date casPozicania,
                           java.util.Date casVratenia,
                           Integer vratenie)
  {
    this.id = id;
    this.uzivid = uzivid;
    this.doplnokid = doplnokid;
    this.casPozicania = casPozicania;
    this.casVratenia = casVratenia;
    this.vratenie = vratenie;
  }

  @Override
  public Integer getId() {
    return id;
  }
  @Override
  public void setId(Integer id) {
    this.id = id;
  }


  @Override
  public Integer getUzivid() {
    return uzivid;
  }
  @Override
  public void setUzivid(Integer uzivid) {
    this.uzivid = uzivid;
  }


  @Override
  public Integer getDoplnokid() {
    return doplnokid;
  }
  @Override
  public void setDoplnokid(Integer doplnokid) {
    this.doplnokid = doplnokid;
  }

  @Override
  public String toString()
  {
    return "DoplnokRezervacia{" +
            "id=" + id+
            "uzivid=" + uzivid+ '\'' +
            "doplnokid=" + doplnokid +'}';
  }

  public rest_operationType getOperation(){ return rest_operation; }
  public void setOperation(rest_operationType rest_operation){ this.rest_operation = rest_operation; }

  @Override
  public java.util.Date getCasPozicania() {
    return casPozicania;
  }
  @Override
  public void setCasPozicania(java.util.Date casPozicania) {
    this.casPozicania = casPozicania;
  }


  @Override
  public java.util.Date getCasVratenia() {
    return casVratenia;
  }
  @Override
  public void setCasVratenia(java.util.Date casVratenia) {
    this.casVratenia = casVratenia;
  }


  @Override
  public Integer getVratenie() {
    return vratenie;
  }
  @Override
  public void setVratenie(Integer vratenie) {
    this.vratenie = vratenie;
  }
}
