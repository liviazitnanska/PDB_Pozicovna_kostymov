package com.pdb_db.pdb_proj.tests.recenzia;

import com.pdb_db.pdb_proj.domain.recenzia_doplnok.RecenziaDoplnok;
import com.pdb_db.pdb_proj.domain.recenzia_doplnok.RecenziaDoplnokRepository;
import com.pdb_db.pdb_proj.domain.recenzia_doplnok.RecenziaDoplnokService;
import com.pdb_db.pdb_proj.domain.recenzia_kostym.RecenziaKostym;
import com.pdb_db.pdb_proj.domain.recenzia_kostym.RecenziaKostymRepository;
import com.pdb_db.pdb_proj.domain.recenzia_kostym.RecenziaKostymService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DoplnokRecenziaTest
{
    @Autowired
    private RecenziaDoplnokRepository repository;

    @Autowired
    private RecenziaDoplnokService service;


    @Test
    @Order(1)
    void create_review()
    {
        RecenziaDoplnok r = new RecenziaDoplnok("Strasne super","Na jednotku",0,0,1,1);
        service.addNewRecenziaDoplnok(r);

        boolean exists = false;
        if(repository.findById(r.getId()).isPresent())
            exists = true;

        assertThat(exists).isTrue();
    }

    @Test
    @Order(2)
    void add_like_to_review ()
    {
        Integer id =3;

        boolean exists = false;
        if(repository.findById(id).isPresent())
            exists = true;

        assertThat(exists).isTrue();

        RecenziaDoplnok r = repository.findById(id).get();
        service.updateRecenziaDoplnok(id,null,null,1,null,null,null);

        r = repository.findById(id).get();
        assertThat(r.getSuhlas().equals(1)).isTrue();
        assertThat(r.getNesuhlas().equals(0)).isTrue();
    }

    @Test
    @Order(3)
    void clear_like_to_review()
    {
        Integer id =3;

        boolean exists = false;
        if(repository.findById(id).isPresent())
            exists = true;

        assertThat(exists).isTrue();

        RecenziaDoplnok r = repository.findById(id).get();
        service.updateRecenziaDoplnok(id,null,null,0,null,null,null);

        r = repository.findById(id).get();
        assertThat(r.getSuhlas().equals(0)).isTrue();
        assertThat(r.getNesuhlas().equals(0)).isTrue();
    }

    @Test
    @Order(4)
    void update_review()
    {
        Integer id =3;
        String popis = "novy popis";

        boolean exists = false;
        if(repository.findById(id).isPresent())
            exists = true;

        assertThat(exists).isTrue();

        RecenziaDoplnok r = repository.findById(id).get();
        service.updateRecenziaDoplnok(id,null,popis,null,3,null,null);

        r = repository.findById(id).get();
        assertThat(r.getPopis().equals(popis)).isTrue();
        assertThat(r.getPopis().equals("Na jednotku")).isFalse();
    }

    @Test
    @Order(5)
    void delete_review()
    {
        Integer id =3;

        boolean exists = false;
        if(repository.findById(id).isPresent())
            exists = true;

        assertThat(exists).isTrue();

        service.deleteRecenziaDoplnok(id);

        exists = false;
        if(repository.findById(id).isPresent())
            exists = true;
        assertThat(exists).isFalse();
    }

}
