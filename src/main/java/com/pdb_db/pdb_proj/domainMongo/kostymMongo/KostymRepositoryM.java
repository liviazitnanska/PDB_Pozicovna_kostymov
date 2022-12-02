package com.pdb_db.pdb_proj.domainMongo.kostymMongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface KostymRepositoryM extends MongoRepository<KostymM,Integer>
{

    //Optional<KostymM> findKostymMByNazov(String nazov);

  //  Optional<KostymM> findKostymMById(Integer id);
    //NECHAJ ZAKOMENTOVANE Optional<List<KostymM>> findAllByKategoria(String kategoria);
   // List<KostymM> findAllByKategoria(String kategoria);
  //List<KostymM> findAllByMaterial(String material);

}
