package com.pdb_db.pdb_proj.tests.sortiment;

import com.pdb_db.pdb_proj.domain.kostym.Kostym;
import com.pdb_db.pdb_proj.domain.kostym.KostymRepository;
import com.pdb_db.pdb_proj.domain.kostym.KostymService;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class KostymTest
{
    @Autowired
    private KostymRepository repository;

    @Autowired
    private KostymService service;

    @Test
    @Order(1)
    void create_costume()
    {
        String nazov = "saty";

        Kostym k =  new  Kostym(nazov, "kostym","saten", "zenske", 40, new Date(System.currentTimeMillis()));
        service.addNewKostym(k);

        boolean exists = false;
        if(repository.findKostymByNazov(nazov).isPresent())
            exists = true;

        assertThat(exists).isTrue();
    }

    @Test
    @Order(2)
    void get_all_costumes()
    {
        List<Kostym> list = service.getKostymy();
        AtomicBoolean exists = new AtomicBoolean(false);

        list.forEach(l ->
        {
            if(repository.findKostymByNazov(l.getNazov()).isPresent())
                exists.set(true);
            assertThat(exists.get()).isTrue();
            exists.set(false);
        });
    }

    @Test
    @Order(3)
    void get_all_costumes_by_material()
    {
        String material = "saten";

        List<Kostym> list = service.get_Kostymy_by_material(material);

        AtomicBoolean exists = new AtomicBoolean(false);

        list.forEach(l ->
        {
            if(l.getMaterial().equals(material))
                exists.set(true);
            assertThat(exists.get()).isTrue();
            exists.set(false);
        });
    }

    @Test
    @Order(4)
    void update_costume()
    {
        String nazov = "saty";
        String popis = "novy popis";
        String material = "brokat";

        Kostym k = new Kostym();
        boolean exist = false;

        if (service.getKostymByNazov(nazov).isPresent())
        {
            k = service.getKostymByNazov(nazov).get();
            exist = true;
        }
        assertThat(exist).isTrue();

        //Kostym update
        service.updateKostym(k.getId(),null,popis,material,null,34,null);

        //Kostym is updated
        assertThat(service.getKostymById(k.getId()).getNazov().equals(nazov)).isTrue();
        assertThat(service.getKostymById(k.getId()).getMaterial().equals(material)).isTrue();
        assertThat(service.getKostymById(k.getId()).getPopis().equals(popis)).isTrue();
        assertThat(service.getKostymById(k.getId()).getVelkost().equals(40)).isFalse();
    }

    @Test
    @Order(5)
    void get_concrete_costume()
    {
        String nazov = "saty";
        Kostym k = new Kostym();

        //Kostym exists by name
        boolean exists = false;
        if(repository.findKostymByNazov(nazov).isPresent())
        {
            exists = true;
            k = repository.findKostymByNazov(nazov).get();
        }
        assertThat(exists).isTrue();

        //Kostym exists by id
        exists = false;
        if(repository.findById(k.getId()).isPresent())
            exists = true;

        assertThat(exists).isTrue();

    }

    @Test
    @Order(6)
    void delete_costume()
    {
        String nazov = "saty";
        boolean exist = false;

        //Kostym still exists
        Kostym k = new Kostym();

        if (service.getKostymByNazov(nazov).isPresent())
        {
            k = service.getKostymByNazov(nazov).get();
            exist = true;
        }
        assertThat(exist).isTrue();

        Integer id = k.getId();

        //Delete kostym
        service.deleteKostym(k.getId());

        //Kostym no longer exists
        exist = false;
        if(repository.findKostymByNazov(nazov).isPresent())
            exist = true;
        assertThat(exist).isFalse();
    }
}
