package com.pdb_db.pdb_proj.tests.rezervacia;

import com.pdb_db.pdb_proj.domain.costume_reservation.CostumeReservation;
import com.pdb_db.pdb_proj.domain.costume_reservation.CostumeReservationRepository;
import com.pdb_db.pdb_proj.domain.costume_reservation.CostumeReservationService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CostumeRezervaciaTest
{
    @Autowired
    CostumeReservationRepository repository;

    @Autowired
    CostumeReservationService service;


    @Test
    @Order(1)
    void create_reservation()
    {
        CostumeReservation r = new CostumeReservation(2,1,new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 1);
        repository.save(r);

        boolean exists = false;
        if(repository.findById(r.getId()).isPresent())
            exists = true;

        assertThat(exists).isTrue();
    }

    @Test
    @Order(2)
    void show_ongoing_reservations()
    {
        Integer id = 3;
        List<CostumeReservation> list = service.getAllOngoing();

        list.forEach( l->
                {
                    assertThat(l.getIsReturned().equals(0)).isTrue();
                }
        );

        assertThat(list.contains(repository.findById(id).get()));
    }

    @Test
    @Order(3)
    void end_reservation()
    {
        Integer id = 3;

        boolean exists = false;
        if(repository.findById(id).isPresent())
            exists = true;

        assertThat(exists).isTrue();

        service.updateKostymRezervacia(id,null,null,null,null,1);

        assertThat( repository.findById(id).get().getIsReturned().equals(1)).isTrue();
    }

    @Test
    @Order(4)
    void show_finished_rservations()
    {
        Integer id = 3;
        List<CostumeReservation> list = service.getAllOngoing();

        list.forEach( l->
                {
                    assertThat(l.getIsReturned().equals(1)).isTrue();
                }
        );
        assertThat(list.contains(repository.findById(id).get()));
    }


    @Test
    @Order(5)
    void delete_reservation()
    {
        Integer id = 3;

        boolean exists = false;
        if(repository.findById(id).isPresent())
            exists = true;

        assertThat(exists).isTrue();

        service.deleteCostumeReservation(id);

        exists = false;
        if(repository.findById(id).isPresent())
            exists = true;

        assertThat(exists).isFalse();
    }
}
