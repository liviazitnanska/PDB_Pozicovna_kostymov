package com.pdb_db.pdb_proj.domainMongo.doplnokMongo;

import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Configuration
public class DoplnokConfigM
{
    @Bean
    CommandLineRunner commandLineRunnerDoplnokM(DoplnokRepositoryM repository)
    {
        return args -> {
            DoplnokM palica =  new DoplnokM (
                    1,
                    "Palica",
                    "doplnok",
                    "drevo",
                    "muzske",
                    new java.util.Date(121, Calendar.AUGUST,6)
            );

            DoplnokM kridla = new DoplnokM (
                    2,
                    "Krídla",
                    "doplnok",
                    "paperie",
                    "zenske",
                    new java.util.Date(119, Calendar.JANUARY,6));

            repository.save(palica);
            repository.save(kridla);
        };
    }
}
