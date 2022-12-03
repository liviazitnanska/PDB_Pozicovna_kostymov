package com.pdb_db.pdb_proj.domain.kostym_rezervacia;

import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import com.pdb_db.pdb_proj.domain.doplnok.DoplnokRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;

@Configuration
public class KostymRezervaciaConfig {

    @Bean
    CommandLineRunner commandLineRunnerKostymRezervacia(KostymRezervaciaRepository repository)
    {
        return args -> {
            KostymRezervacia jedna =  new KostymRezervacia(1,1,1,1);
            KostymRezervacia dva =  new KostymRezervacia(2,2,2,2);
            repository.saveAll(
                    List.of(jedna,dva)
            );
        };
    }

}
