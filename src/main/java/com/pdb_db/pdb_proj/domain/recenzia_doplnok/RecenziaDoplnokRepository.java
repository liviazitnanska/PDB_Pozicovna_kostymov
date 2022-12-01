package com.pdb_db.pdb_proj.domain.recenzia_doplnok;

import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecenziaDoplnokRepository
        extends JpaRepository<RecenziaDoplnok, Integer> {

    @Override
    Optional<RecenziaDoplnok> findById(Integer id);

    @Query("SELECT u FROM Uzivatel u where u.id = ?1")
    Optional<Uzivatel> findUzivatelById(Integer uzivID);

    @Query("SELECT k FROM Doplnok k where k.id = ?1")
    Optional<Doplnok> findDoplnokById(Integer doplnokID);
}

