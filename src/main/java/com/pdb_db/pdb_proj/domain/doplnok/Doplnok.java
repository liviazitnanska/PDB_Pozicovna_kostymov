package com.pdb_db.pdb_proj.domain.doplnok;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Entity
@Table
public class Doplnok implements DoplnokInterface {

  @Id
  @SequenceGenerator(
          name = "doplnok_sequence",
          sequenceName = "doplnok_sequence",
          allocationSize = 1
  )
  @GeneratedValue
          (strategy = GenerationType.SEQUENCE,
          generator = "doplnok_sequence"
          )

  private Integer id;
  private String nazov;
  private String popis;
  private String material;
  private String kategoria;
  private java.sql.Date vyroba;

  public Doplnok(){}

  public Doplnok(Integer id, String nazov, String popis, String material,String kategoria, java.sql.Date vyroba)
  {
    this.id = id;
    this.nazov = nazov;
    this.popis = popis;
    this.material = material;
    this.kategoria = kategoria;
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

  @Override
  public String toString()
  {
      return "Doplnok{" +
              "id=" + id+
              "nazov=" + nazov+ '\'' +
              "popis=" + popis+ '\'' +
              "material=" + material+
              "kategoria=" + kategoria +
              "vyroba=" + vyroba +'}';
  }
}
