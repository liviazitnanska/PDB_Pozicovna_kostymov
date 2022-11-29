package com.pdb_db.pdb_proj.domain.doplnok_rezervacia;

import javax.persistence.*;

@Entity
@Table
public class DoplnokRezervacia implements DoplnokRezervaciaInterface{
  @Id
  @SequenceGenerator(
          name = "doplnokrezervacia_sequence",
          sequenceName = "doplnokrezervacia_sequence",
          allocationSize = 1
  )
  @GeneratedValue
          (strategy = GenerationType.SEQUENCE,
                  generator = "doplnokrezervacia_sequence"
          )

  private Integer id;
  private Integer uzivid;
  private Integer doplnokid;

  public DoplnokRezervacia(){}

  public DoplnokRezervacia(Integer id, Integer uzivid, Integer doplnokid)
  {
    this.id = id;
    this.uzivid = uzivid;
    this.doplnokid = doplnokid;
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

  @Override
  public String toString()
  {
    return "DosplnokRezervacia{" +
            "id=" + id+
            "uzivid=" + uzivid+ '\'' +
            "doplnokid=" + doplnokid +'}';
  }

}
