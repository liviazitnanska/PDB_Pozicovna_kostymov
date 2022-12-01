package com.pdb_db.pdb_proj.domain.recenzia_doplnok;

import javax.persistence.*;

@Entity
@Table
public class RecenziaDoplnok implements RecenziaDoplnokInterface{

  @Id
  @SequenceGenerator(
          name = "recenziaDoplnok_sequence",
          sequenceName = "recenziaDoplnok_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "recenziaDoplnok_sequence"
  )
  private Integer id;
  private String nazov;
  private String popis;
  private Integer suhlas;
  private Integer nesuhlas;
  private Integer uzivid;
  private Integer doplnokid;


  public RecenziaDoplnok(){}
  public RecenziaDoplnok(Integer id,
                         String nazov,
                         String popis,
                         Integer suhlas,
                         Integer nesuhlas,
                         Integer uzivid,
                         Integer doplnokid ){
    this.id = id;
    this.nazov = nazov;
    this.popis = popis;
    this.suhlas = suhlas;
    this.nesuhlas = nesuhlas;
    this.uzivid = uzivid;
    this.doplnokid = doplnokid;
  }

  public RecenziaDoplnok(Integer id,
                         String nazov,
                         String popis,
                         Integer suhlas,
                         Integer nesuhlas ){
    this.id = id;
    this.nazov = nazov;
    this.popis = popis;
    this.suhlas = suhlas;
    this.nesuhlas = nesuhlas;
  }

  public RecenziaDoplnok(String nazov,
                         String popis,
                         Integer suhlas,
                         Integer nesuhlas ){
    this.nazov = nazov;
    this.popis = popis;
    this.suhlas = suhlas;
    this.nesuhlas = nesuhlas;

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
  public String getNazov() {
    return nazov;
  }
  @Override
  public void setNazov(String nazov) {
    this.nazov = nazov;
  }


  @Override
  public String getPopis() {
    return popis;
  }
  @Override
  public void setPopis(String popis) {
    this.popis = popis;
  }


  @Override
  public Integer getSuhlas() {
    return suhlas;
  }
  @Override
  public void setSuhlas(Integer suhlas) {
    this.suhlas = suhlas;
  }


  @Override
  public Integer getNesuhlas() {
    return nesuhlas;
  }
  @Override
  public void setNesuhlas(Integer nesuhlas) {
    this.nesuhlas = nesuhlas;
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

}
