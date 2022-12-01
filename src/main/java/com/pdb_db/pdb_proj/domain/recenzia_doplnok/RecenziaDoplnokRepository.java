package com.pdb_db.pdb_proj.domain.recenzia_doplnok;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecenziaDoplnokRepository
        extends JpaRepository<RecenziaDoplnok, Integer> {

    @Override
    Optional<RecenziaDoplnok> findById(Integer id);
}
