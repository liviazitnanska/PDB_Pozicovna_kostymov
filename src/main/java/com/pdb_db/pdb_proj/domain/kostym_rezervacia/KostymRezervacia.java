package com.pdb_db.pdb_proj.domain.kostym_rezervacia;


public class KostymRezervacia implements KostymRezervaciaInterface {

  private String id;
  private String uzivid;
  private String kostymid;


  public KostymRezervacia(){}


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
  public String getKostymid() {
    return kostymid;
  }
  @Override
  public void setKostymid(String kostymid) {
    this.kostymid = kostymid;
  }

}
