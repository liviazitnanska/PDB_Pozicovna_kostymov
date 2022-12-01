package com.pdb_db.pdb_proj.domain.wishlist;


import javax.persistence.*;

@Entity
@Table
public class Wishlist implements WishlistInterface {

  @Id
  @SequenceGenerator(
          name = "wishlist_sequence",
          sequenceName = "wishlist_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "wishlist_sequence"
  )
  private Integer id;
  private String nazov;
  private Integer uzivid;


  public Wishlist(){}
  public Wishlist(Integer id,
                  String nazov,
                  Integer uzivid){
    this.id=id;
    this.nazov=nazov;
    this.uzivid=uzivid;
  }

  public Wishlist(String nazov,
                  Integer uzivid){
    this.nazov=nazov;
    this.uzivid=uzivid;
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
  public Integer getUzivid() {
    return uzivid;
  }
  @Override
  public void setUzivid(Integer uzivid) {
    this.uzivid = uzivid;
  }

}
