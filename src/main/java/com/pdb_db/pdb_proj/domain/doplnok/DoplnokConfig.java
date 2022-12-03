package com.pdb_db.pdb_proj.domain.doplnok;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.List;

@Configuration
public class DoplnokConfig {

    @Bean
    CommandLineRunner commandLineRunnerDoplnok(DoplnokRepository repository)
    {
        return args -> {
            Doplnok palica =  new Doplnok
                    (1,"Palica", "doplnok", "plast", "muzske", new Date(System.currentTimeMillis())
                    );
            Doplnok kridla = new Doplnok (2,"Krídla", "doplnok", "paperie", "zenske", new Date(System.currentTimeMillis()));

            repository.saveAll(
                    List.of(palica,kridla)
            );
        };
    }
}
