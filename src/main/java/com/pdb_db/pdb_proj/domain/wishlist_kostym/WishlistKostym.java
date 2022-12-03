package com.pdb_db.pdb_proj.domain.wishlist_kostym;


import javax.persistence.*;

@Entity
@Table
public class WishlistKostym implements WishlistKostymInterface {

  @Id
  @SequenceGenerator(
          name = "wishlistkostym_sequence",
          sequenceName = "wishlistkostym_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "wishlistkostym_sequence"
  )
  private Integer id;
  private String nazov;
  private Integer uzivid;

  private Integer kostymid;


  public WishlistKostym(){}
  public WishlistKostym(String nazov,Integer uzivid, Integer kostymid)
  {
    this.kostymid = kostymid;
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

  @Override
  public Integer getKostymid() {
    return kostymid;
  }

  @Override
  public void setKostymid(Integer kostymid)
  {
      this.kostymid=kostymid;
  }

}
