package com.pdb_db.pdb_proj.domain.kostym;

import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import com.pdb_db.pdb_proj.domain.doplnok.DoplnokRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.List;

@Configuration
public class KostymConfig
{
    @Bean
    CommandLineRunner commandLineRunnerKostym(KostymRepository repository)
    {
        return args -> {
            Kostym pastier =  new  Kostym(1,"Pastier", "kostym","bavlna", "muzske", 40, new Date(System.currentTimeMillis()));
            Kostym anjel =  new  Kostym(2,"Anjel", "kostym", "saten", "zenske", 36, new Date(System.currentTimeMillis()));

            repository.saveAll(
                    List.of(pastier,anjel)
            );
        };
    }
}



