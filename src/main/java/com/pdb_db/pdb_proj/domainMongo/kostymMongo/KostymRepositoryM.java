package com.pdb_db.pdb_proj.domainMongo.kostymMongo;

import com.pdb_db.pdb_proj.domainMongo.doplnokMongo.DoplnokM;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KostymRepositoryM extends MongoRepository<KostymM,Integer> {
}
