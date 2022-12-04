package com.pdb_db.pdb_proj.domainMongo.doplnok_rezervaciaMongo;

import com.pdb_db.pdb_proj.domain.doplnok_rezervacia.DoplnokRezervacia;
import com.pdb_db.pdb_proj.domain.doplnok_rezervacia.DoplnokRezervaciaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.List;

@Configuration
public class DoplnokRezervaciaConfigM {
    @Bean
    CommandLineRunner commandLineRunnerDoplnokRezervaciaM(DoplnokRezervaciaRepositoryM repository)
    {
        return args -> {
            DoplnokRezervaciaM jedna = new DoplnokRezervaciaM(
                    1,
                    1,
                    1,
                    new java.util.Date(120, Calendar.APRIL,6),
                    new java.util.Date(120, Calendar.JULY,15),
                    1);
            DoplnokRezervaciaM dva = new DoplnokRezervaciaM(
                    2,
                    2,
                    2,
                    new java.util.Date(120,Calendar.OCTOBER,7),
                    new java.util.Date(120,Calendar.NOVEMBER,20),
                    1);
            repository.save(jedna);
            repository.save(dva);
        };
    }
}
