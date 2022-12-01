package com.pdb_db.pdb_proj.domain.recenzia_doplnok;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RecenziaDoplnokConfig {

    @Bean
    CommandLineRunner commandLineRunnerRecenziaDoplnok(
            RecenziaDoplnokRepository repository
    ){
        return args -> {
            RecenziaDoplnok Rec4 = new RecenziaDoplnok(1,"Spokojny s doplnkom", "Super", 1,0,1,1);
            RecenziaDoplnok Rec5 = new RecenziaDoplnok(2,"Vyborny doplnok", "Krasne", 4,1,2,2);

            repository.saveAll(List.of(Rec4, Rec5));
        };
    }

}
