package com.pdb_db.pdb_proj.domain.doplnok;

import com.pdb_db.pdb_proj.domain.kostym.Kostym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface DoplnokRepository extends JpaRepository<Doplnok,Integer>
{
    @Query("SELECT d FROM Doplnok d where d.nazov = ?1") //TODO mozno nieco ine ?
    Optional<Doplnok> findDoplnokByNazov(String nazov);

    List<Doplnok> findAllByMaterial(String material);
}
