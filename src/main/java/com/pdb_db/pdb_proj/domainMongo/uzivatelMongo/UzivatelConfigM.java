package com.pdb_db.pdb_proj.domainMongo.uzivatelMongo;

import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import com.pdb_db.pdb_proj.domain.uzivatel.UzivatelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UzivatelConfigM
{
    @Bean
    CommandLineRunner commandLineRunnerUzivatelM(
            UzivatelRepositoryM uzivatelRepositoryM
    ){
        return args -> {
            UzivatelM Rec4 = new UzivatelM(
                    1,
                    "Meno1",
                    "Priezvisko1",
                    "email@email.com",
                    "+421123123132",
                    "Slovensko",
                    "Bánska Bystrica",
                    "Ulica SNP",
                    12,
                    94945);
            UzivatelM Rec5 = new UzivatelM(
                    2,
                    "Meno2",
                    "Priezvisko2",
                    "email2@email.com",
                    "+421789789798",
                    "Slovensko",
                    "Trenčín",
                    "Ulica ulice",
                    57,
                    92214);


            uzivatelRepositoryM.save(Rec4);
            uzivatelRepositoryM.save(Rec5);
        };
    }
}
