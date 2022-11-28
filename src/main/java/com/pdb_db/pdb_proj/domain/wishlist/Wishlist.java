package com.pdb_db.pdb_proj.domain.wishlist;


public class Wishlist implements WishlistInterface {

  private String id;
  private String nazov;
  private String uzivid;


  public Wishlist(){}


  @Override
  public String getId() {
    return id;
  }
  @Override
  public void setId(String id) {
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
  public String getUzivid() {
    return uzivid;
  }
  @Override
  public void setUzivid(String uzivid) {
    this.uzivid = uzivid;
  }

}
