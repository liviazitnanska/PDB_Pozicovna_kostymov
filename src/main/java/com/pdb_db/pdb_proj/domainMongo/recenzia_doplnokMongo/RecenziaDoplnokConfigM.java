package com.pdb_db.pdb_proj.domainMongo.recenzia_doplnokMongo;
import com.pdb_db.pdb_proj.domain.recenzia_doplnok.RecenziaDoplnok;
import com.pdb_db.pdb_proj.domain.recenzia_doplnok.RecenziaDoplnokRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//@Configuration
public class RecenziaDoplnokConfigM
{

   /* @Bean
    CommandLineRunner commandLineRunnerRecenziaDoplnok(
            RecenziaDoplnokRepositoryM repository
    ){
        return args -> {
            RecenziaDoplnokM Rec4 = new RecenziaDoplnokM("Spokojny s doplnkom", "Super", 1,0);
            RecenziaDoplnokM Rec5 = new RecenziaDoplnokM("Vyborny doplnok", "Krasne", 4,1);

            repository.saveAll(List.of(Rec4, Rec5));
        };
    }*/
}
