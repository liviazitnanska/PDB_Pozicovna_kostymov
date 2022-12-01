package com.pdb_db.pdb_proj.domain.recenzia_kostym;

import com.pdb_db.pdb_proj.domain.kostym.Kostym;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecenziaKostymRepository
        extends JpaRepository<RecenziaKostym, Integer> {

    @Override
    Optional<RecenziaKostym> findById(Integer id);

    @Query("SELECT u FROM Uzivatel u where u.id = ?1")
    Optional<Uzivatel> findUzivatelById(Integer uzivID);

    @Query("SELECT k FROM Kostym k where k.id = ?1")
    Optional<Kostym> findKostymById(Integer kostymID);

}
