package com.pdb_db.pdb_proj.domainMongo.recenzia_doplnokMongo;

import com.pdb_db.pdb_proj.domainMongo.doplnokMongo.DoplnokM;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecenziaDoplnokRepositoryM extends MongoRepository<RecenziaDoplnokM,Integer> {
}
