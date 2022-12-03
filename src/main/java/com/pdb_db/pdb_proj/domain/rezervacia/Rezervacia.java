package com.pdb_db.pdb_proj.domain.rezervacia;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Rezervacia implements RezervaciaInterface {

  @Id
  @SequenceGenerator(
          name = "rezervacia_sequence",
          sequenceName = "rezervacia_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "rezervacia_sequence"
  )
  private Integer id;
  private Date casPozicania;
  private Date casVratenia;
  private Integer vratenie;
  private Integer uzivid;


  public Rezervacia(){}
  public Rezervacia(Integer id,
                    Date casPozicania,
                    Date casVratenia,
                    Integer vratenie,
                    Integer uzivid
                    ){
    this.id=id;
    this.casPozicania=casPozicania;
    this.casVratenia=casVratenia;
    this.vratenie=vratenie;
    this.uzivid=uzivid;
  }


  public Rezervacia(Date casPozicania,
                    Date casVratenia,
                    Integer vratenie,
                    Integer uzivid
  ){
    this.casPozicania=casPozicania;
    this.casVratenia=casVratenia;
    this.vratenie=vratenie;
    this.uzivid = uzivid;
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
  public Date getCasPozicania() {
    return casPozicania;
  }
  @Override
  public void setCasPozicania(Date casPozicania) {
    this.casPozicania = casPozicania;
  }


  @Override
  public Date getCasVratenia() {
    return casVratenia;
  }
  @Override
  public void setCasVratenia(Date casVratenia) {
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


  @Override
  public Integer getUzivid() {
    return uzivid;
  }
  @Override
  public void setUzivid(Integer uzivid) {
    this.uzivid = uzivid;
  }

}
