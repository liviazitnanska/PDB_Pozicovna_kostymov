package com.pdb_db.pdb_proj.domainMongo.doplnokMongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DoplnokRepositoryM extends MongoRepository<DoplnokM,Integer>
{

        Optional<DoplnokM> findDoplnokMByNazov(String nazov);

}
