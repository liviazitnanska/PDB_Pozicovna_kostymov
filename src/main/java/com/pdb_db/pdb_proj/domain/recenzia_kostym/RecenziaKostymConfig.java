package com.pdb_db.pdb_proj.domain.recenzia_kostym;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RecenziaKostymConfig {

    @Bean
    CommandLineRunner commandLineRunnerRecenziaKostym(
            RecenziaKostymRepository repository
    ){
        return args -> {
            RecenziaKostym Rec4 = new RecenziaKostym(1,"Tento kostym je super darcek", "Super kostym", 1,2,1,1);
            RecenziaKostym Rec5 = new RecenziaKostym(2,"Spokojna s kostymom", "Krasny kostym", 10,3,2,2);

            repository.saveAll(List.of(Rec4, Rec5));
        };
    }
}
