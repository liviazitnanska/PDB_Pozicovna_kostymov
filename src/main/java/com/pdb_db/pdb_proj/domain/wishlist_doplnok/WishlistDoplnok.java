package com.pdb_db.pdb_proj.domain.wishlist_doplnok;

import com.pdb_db.pdb_proj.domain.wishlist_kostym.WishlistKostymInterface;

import javax.persistence.*;

@Entity
@Table
public class WishlistDoplnok implements WishlistDoplnokInterface {

    @Id
    @SequenceGenerator(
            name = "wishlistdoplnok_sequence",
            sequenceName = "wishlistdoplnok_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "wishlistdoplnok_sequence"
    )
    private Integer id;
    private String nazov;
    private Integer uzivid;
    private Integer doplnokid;

    public WishlistDoplnok() {}

    public WishlistDoplnok(String nazov, Integer uzivid, Integer doplnokid) {
        this.nazov = nazov;
        this.uzivid = uzivid;
        this.doplnokid = doplnokid;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id)
    {
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
    public Integer getDoplnokid() {
        return doplnokid;
    }

    @Override
    public void setDoplnokmid(Integer kostymid)
    {
        this.doplnokid = doplnokid;
    }
}
