package com.pdb_db.pdb_proj.domain.kostym_rezervacia;

import com.pdb_db.pdb_proj.domain.kostym.Kostym;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KostymRezervaciaRepository extends JpaRepository<KostymRezervacia,Integer>
{
    @Query("SELECT u FROM Uzivatel u where u.id = ?1")
    Optional<Uzivatel> findUzivatelById(Integer uzivID);

    @Query("SELECT k FROM Kostym k where k.id = ?1")
    Optional<Kostym> findKostymById(Integer kostymID);

    List<KostymRezervacia> findAllByVratenie(Integer vratenie);

    @Query("SELECT k FROM KostymRezervacia k where k.uzivid = ?1")
    List<KostymRezervacia> findAllKostymRezervaciaByUzivid(Integer id);

}
