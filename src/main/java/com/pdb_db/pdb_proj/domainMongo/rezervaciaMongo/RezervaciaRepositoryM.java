package com.pdb_db.pdb_proj.domainMongo.rezervaciaMongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RezervaciaRepositoryM extends MongoRepository<RezervaciaM,Integer>
{
    //List<RezervaciaM> findAllByVratenieContaining() TODO

   // List<RezervaciaM> findAllbyVratenie(Integer vratenie);

    //Optional<RezervaciaM> findRezervaciaMById(Integer id);



}
