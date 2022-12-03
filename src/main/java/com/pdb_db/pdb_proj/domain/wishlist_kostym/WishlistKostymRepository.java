package com.pdb_db.pdb_proj.domain.wishlist_kostym;

import com.pdb_db.pdb_proj.domain.kostym.Kostym;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WishlistKostymRepository
    extends JpaRepository<WishlistKostym, Integer> {

    @Override
    Optional<WishlistKostym> findById(Integer id);

    @Query("SELECT k FROM WishlistKostym k where k.nazov = ?1")
    Optional<WishlistKostym> findWishByNazov(String nazov);

    @Query("SELECT u FROM Uzivatel u where u.id = ?1")
    Optional<Uzivatel> findUzivatelById(Integer uzivID);

    @Query("SELECT u FROM Kostym u where u.id = ?1")
    Optional<Kostym> findKostymById(Integer kostymid);

}
