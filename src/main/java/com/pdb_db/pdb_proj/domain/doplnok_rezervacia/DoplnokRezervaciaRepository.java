package com.pdb_db.pdb_proj.domain.doplnok_rezervacia;

import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoplnokRezervaciaRepository extends JpaRepository<DoplnokRezervacia,Integer>
{
    @Query("SELECT u FROM Uzivatel u where u.id = ?1")
    Optional<Uzivatel> findUzivatelById(Integer uzivID);

    @Query("SELECT k FROM Doplnok k where k.id = ?1")
    Optional<Doplnok> findDoplnokById(Integer doplnokID);

    List<DoplnokRezervacia> findAllByVratenie(Integer vratenie);

    @Query("SELECT k FROM DoplnokRezervacia k where k.uzivid = ?1")
    List<DoplnokRezervacia> findAllDoplnokRezervaciaByUzivid(Integer id);
}
