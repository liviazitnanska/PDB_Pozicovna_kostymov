package com.pdb_db.pdb_proj.tests.sortiment;

import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import com.pdb_db.pdb_proj.domain.doplnok.DoplnokRepository;
import com.pdb_db.pdb_proj.domain.kostym.Kostym;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import com.pdb_db.pdb_proj.domain.uzivatel.UzivatelRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class DoplnokRepositoryTest
{
    @Autowired
    private DoplnokRepository repository;

    @Test
    void create_doplnok()
    {
        String nazov = "hreben";

        Doplnok d = new Doplnok(nazov,"jeden","plast","male",new Date(System.currentTimeMillis()));
        repository.save(d);

        boolean exists = false;
        if(repository.findDoplnokByNazov(nazov).isPresent())
            exists = true;

        assertThat(exists).isTrue();
    }

    @Test
    void no_doplnok_with_name()
    {
        String nazov = "aaa";

        boolean exists = false;
        if(repository.findDoplnokByNazov(nazov).isPresent())
            exists = true;

        assertThat(exists).isFalse();
    }

    @Test
    void doplnok_by_material()
    {
        String material = "saten";

        List<Doplnok> list = repository.findAllByMaterial(material);
        AtomicBoolean exists = new AtomicBoolean(false);

        list.forEach(
                l->
                {
                    if(l.getMaterial().equals(material))
                        exists.set(true);
                    assertThat(exists.get()).isTrue();
                    exists.set(false);
                }
        );
    }
}
