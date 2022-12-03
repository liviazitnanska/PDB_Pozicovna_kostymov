package com.pdb_db.pdb_proj.tests.wish;

import com.pdb_db.pdb_proj.domain.wishlist_doplnok.WishlistDoplnok;
import com.pdb_db.pdb_proj.domain.wishlist_doplnok.WishlistDoplnokRepository;
import com.pdb_db.pdb_proj.domain.wishlist_doplnok.WishlistDoplnokService;
import com.pdb_db.pdb_proj.domain.wishlist_kostym.WishlistKostym;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WishDoplnokTest
{
    @Autowired
    WishlistDoplnokRepository repository;

    @Autowired
    WishlistDoplnokService service;
    @Test
    @Order(1)
    void create_wish()
    {
        WishlistDoplnok w = new WishlistDoplnok("W",2,2);
        service.addNewWishlist(w);

        boolean exists = false;
        if(repository.findById(w.getId()).isPresent())
            exists = true;

        assertThat(exists).isTrue();
    }


    @Test
    @Order(2)
    void update_wish()
    {
        String novy_nazov = "novy nazov";
        String stary_nazov = "W";

        WishlistDoplnok w = new WishlistDoplnok();

        if(service.getWishByName(stary_nazov).isPresent())
        {
            w = service.getWishByName(stary_nazov).get();
        }

        service.updateWishlist(w.getId(),novy_nazov,null,null);
        w = service.getWishByName(novy_nazov).get();

        assertThat(w.getNazov().equals(novy_nazov)).isTrue();
        assertThat(w.getNazov().equals(stary_nazov)).isFalse();
    }
    @Test
    @Order(3)
    void get_wishes()
    {
        List<WishlistDoplnok> list = service.getWishlist();
        AtomicBoolean exists = new AtomicBoolean(false);

        list.forEach( l ->
        {
            if(repository.findWishByNazov(l.getNazov()).isPresent())
                exists.set(true);

            assertThat(exists.get()).isTrue();
            exists.set(false);
        });
    }

    @Test
    @Order(4)
    void delete_wish()
    {
        String nazov = "novy nazov";
        Integer id = 0;
        WishlistDoplnok w = new WishlistDoplnok();

        boolean exists = false;

        if(repository.findWishByNazov(nazov).isPresent())
        {
            exists = true;
            w =repository.findWishByNazov(nazov).get();
            id = w.getId();
        }
        assertThat(exists).isTrue();

        service.deleteWishlist(id);

        exists = false;
        if(repository.findWishByNazov(nazov).isPresent())
        {
            exists = true;
        }
        assertThat(exists).isFalse();
    }
}
