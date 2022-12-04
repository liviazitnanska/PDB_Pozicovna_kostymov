package com.pdb_db.pdb_proj.domain.kostym_rezervacia;

import com.pdb_db.pdb_proj.utilities.rest_operationType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class KostymRezervacia implements KostymRezervaciaInterface {
  @Id
  @SequenceGenerator(
          name = "kostymrezervacia_sequence",
          sequenceName = "kostymrezervacia_sequence",
          allocationSize = 1
  )
  @GeneratedValue
          (strategy = GenerationType.SEQUENCE,
                  generator = "kostymrezervacia_sequence"
          )
  private Integer id;
  private Integer uzivid;
  private Integer kostymid;
  private java.util.Date casPozicania;
  private java.util.Date casVratenia;
  private Integer vratenie;
  @Transient
  private rest_operationType rest_operation;

  public KostymRezervacia(){}
  public KostymRezervacia(Integer id){
    this.id = id;
  }

  public KostymRezervacia(Integer id,
                          Integer uzivid,
                          Integer kostymid,
                          java.util.Date casPozicania,
                          java.util.Date casVratenia,
                          Integer vratenie)
  {
    this.id = id;
    this.uzivid = uzivid;
    this.kostymid = kostymid;
    this.casPozicania = casPozicania;
    this.casVratenia = casVratenia;
    this.vratenie = vratenie;
  }

  public KostymRezervacia(Integer uzivid, Integer kostymid, Integer rezervaciaid, Date casPozicania, Date casVratenia, Integer vratenie) {
    this.uzivid = uzivid;
    this.kostymid = kostymid;
    this.rezervaciaid = rezervaciaid;
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
  public Integer getKostymid() {
    return kostymid;
  }
  @Override
  public void setKostymid(Integer kostymid) {
    this.kostymid = kostymid;
  }


  @Override
  public String toString()
  {
    return "DoplnokRezervacia{" +
            "id=" + id+
            "uzivid=" + uzivid+ '\'' +
            "kostymid=" + kostymid +'}';
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
