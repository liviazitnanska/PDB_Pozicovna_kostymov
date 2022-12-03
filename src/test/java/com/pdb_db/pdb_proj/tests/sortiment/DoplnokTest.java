package com.pdb_db.pdb_proj.tests.sortiment;

import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import com.pdb_db.pdb_proj.domain.doplnok.DoplnokRepository;
import com.pdb_db.pdb_proj.domain.doplnok.DoplnokService;
import com.pdb_db.pdb_proj.domain.kostym.Kostym;
import com.pdb_db.pdb_proj.domain.kostym.KostymRepository;
import com.pdb_db.pdb_proj.domain.kostym.KostymService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DoplnokTest
{

    @Autowired
    private DoplnokRepository repository;

    @Autowired
    private DoplnokService service;

    @Test
    @Order(1)
    void create_accessory()
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
    @Order(2)
    void get_all_accessories()
    {
        List<Doplnok> list = service.getDoplnky();
        AtomicBoolean exists = new AtomicBoolean(false);

        list.forEach(l ->
        {
            if(repository.findDoplnokByNazov(l.getNazov()).isPresent())
                exists.set(true);
            assertThat(exists.get()).isTrue();
            exists.set(false);
        });
    }

    @Test
    @Order(3)
    void get_all_accessories_by_material()
    {
        String material = "plast";

        List<Doplnok> list = service.get_Doplnky_by_material(material);

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
    void update_doplnok()
    {
        String nazov = "hreben";
        String popis = "novy popis";
        String material = "drevo";

        Doplnok d = new Doplnok();
        boolean exist = false;

        if (service.getDoplnokByNazov(nazov).isPresent())
        {
            d = service.getDoplnokByNazov(nazov).get();
            exist = true;
        }
        assertThat(exist).isTrue();

        //Doplnok  update
        service.updateDoplnok(d.getId(),null,popis,material,null,null);

        //Doplnok is updated
        assertThat(service.getDoplnokById(d.getId()).get().getNazov().equals(nazov)).isTrue();
        assertThat(service.getDoplnokById(d.getId()).get().getMaterial().equals(material)).isTrue();
        assertThat(service.getDoplnokById(d.getId()).get().getPopis().equals(popis)).isTrue();
    }


    @Test
    @Order(5)
    void get_concrete_accessory()
    {
        String nazov = "hreben";
        Doplnok d = new Doplnok();

        //Doplnok exists by name
        boolean exists = false;
        if(repository.findDoplnokByNazov(nazov).isPresent())
        {
            exists = true;
            d = repository.findDoplnokByNazov(nazov).get();
        }
        assertThat(exists).isTrue();

        //Doplnok exists by id
        exists = false;
        if(repository.findById(d.getId()).isPresent())
            exists = true;

        assertThat(exists).isTrue();
    }

    @Test
    @Order(6)
    void delete_accessory()
    {
        String nazov = "hreben";
        boolean exist = false;

        //Doplnok still exists
        Doplnok d = new Doplnok();

        if (service.getDoplnokByNazov(nazov).isPresent())
        {
            d = service.getDoplnokByNazov(nazov).get();
            exist = true;
        }
        assertThat(exist).isTrue();

        Integer id = d.getId();

        //Delete kostym
        service.deleteDoplnok(d.getId());

        //Kostym no longer exists
        exist = false;
        if(repository.findDoplnokByNazov(nazov).isPresent())
            exist = true;
        assertThat(exist).isFalse();
    }

}
