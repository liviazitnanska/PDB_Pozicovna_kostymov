package com.pdb_db.pdb_proj.domainMongo.uzivatelMongo;

import com.pdb_db.pdb_proj.domainMongo.doplnokMongo.DoplnokM;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UzivatelRepositoryM extends MongoRepository<UzivatelM,Integer> {
}
