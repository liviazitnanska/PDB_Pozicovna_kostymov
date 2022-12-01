package com.pdb_db.pdb_proj.domain.rezervacia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class RezervaciaConfig {

    @Bean
    CommandLineRunner commandLineRunnerRezervacia(
            RezervaciaRepository repository
    ){
        return args -> {
            Rezervacia Rec4 = new Rezervacia(1,
                    LocalDate.of(2020, Month.JANUARY, 15),
                    LocalDate.of(2020, Month.JANUARY, 25),
                    1,
                    1);
            Rezervacia Rec5 = new Rezervacia(2,
                    LocalDate.of(2020, Month.MARCH, 7),
                    LocalDate.of(2020, Month.MARCH, 17),
                    1,
                    2);

            repository.saveAll(List.of(Rec4, Rec5));
        };
    }


}
