package com.pdb_db.pdb_proj.domain.kostym_rezervacia;

import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import com.pdb_db.pdb_proj.domain.doplnok.DoplnokRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Calendar;
import java.util.List;

@Configuration
public class KostymRezervaciaConfig {

    @Bean
    CommandLineRunner commandLineRunnerKostymRezervacia(KostymRezervaciaRepository repository)
    {
        return args -> {
            KostymRezervacia jedna =  new KostymRezervacia(1,
                    1,
                    1,
                    new java.util.Date(118, Calendar.JUNE,1),
                    new java.util.Date(118,Calendar.AUGUST,8),
                    1);
            KostymRezervacia dva =  new KostymRezervacia(2,
                    2,
                    2,
                    new java.util.Date(119, Calendar.JULY,5),
                    new java.util.Date(119,Calendar.SEPTEMBER,15),
                    1
            );
            repository.saveAll(
                    List.of(jedna,dva)
            );
        };
    }

}
