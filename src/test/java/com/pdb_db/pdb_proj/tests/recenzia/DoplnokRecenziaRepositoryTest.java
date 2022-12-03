package com.pdb_db.pdb_proj.tests.recenzia;

import com.pdb_db.pdb_proj.domain.doplnok.DoplnokRepository;
import com.pdb_db.pdb_proj.domain.recenzia_doplnok.RecenziaDoplnok;
import com.pdb_db.pdb_proj.domain.recenzia_doplnok.RecenziaDoplnokRepository;
import com.pdb_db.pdb_proj.domain.rezervacia.Rezervacia;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@SpringBootTest
public class DoplnokRecenziaRepositoryTest
{

    @Autowired
    private RecenziaDoplnokRepository repository;

    Integer uzivID = 1;
    Integer uzivID2 = 15;
    Integer doplnokID = 2;
    Integer doplnokID2 = 5;

    @Test
    void create_doplnok_recenzia()
    {

        RecenziaDoplnok r = new RecenziaDoplnok("Strasne super","Na jednotku",0,0,uzivID,doplnokID);
        repository.save(r);

        boolean exists = false;
        if(repository.findById(r.getId()).isPresent())
            exists = true;

        assertThat(exists).isTrue();
    }

    @Test
    void check_uzivId()
    {
        boolean exists = false;
        if(repository.findUzivatelById(uzivID).isPresent())
            exists = true;

        assertThat(exists).isTrue();

        exists = false;
        if(repository.findUzivatelById(uzivID2).isPresent())
            exists = true;
        assertThat(exists).isFalse();
   }

    @Test
    void check_doplnokId()
    {
        boolean exists = false;
        if(repository.findDoplnokById(doplnokID).isPresent())
            exists = true;

        assertThat(exists).isTrue();

        exists = false;
        if(repository.findDoplnokById(doplnokID2).isPresent())
            exists = true;
        assertThat(exists).isFalse();
    }

}
