package com.pdb_db.pdb_proj.domain.rezervacia;

import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RezervaciaRepository
        extends JpaRepository<Rezervacia, Integer> {

    @Override
    Optional<Rezervacia> findById(Integer id);

    @Query("SELECT u FROM Uzivatel u where u.id = ?1")
    Optional<Uzivatel> findUzivatelById(Integer uzivID);
}
