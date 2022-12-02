package com.pdb_db.pdb_proj.domainMongo.kostymMongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

//@Configuration
public class KostymConfigM
{

   /* @Bean
    CommandLineRunner commandLineRunnerKostymM(KostymRepositoryM repository)
    {
       List<Integer> list1 = new ArrayList<>();
            list1.add(1);list1.add(2);

        return args -> {

            KostymM pastier =  new  KostymM("Pastier", "kostym","bavlna", "muzske", 40, new Date(System.currentTimeMillis()),list1);
            KostymM anjel =  new  KostymM("Anjel", "kostym", "saten", "zenske", 36, new Date(System.currentTimeMillis()),list1);

            repository.saveAll(
                    List.of(pastier,anjel)
            );
        };
    }*/
}
