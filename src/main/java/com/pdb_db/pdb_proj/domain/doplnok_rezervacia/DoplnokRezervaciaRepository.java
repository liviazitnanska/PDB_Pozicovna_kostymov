package com.pdb_db.pdb_proj.domain.doplnok_rezervacia;

import com.pdb_db.pdb_proj.domain.kostym.Kostym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoplnokRezervaciaRepository extends JpaRepository<DoplnokRezervacia,Integer>
{

}
