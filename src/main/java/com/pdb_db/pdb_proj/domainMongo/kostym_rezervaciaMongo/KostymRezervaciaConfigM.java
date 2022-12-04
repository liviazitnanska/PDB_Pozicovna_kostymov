package com.pdb_db.pdb_proj.domainMongo.kostym_rezervaciaMongo;

import com.pdb_db.pdb_proj.domain.kostym_rezervacia.KostymRezervacia;
import com.pdb_db.pdb_proj.domain.kostym_rezervacia.KostymRezervaciaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.List;

@Configuration
public class KostymRezervaciaConfigM {

    @Bean
    CommandLineRunner commandLineRunnerKostymRezervaciaM(KostymRezervaciaRepositoryM repository)
    {
        return args -> {
            KostymRezervaciaM jedna =  new KostymRezervaciaM(
                    1,
                    1,
                    1,
                    new java.util.Date(118,Calendar.JUNE,1),
                    new java.util.Date(118,Calendar.AUGUST,8),
                    1);
            KostymRezervaciaM dva =  new KostymRezervaciaM(
                    2,
                    2,
                    2,
                    new java.util.Date(119, Calendar.JULY,5),
                    new java.util.Date(119,Calendar.SEPTEMBER,15),
                    1
            );
            repository.save(jedna);
            repository.save(dva);
        };
    }
}
