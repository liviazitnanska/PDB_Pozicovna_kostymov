package com.pdb_db.pdb_proj.domainMongo.doplnokMongo;

import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import com.pdb_db.pdb_proj.domainMongo.recenzia_doplnokMongo.RecenziaDoplnokM;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface DoplnokRepositoryM extends MongoRepository<DoplnokM,Integer>
{

       // Optional<DoplnokM> findDoplnokMByNazov(String nazov);
       // Optional<DoplnokM> findDoplnokMById(Integer id);

        //List<DoplnokM> findAllByMaterial(String material);
        //List<DoplnokM> findAllByKategoria(String kategoria);
}
