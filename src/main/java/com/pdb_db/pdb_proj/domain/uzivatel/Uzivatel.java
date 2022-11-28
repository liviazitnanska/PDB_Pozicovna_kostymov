package com.pdb_db.pdb_proj.domain.uzivatel;


public class Uzivatel implements UzivatelInterface {

  private String id;
  private String meno;
  private String priezvisko;
  private String email;
  private String telefon;
  private String stat;
  private String mesto;
  private String ulica;
  private String cislodomu;
  private String psc;


  public Uzivatel(){}

  @Override
  public String getId() {
    return id;
  }
  @Override
  public void setId(String id) {
    this.id = id;
  }


  @Override
  public String getMeno() {
    return meno;
  }
  @Override
  public void setMeno(String meno) {
    this.meno = meno;
  }


  @Override
  public String getPriezvisko() {
    return priezvisko;
  }
  @Override
  public void setPriezvisko(String priezvisko) {
    this.priezvisko = priezvisko;
  }


  @Override
  public String getEmail() {
    return email;
  }
  @Override
  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public String getTelefon() {
    return telefon;
  }
  @Override
  public void setTelefon(String telefon) {
    this.telefon = telefon;
  }


  @Override
  public String getStat() {
    return stat;
  }
  @Override
  public void setStat(String stat) {
    this.stat = stat;
  }


  @Override
  public String getMesto() {
    return mesto;
  }
  @Override
  public void setMesto(String mesto) {
    this.mesto = mesto;
  }


  @Override
  public String getUlica() {
    return ulica;
  }
  @Override
  public void setUlica(String ulica) {
    this.ulica = ulica;
  }


  @Override
  public String getCislodomu() {
    return cislodomu;
  }
  @Override
  public void setCislodomu(String cislodomu) {
    this.cislodomu = cislodomu;
  }


  @Override
  public String getPsc() {
    return psc;
  }
  @Override
  public void setPsc(String psc) {
    this.psc = psc;
  }

}
