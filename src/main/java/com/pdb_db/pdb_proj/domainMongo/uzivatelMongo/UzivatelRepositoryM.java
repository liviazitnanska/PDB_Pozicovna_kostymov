package com.pdb_db.pdb_proj.domainMongo.uzivatelMongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UzivatelRepositoryM extends MongoRepository<UzivatelM,Integer>
{
   /* Optional<UzivatelM> findUzivatelMById(Integer id);
    Optional<UzivatelM> findUzivatelMByEmail(String email);

    UzivatelM findUzivatelMByByCislodomuAndMestoAndStatAndUlicaAndPsc(
            Integer cislodomu,
            String mesto,
            String stat,
            String ulica,
            Integer psc);

    List<UzivatelM> findAllByCislodomuAndMestoAndStatAndUlicaAndPsc(
            Integer cislodomu,
            String mesto,
            String stat,
            String ulica,
            Integer psc);

    */

}
