package com.pdb_db.pdb_proj.domain.rezervacia;


public class Rezervacia implements RezervaciaInterface {

  private String id;
  private java.sql.Date casPozicania;
  private java.sql.Date casVratenia;
  private String vratenie;
  private String uzivid;


  public Rezervacia(){}


  @Override
  public String getId() {
    return id;
  }
  @Override
  public void setId(String id) {
    this.id = id;
  }


  @Override
  public java.sql.Date getCasPozicania() {
    return casPozicania;
  }
  @Override
  public void setCasPozicania(java.sql.Date casPozicania) {
    this.casPozicania = casPozicania;
  }


  @Override
  public java.sql.Date getCasVratenia() {
    return casVratenia;
  }
  @Override
  public void setCasVratenia(java.sql.Date casVratenia) {
    this.casVratenia = casVratenia;
  }


  @Override
  public String getVratenie() {
    return vratenie;
  }
  @Override
  public void setVratenie(String vratenie) {
    this.vratenie = vratenie;
  }


  @Override
  public String getUzivid() {
    return uzivid;
  }
  @Override
  public void setUzivid(String uzivid) {
    this.uzivid = uzivid;
  }

}
