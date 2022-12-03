package com.pdb_db.pdb_proj.tests.recenzia;

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
public class KostymRecenziaTest
{

    @Autowired
    private RecenziaKostymRepository repository;

    @Autowired
    private RecenziaKostymService service;


    @Test
    @Order(1)
    void create_review()
    {
        RecenziaKostym r = new RecenziaKostym("Strasne super","Na jednotku",0,0,1,1);
        service.addNewRecenziaKostym(r);

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

        RecenziaKostym r = repository.findById(id).get();
        service.updateRecenziaKostym(id,null,null,1,null,null,null);

        r = repository.findById(id).get();
        System.out.println("HALOOOOOOOOOOOO");
        System.err.println("LIVUUUS");
        System.err.println(r.getSuhlas());

        assertThat(r.getSuhlas() == 1).isTrue();
        assertThat(r.getNesuhlas() == 0).isTrue();

    }

    @Test
    @Order(3)
    void clear_like_to_review()
    {
        Integer id =1;

        boolean exists = false;
        if(repository.findById(id).isPresent())
            exists = true;

        assertThat(exists).isTrue();

        RecenziaKostym r = repository.findById(id).get();
        service.updateRecenziaKostym(id,null,null,0,null,null,null);

        r = repository.findById(id).get();
        assertThat(r.getSuhlas() == 0).isTrue();
    }

    @Test
    @Order(4)
    void update_review()
    {
        Integer id =1;
        String popis = "novy popis";

        boolean exists = false;
        if(repository.findById(id).isPresent())
            exists = true;

        assertThat(exists).isTrue();

        RecenziaKostym r = repository.findById(id).get();
        service.updateRecenziaKostym(id,null,popis,null,3,null,null);

        r = repository.findById(id).get();
        assertThat(r.getPopis().equals(popis)).isTrue();
        assertThat(r.getPopis().equals("Na jednotku")).isFalse();
    }


    @Test
    @Order(5)
    void delete_review()
    {
        Integer id =1;

        boolean exists = false;
        if(repository.findById(id).isPresent())
            exists = true;

        assertThat(exists).isTrue();

        service.deleteRecenziaKostym(id);

        exists = false;
        if(repository.findById(id).isPresent())
            exists = true;
        assertThat(exists).isFalse();

    }
}
