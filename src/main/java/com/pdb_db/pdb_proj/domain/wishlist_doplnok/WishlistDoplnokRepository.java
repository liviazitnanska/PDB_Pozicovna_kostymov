package com.pdb_db.pdb_proj.domain.wishlist_doplnok;

import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WishlistDoplnokRepository extends JpaRepository<WishlistDoplnok, Integer>
{
    @Override
    Optional<WishlistDoplnok> findById(Integer id);

    @Query("SELECT u FROM Uzivatel u where u.id = ?1")
    Optional<Uzivatel> findUzivatelById(Integer uzivID);

    @Query("SELECT k FROM WishlistDoplnok k where k.nazov = ?1")
    Optional<WishlistDoplnok> findWishByNazov(String nazov);
    @Query("SELECT u FROM Doplnok u where u.id = ?1")
    Optional<Doplnok> findDoplnokById(Integer doplnokid);

    @Query("SELECT k FROM WishlistDoplnok k where k.uzivid = ?1")
    List<WishlistDoplnok> findAllWishlistDoplnokByUzivid(Integer id);

}
