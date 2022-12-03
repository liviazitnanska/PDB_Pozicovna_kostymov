package com.pdb_db.pdb_proj.domain.kostym;


import com.pdb_db.pdb_proj.utilities.rest_operationType;

import javax.persistence.*;


@Entity
@Table
public class Kostym implements KostymInterface {
  @Id
  @SequenceGenerator(
          name = "kostym_sequence",
          sequenceName = "kostym_sequence",
          allocationSize = 1
  )
  @GeneratedValue
          (strategy = GenerationType.SEQUENCE,
                  generator = "kostym_sequence"
          )

  private Integer id;
  private String nazov;
  private String popis;
  private String material;
  private String kategoria;
  private Integer velkost;
  private java.util.Date vyroba;
  @Transient
  private rest_operationType rest_operation;

  public Kostym(){}
  public Kostym(Integer id){
    this.id = id;
  }

  public Kostym( Integer id, String nazov, String popis, String material,String kategoria,Integer velkost, java.util.Date  vyroba)
  {
    this.id = id;
    this.nazov = nazov;
    this.popis = popis;
    this.material = material;
    this.kategoria = kategoria;
    this.velkost = velkost;
    this.vyroba = vyroba;
  }

  public Kostym( String nazov, String popis, String material,String kategoria,Integer velkost,java.sql.Date vyroba)
  {
    this.id = id;
    this.nazov = nazov;
    this.popis = popis;
    this.material = material;
    this.kategoria = kategoria;
    this.velkost = velkost;
    this.vyroba = vyroba;
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
  public String getMaterial() {
    return material;
  }
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
  public Integer getVelkost() {
    return velkost;
  }
  @Override
  public void setVelkost(Integer velkost) {
    this.velkost = velkost;
  }


  @Override
  public  java.util.Date  getVyroba() {
    return vyroba;
  }
  @Override
  public void setVyroba( java.util.Date  vyroba) {
    this.vyroba = vyroba;
  }

  @Override
  public String toString()
  {
    return "Kostym{" +
            "id=" + id+
            "nazov=" + nazov+ '\'' +
            "popis=" + popis+ '\'' +
            "material=" + material+
            "velkost=" + velkost +
            "kategoria=" + kategoria +
            "vyroba=" + vyroba +'}';
  }

  public rest_operationType getOperation(){ return rest_operation; }
  public void setOperation(rest_operationType rest_operation){ this.rest_operation = rest_operation; }
}
