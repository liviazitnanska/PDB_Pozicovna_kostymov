package com.pdb_db.pdb_proj.domainMongo.recenzia_kostymMongo;

import com.pdb_db.pdb_proj.domain.recenzia_kostym.RecenziaKostym;
import com.pdb_db.pdb_proj.domain.recenzia_kostym.RecenziaKostymRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RecenziaKostymConfigM {
    @Bean
    CommandLineRunner commandLineRunnerRecenziaKostymM(
            RecenziaKostymRepositoryM repository
    ){
        return args -> {
            RecenziaKostymM Rec4 = new RecenziaKostymM(1,"Tento kostym je super darcek", "Super kostym", 1,2,1,1);
            RecenziaKostymM Rec5 = new RecenziaKostymM(2,"Spokojna s kostymom", "Krasny kostym", 10,3,2,2);

            repository.save(Rec4);
            repository.save(Rec5);
        };
    }
}
