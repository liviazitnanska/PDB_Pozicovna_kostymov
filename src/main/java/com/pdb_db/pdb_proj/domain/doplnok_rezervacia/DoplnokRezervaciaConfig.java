package com.pdb_db.pdb_proj.domain.doplnok_rezervacia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DoplnokRezervaciaConfig {

    @Bean
    CommandLineRunner commandLineRunnerDoplnokRezervacia(DoplnokRezervaciaRepository repository)
    {
        return args -> {
            DoplnokRezervacia jedna = new DoplnokRezervacia(1,1,1);
            DoplnokRezervacia dva = new DoplnokRezervacia(2,2,1);
            repository.saveAll(
                    List.of(jedna,dva)
            );
        };
    }
}
