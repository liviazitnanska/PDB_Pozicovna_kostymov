package com.pdb_db.pdb_proj.domain.uzivatel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UzivatelConfig {

    @Bean
    CommandLineRunner commandLineRunnerUzivatel(
            UzivatelRepository repository
    ){
        return args -> {
            Uzivatel Rec4 = new Uzivatel(1,
                    "Meno1",
                    "Priezvisko1",
                    "email@email.com",
                    "+421123123132",
                    "Slovensko",
                    "Bánska Bystrica",
                    "Ulica SNP",
                    12,
                    94945);
            Uzivatel Rec5 = new Uzivatel(2,
                    "Meno2",
                    "Priezvisko2",
                    "email2@email.com",
                    "+421789789798",
                    "Slovensko",
                    "Trenčín",
                    "Ulica ulice",
                    57,
                    92214);

            repository.saveAll(List.of(Rec4, Rec5));
        };
    }

}
