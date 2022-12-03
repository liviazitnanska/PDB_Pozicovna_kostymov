package com.pdb_db.pdb_proj.domainMongo.kostym_rezervaciaMongo;

import com.pdb_db.pdb_proj.domainMongo.recenzia_doplnokMongo.RecenziaDoplnokM;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KostymRezervaciaRepositoryM  extends MongoRepository<KostymRezervaciaM,Integer> {
}
