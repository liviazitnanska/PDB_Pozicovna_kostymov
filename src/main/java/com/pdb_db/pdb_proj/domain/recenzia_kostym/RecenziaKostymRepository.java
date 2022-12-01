package com.pdb_db.pdb_proj.domain.recenzia_kostym;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecenziaKostymRepository
        extends JpaRepository<RecenziaKostym, Integer> {

    @Override
    Optional<RecenziaKostym> findById(Integer id);

}
