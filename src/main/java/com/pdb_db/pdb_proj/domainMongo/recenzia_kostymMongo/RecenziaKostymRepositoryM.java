package com.pdb_db.pdb_proj.domainMongo.recenzia_kostymMongo;

import com.pdb_db.pdb_proj.domainMongo.doplnokMongo.DoplnokM;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecenziaKostymRepositoryM extends MongoRepository<RecenziaKostymM,Integer> {
}
