package com.pdb_db.pdb_proj.domainMongo.rezervaciaMongo;

import com.pdb_db.pdb_proj.domain.rezervacia.Rezervacia;
import com.pdb_db.pdb_proj.domain.rezervacia.RezervaciaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Configuration
public class RezervaciaConfigM
{

    /*@Bean
    CommandLineRunner commandLineRunnerRezervacia(
            RezervaciaRepositoryM repository
    ){
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);

        return args -> {
            RezervaciaM Rec4 = new RezervaciaM(
                    new Date(System.currentTimeMillis()),
                    new Date(System.currentTimeMillis()),
                    1,
                    list1,list1);
            RezervaciaM Rec5 = new RezervaciaM(new Date(System.currentTimeMillis()),
                    new Date(System.currentTimeMillis()),
                    1, list1,list1);

            repository.saveAll(List.of(Rec4, Rec5));
        };
    }*/
}
