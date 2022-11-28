package com.pdb_db.pdb_proj.domain.doplnok;


public class Doplnok implements DoplnokInterface {

  private String id;
  private String nazov;
  private String popis;
  private String material;
  private String kategoria;
  private java.sql.Date vyroba;


  public Doplnok(){}


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
  public String getMaterial() { return material; }
  @Override
  public void setMaterial(String material) {
    this.material = material;
  }


  @Override
  public String getKategoria() {
    return kategoria;
  }
  @Override
  public void setKategoria(String kategoria) {
    this.kategoria = kategoria;
  }


  @Override
  public java.sql.Date getVyroba() {
    return vyroba;
  }
  @Override
  public void setVyroba(java.sql.Date vyroba) {
    this.vyroba = vyroba;
  }

}
