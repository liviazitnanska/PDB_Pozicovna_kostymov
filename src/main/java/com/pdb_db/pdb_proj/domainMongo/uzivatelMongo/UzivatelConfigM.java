package com.pdb_db.pdb_proj.domainMongo.uzivatelMongo;

import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import com.pdb_db.pdb_proj.domain.uzivatel.UzivatelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class UzivatelConfigM
{
    /*@Bean
    CommandLineRunner commandLineRunnerUzivatelM(
            UzivatelRepositoryM repository
    ){
        List<String> wishist = new ArrayList<>();
        wishist.add("Wish1");
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);


        return args -> {
            UzivatelM Rec4 = new UzivatelM(
                    "Meno1",
                    "Priezvisko1",
                    "email@email.com",
                    "+421123123132",
                    "Slovensko",
                    "Bánska Bystrica",
                    "Ulica SNP",
                    12,
                    94945,
                    wishist,list1,list1);
            UzivatelM Rec5 = new UzivatelM(
                    "Meno2",
                    "Priezvisko2",
                    "email2@email.com",
                    "+421789789798",
                    "Slovensko",
                    "Trenčín",
                    "Ulica ulice",
                    57,
                    92214
            ,wishist,list1,list1);

            repository.saveAll(List.of(Rec4, Rec5));
        };
    }*/
}
