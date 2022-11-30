package com.pdb_db.pdb_proj.domainMongo.rezervaciaMongo;

import com.pdb_db.pdb_proj.domainMongo.doplnokMongo.DoplnokM;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RezervaciaRepositoryM extends MongoRepository<RezervaciaM,Integer> {
}
