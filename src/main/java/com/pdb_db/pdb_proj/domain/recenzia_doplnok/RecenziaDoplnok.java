package com.pdb_db.pdb_proj.domain.recenzia_doplnok;


public class RecenziaDoplnok implements RecenziaDoplnokInterface{

  private String id;
  private String nazov;
  private String popis;
  private String suhlas;
  private String nesuhlas;
  private String uzivid;
  private String doplnokid;


  public RecenziaDoplnok(){}


  @Override
  public String getId() {
    return id;
  }
  @Override
  public void setId(String id) {
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
  public String getSuhlas() {
    return suhlas;
  }
  @Override
  public void setSuhlas(String suhlas) {
    this.suhlas = suhlas;
  }


  @Override
  public String getNesuhlas() {
    return nesuhlas;
  }
  @Override
  public void setNesuhlas(String nesuhlas) {
    this.nesuhlas = nesuhlas;
  }


  @Override
  public String getUzivid() {
    return uzivid;
  }
  @Override
  public void setUzivid(String uzivid) {
    this.uzivid = uzivid;
  }


  @Override
  public String getDoplnokid() {
    return doplnokid;
  }
  @Override
  public void setDoplnokid(String doplnokid) {
    this.doplnokid = doplnokid;
  }

}
