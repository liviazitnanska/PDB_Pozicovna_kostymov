package com.pdb_db.pdb_proj.domain.kostym_rezervacia;

import javax.persistence.*;

@Entity
@Table
public class KostymRezervacia implements KostymRezervaciaInterface {
  @Id
  @SequenceGenerator(
          name = "kostymrezervacia_sequence",
          sequenceName = "kostymrezervacia_sequence",
          allocationSize = 1
  )
  @GeneratedValue
          (strategy = GenerationType.SEQUENCE,
                  generator = "kostymrezervacia_sequence"
          )
  private Integer id;
  private Integer uzivid;
  private Integer kostymid;
  private Integer rezervaciaid;



  public KostymRezervacia(){}

  public KostymRezervacia(Integer uzivid, Integer kostymid, Integer rezervaciaid) {
    this.uzivid = uzivid;
    this.kostymid = kostymid;
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
  public Integer getKostymid() {
    return kostymid;
  }
  @Override
  public void setKostymid(Integer kostymid) {
    this.kostymid = kostymid;
  }

  @Override
  public Integer getRezervaciaid() {
    return rezervaciaid;
  }

  @Override
  public void setRezervaciaid(Integer rezervaciaid) {
    this.rezervaciaid = rezervaciaid;

  }

  @Override
  public String toString()
  {
    return "DoplnokRezervacia{" +
            "id=" + id+
            "uzivid=" + uzivid+ '\'' +
            "kostymid=" + kostymid +'}';
  }

}
