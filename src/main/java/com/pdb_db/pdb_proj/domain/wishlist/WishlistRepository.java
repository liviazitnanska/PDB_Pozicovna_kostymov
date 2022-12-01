package com.pdb_db.pdb_proj.domain.wishlist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishlistRepository
    extends JpaRepository<Wishlist, Integer> {

    @Override
    Optional<Wishlist> findById(Integer id);
}
