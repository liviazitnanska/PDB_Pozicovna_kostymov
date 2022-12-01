package com.pdb_db.pdb_proj.domain.doplnok_rezervacia;

import javax.persistence.*;

@Entity
@Table
public class DoplnokRezervacia implements DoplnokRezervaciaInterface {
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

  private Integer rezervaciaid;


  public DoplnokRezervacia(){}

  public DoplnokRezervacia(Integer uzivid, Integer doplnokid, Integer rezervaciaid) {
    this.uzivid = uzivid;
    this.doplnokid = doplnokid;
    this.rezervaciaid = rezervaciaid;
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
  public Integer getRezervaciaid() {
    return rezervaciaid;
  }

  @Override
  public void setRezervaciaid(Integer rezervaciaid) {
    this.rezervaciaid =rezervaciaid;
  }

  @Override
  public String toString()
  {
    return "DoplnokRezervacia{" +
            "id=" + id+
            "uzivid=" + uzivid+ '\'' +
            "doplnokid=" + doplnokid +'}';
  }

}
