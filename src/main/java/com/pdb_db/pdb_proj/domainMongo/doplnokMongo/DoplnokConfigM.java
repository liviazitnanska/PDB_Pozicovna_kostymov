package com.pdb_db.pdb_proj.domainMongo.doplnokMongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

//@Configuration
public class DoplnokConfigM
{

    /*@Bean
    CommandLineRunner commandLineRunnerDoplnokM(DoplnokRepositoryM repository)
    {
        return args -> {
            List<Integer> list1 = new ArrayList<>();
            list1.add(1);list1.add(2);
            DoplnokM palica =  new DoplnokM
                    ("Palica", "doplnok", "drevo", "muzske", new Date(System.currentTimeMillis()),list1);
            DoplnokM kridla = new DoplnokM ("Krídla", "doplnok", "paperie", "zenske", new Date(System.currentTimeMillis()),list1);

            repository.saveAll(
                    List.of(palica,kridla)
            );
        };
    }*/
}
