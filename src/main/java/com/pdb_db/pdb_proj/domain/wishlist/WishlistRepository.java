package com.pdb_db.pdb_proj.domain.wishlist;

import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WishlistRepository
    extends JpaRepository<Wishlist, Integer> {

    @Override
    Optional<Wishlist> findById(Integer id);

    @Query("SELECT u FROM Uzivatel u where u.id = ?1") //TODO mozno nieco ine ?
    Optional<Uzivatel> findUzivatelById(Integer uzivID);




}
