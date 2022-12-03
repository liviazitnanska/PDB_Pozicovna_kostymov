package com.pdb_db.pdb_proj.domain.rezervacia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

@Configuration
public class RezervaciaConfig {

    @Bean
    CommandLineRunner commandLineRunnerRezervacia(
            RezervaciaRepository repository
    ){
        return args -> {
            Rezervacia Rec4 = new Rezervacia(
                    new Date(System.currentTimeMillis()),
                    new Date(System.currentTimeMillis()),
                    1,
                    1);
            Rezervacia Rec5 = new Rezervacia(
                    new Date(System.currentTimeMillis()),
                    new Date(System.currentTimeMillis()),
                    1,
                    2);

            repository.saveAll(List.of(Rec4, Rec5));
        };
    }


}
