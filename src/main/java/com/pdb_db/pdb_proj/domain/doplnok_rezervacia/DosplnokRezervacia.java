package com.pdb_db.pdb_proj.domain.doplnok_rezervacia;


public class DosplnokRezervacia implements DosplnokRezervaciaInterface{

  private String id;
  private String uzivid;
  private String doplnokid;

  public DosplnokRezervacia(){}

  @Override
  public String getId() {
    return id;
  }
  @Override
  public void setId(String id) {
    this.id = id;
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
