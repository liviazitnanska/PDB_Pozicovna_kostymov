package com.pdb_db.pdb_proj.domainMongo.kostymMongo;

import com.pdb_db.pdb_proj.domain.kostym.Kostym;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Configuration
public class KostymConfigM
{

    @Bean
    CommandLineRunner commandLineRunnerKostymM(KostymRepositoryM repository)
    {

        return args -> {
            KostymM pastier = new KostymM(
                    1,
                    "Pastier",
                    "kostym",
                    "bavlna",
                    "muzske",
                    40,
                    new java.util.Date(122,Calendar.MARCH,1));

            KostymM anjel = new KostymM(
                    2,
                    "Anjel",
                    "kostym",
                    "saten",
                    "zenske",
                    36 ,
                    new java.util.Date(121, Calendar.JANUARY,1));


            repository.save(pastier);
            repository.save(anjel);
        };
    }
}
