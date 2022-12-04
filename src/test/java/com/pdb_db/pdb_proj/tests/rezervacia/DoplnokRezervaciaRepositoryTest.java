package com.pdb_db.pdb_proj.tests.rezervacia;

import com.pdb_db.pdb_proj.domain.doplnok_rezervacia.DoplnokRezervacia;
import com.pdb_db.pdb_proj.domain.doplnok_rezervacia.DoplnokRezervaciaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class DoplnokRezervaciaRepositoryTest
{
    @Autowired
    DoplnokRezervaciaRepository repository;

    @Test
    void create_rezervacia_no_user()
    {

        DoplnokRezervacia r = new DoplnokRezervacia(2,1,new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),0);
        repository.save(r);

        boolean exists = false;
        if(repository.findById(r.getId()).isPresent())
            exists = true;

        assertThat(exists).isTrue();
    }

    @Test
    void get_all_reservations()
    {
        List<DoplnokRezervacia> list = repository.findAll();

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
        DoplnokRezervacia r = repository.findById(1).get();

        boolean exists = repository.findUzivatelById(r.getUzivid()).isPresent();
        assertThat(exists).isTrue();

        exists = false;

    }
}
