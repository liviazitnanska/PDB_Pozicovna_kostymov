package com.pdb_db.pdb_proj.domain.recenzia_kostym;

import javax.persistence.*;

@Entity
@Table
public class RecenziaKostym implements RecenziaKostymInterface {

  @Id
  @SequenceGenerator(
          name = "recenziaKostym_sequence",
          sequenceName = "recenziaKostym_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "recenziaKostym_sequence"
  )
  private Integer id;
  private String nazov;
  private String popis;
  private Integer suhlas;
  private Integer nesuhlas;
  private Integer uzivid;
  private Integer kostymid;


  public RecenziaKostym(){}
  public RecenziaKostym(Integer id,
                        String nazov,
                        String popis,
                        Integer suhlas,
                        Integer nesuhlas,
                        Integer uzivid,
                        Integer kostymid ){
    this.id = id;
    this.nazov = nazov;
    this.popis = popis;
    this.suhlas = suhlas;
    this.nesuhlas = nesuhlas;
    this.uzivid = uzivid;
    this.kostymid = kostymid;
  }

  public RecenziaKostym(Integer id,
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

  public RecenziaKostym(String nazov,
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
  public Integer getKostymid() {
    return kostymid;
  }
  @Override
  public void setKostymid(Integer kostymid) {
    this.kostymid = kostymid;
  }

}
