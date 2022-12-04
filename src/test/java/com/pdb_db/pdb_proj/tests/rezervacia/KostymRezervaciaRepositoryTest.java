package com.pdb_db.pdb_proj.tests.rezervacia;

import com.pdb_db.pdb_proj.domain.kostym_rezervacia.KostymRezervacia;
import com.pdb_db.pdb_proj.domain.kostym_rezervacia.KostymRezervaciaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class KostymRezervaciaRepositoryTest
{

    @Autowired
    private KostymRezervaciaRepository repository;

    @Test
    void create_rezervacia_no_user()
    {

        KostymRezervacia r = new KostymRezervacia(1,2, new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),0);
        repository.save(r);

        boolean exists = false;
        if(repository.findById(r.getId()).isPresent())
            exists = true;

        assertThat(exists).isTrue();
    }

    @Test
    void get_all_reservations()
    {
      List<KostymRezervacia> list = repository.findAll();

        AtomicBoolean exists = new AtomicBoolean(false);

       list.forEach(
                l ->
                { if(repository.findById(l.getId()).isPresent())
                    {
                        exists.set(true);}
                    assertThat(exists.get()).isTrue();
                    exists.set(false);
                }
        );
    }

    @Test
    void check_user()
    {
        KostymRezervacia r = repository.findById(1).get();

        boolean exists = repository.findUzivatelById(r.getUzivid()).isPresent();
        assertThat(exists).isTrue();

    }
}
