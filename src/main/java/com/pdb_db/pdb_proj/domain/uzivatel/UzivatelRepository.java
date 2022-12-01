package com.pdb_db.pdb_proj.domain.uzivatel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UzivatelRepository
    extends JpaRepository<Uzivatel, Integer> {

    @Override
    Optional<Uzivatel> findById(Integer id);

    Optional<Uzivatel> findUzivatelByEmail(String email);

}
