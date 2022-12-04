package com.pdb_db.pdb_proj.domain.doplnok;
import com.pdb_db.pdb_proj.domainMongo.doplnokMongo.DoplnokM;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.List;

@Configuration
public class DoplnokConfig {

    @Bean
    CommandLineRunner commandLineRunnerDoplnok(DoplnokRepository repository)
    {
        return args -> {
            Doplnok palica =  new Doplnok (
                    1,
                    "Palica",
                    "doplnok",
                    "drevo",
                    "muzske",
                    new java.util.Date(121, Calendar.AUGUST,6)
            );

            Doplnok kridla = new Doplnok (
                    2,
                    "Krídla",
                    "doplnok",
                    "paperie",
                    "zenske",
                    new java.util.Date(119, Calendar.JANUARY,6));

            repository.saveAll(
                    List.of(palica,kridla)
            );
        };
    }
}
