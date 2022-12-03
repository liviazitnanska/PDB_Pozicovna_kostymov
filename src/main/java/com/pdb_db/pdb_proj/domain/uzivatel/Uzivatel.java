package com.pdb_db.pdb_proj.domain.uzivatel;


import lombok.Builder;

import javax.persistence.*;

@Entity
@Table
public class Uzivatel implements UzivatelInterface {

  @Id
  @SequenceGenerator(
          name = "uzivatel_sequence",
          sequenceName = "uzivatel_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "uzivatel_sequence"
  )
  private Integer id;
  private String meno;
  private String priezvisko;
  private String email;
  private String telefon;
  private String stat;
  private String mesto;
  private String ulica;
  private Integer cislodomu;
  private Integer psc;


  public Uzivatel(){}
  public Uzivatel(Integer id,
                  String meno,
                  String priezvisko,
                  String email,
                  String telefon,
                  String stat,
                  String mesto,
                  String ulica,
                  Integer cislodomu,
                  Integer psc){
    this.id=id;
    this.meno=meno;
    this.priezvisko=priezvisko;
    this.email=email;
    this.telefon=telefon;
    this.stat=stat;
    this.mesto=mesto;
    this.ulica=ulica;
    this.cislodomu=cislodomu;
    this.psc=psc;
  }

  public Uzivatel(String meno,
                  String priezvisko,
                  String email,
                  String telefon,
                  String stat,
                  String mesto,
                  String ulica,
                  Integer cislodomu,
                  Integer psc){
    this.meno=meno;
    this.priezvisko=priezvisko;
    this.email=email;
    this.telefon=telefon;
    this.stat=stat;
    this.mesto=mesto;
    this.ulica=ulica;
    this.cislodomu=cislodomu;
    this.psc=psc;
  }

  public Uzivatel(String meno,
                  String priezvisko,
                  String email,
                  String stat,
                  String mesto,
                  String ulica,
                  Integer cislodomu,
                  Integer psc){
    this.meno=meno;
    this.priezvisko=priezvisko;
    this.email=email;
    this.stat=stat;
    this.mesto=mesto;
    this.ulica=ulica;
    this.cislodomu=cislodomu;
    this.psc=psc;
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
  public Integer getCislodomu() {
    return cislodomu;
  }
  @Override
  public void setCislodomu(Integer cislodomu) {
    this.cislodomu = cislodomu;
  }


  @Override
  public Integer getPsc() {
    return psc;
  }
  @Override
  public void setPsc(Integer psc) {
    this.psc = psc;
  }

}
