package com.pdb_db.pdb_proj.domain.rezervacia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RezervaciaRepository
        extends JpaRepository<Rezervacia, Integer> {

    @Override
    Optional<Rezervacia> findById(Integer id);
}
