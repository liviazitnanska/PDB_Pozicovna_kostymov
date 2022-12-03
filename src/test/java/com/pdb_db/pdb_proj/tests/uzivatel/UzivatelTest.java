package com.pdb_db.pdb_proj.tests.uzivatel;

import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import com.pdb_db.pdb_proj.domain.uzivatel.UzivatelRepository;
import com.pdb_db.pdb_proj.domain.uzivatel.UzivatelService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UzivatelTest
{
    @Autowired
    private UzivatelRepository repository;

    @Autowired
    private UzivatelService service;


    @Test
    @Order(1)
    void create_uzivatel()
    {
        Uzivatel uzivatel = new Uzivatel("Jarka","Mala","jarina@pdb.com","0911234567","Slovensko","Nitra", "Nabrezna", 9,91423);
        service.addNewUzivatel(uzivatel);

        boolean exists = false;
        if(repository.findUzivatelByEmail(uzivatel.getEmail()).isPresent())
            exists = true;

        assertThat(exists).isTrue();
    }

    @Test
    @Order(2)
    void get_all_users()
    {
         List<Uzivatel> list = service.getUzivatel();
        AtomicBoolean exists = new AtomicBoolean(false);

         list.forEach(l ->
         {
             if(repository.findUzivatelByEmail(l.getEmail()).isPresent())
                 exists.set(true);
                 assertThat(exists.get()).isTrue();
                exists.set(false);
         });
    }

    @Test
    @Order(3)
    void get_uzivatel()
    {
        String email = "jarina@pdb.com";
        String meno = "Jarka";
        String priezvisko = "Mala";
        String stat = "Slovensko";
        String mesto = "Nitra";

        Uzivatel u = repository.findUzivatelByEmail(email).get();

        assertThat(u.getEmail().equals(email)).isTrue();
        assertThat(u.getMeno().equals(meno)).isTrue();
        assertThat(u.getPriezvisko().equals(priezvisko)).isTrue();
        assertThat(u.getStat().equals(stat)).isTrue();
        assertThat(u.getMesto().equals(mesto)).isTrue();

    }

    @Test
    @Order(4)
    void change_user()
    {
        String email = "jarina@pdb.com";
        String meno = "Jarka Amelia";
        String priezvisko = "Mala";
        String stat = "Maďarsko";
        Integer cisloDomu = 532;

        Uzivatel u = repository.findUzivatelByEmail(email).get();

        service.updateUzivatel(u.getId(),meno,null,null,null,null,null,null,null,null);
        service.updateUzivatel(u.getId(),null,priezvisko,null,null,stat,null,null,null,null);
        service.updateUzivatel(u.getId(),null,null,null,null,null,null,null,cisloDomu,null);

        u = repository.findUzivatelByEmail(email).get();

        assertThat(u.getEmail().equals(email)).isTrue();
        assertThat(u.getMeno().equals(meno)).isTrue();
        assertThat(u.getPriezvisko().equals(priezvisko)).isTrue();
        assertThat(u.getStat().equals(stat)).isTrue();
        assertThat(u.getCislodomu().equals(cisloDomu)).isTrue();

        assertThat(u.getMeno().equals("Jarka")).isFalse();
        assertThat(u.getStat().equals("Slovensko")).isFalse();

    }

    @Test
    @Order(5)
    void delete_user()
    {
        String email = "jarina@pdb.com";
        boolean exists = false;
        Uzivatel u = new Uzivatel();

        if(repository.findUzivatelByEmail(email).isPresent())
        {  exists = true;
          u = repository.findUzivatelByEmail(email).get();
        }
        assertThat(exists).isTrue();

        exists = false;
        service.deleteUzivatel(u.getId());
        if(repository.findUzivatelByEmail(u.getEmail()).isPresent())
            exists = true;
        assertThat(exists).isFalse();
    }
}
