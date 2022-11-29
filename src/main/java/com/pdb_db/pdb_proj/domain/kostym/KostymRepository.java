package com.pdb_db.pdb_proj.domain.kostym;

import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KostymRepository extends JpaRepository<Kostym,Integer>
{
    @Query("SELECT k FROM Kostym k where k.nazov = ?1") //TODO mozno nieco ine ?
    Optional<Kostym> findKostymByNazov(String nazov);
}
