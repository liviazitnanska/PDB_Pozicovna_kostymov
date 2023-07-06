package com.pdb_db.pdb_proj.tests.wish;

import com.pdb_db.pdb_proj.domain.costume_wishlist.CostumeWishlist;
import com.pdb_db.pdb_proj.domain.costume_wishlist.CostumeWishlistRepository;
import com.pdb_db.pdb_proj.domain.costume_wishlist.CostumeWishlistService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WishCostumeTest
{

    @Autowired
    CostumeWishlistRepository repository;

    @Autowired
    CostumeWishlistService service;

    @Test
    @Order(1)
    void create_wish()
    {
        CostumeWishlist w = new CostumeWishlist("W",1,2);
        service.addNewCostumeWishlist(w);

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

        CostumeWishlist w = new CostumeWishlist();

        if(service.getCostumeWishlistByName(stary_nazov).isPresent())
        {
            w = service.getCostumeWishlistByName(stary_nazov).get();
        }

        service.updateWishlist(w.getId(),novy_nazov,null,null);
        w = service.getCostumeWishlistByName(novy_nazov).get();

        assertThat(w.getName().equals(novy_nazov)).isTrue();
        assertThat(w.getName().equals(stary_nazov)).isFalse();
    }
    @Test
    @Order(3)
    void get_wishes()
    {
        List<CostumeWishlist> list = service.getCostumeWishlist();
        AtomicBoolean exists = new AtomicBoolean(false);

        list.forEach( l ->
        {
            if(repository.findCostumeWishlistByName(l.getName()).isPresent())
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
        CostumeWishlist w = new CostumeWishlist();

        boolean exists = false;

        if(repository.findCostumeWishlistByName(nazov).isPresent())
        {
            exists = true;
            w =repository.findCostumeWishlistByName(nazov).get();
            id = w.getId();
        }
        assertThat(exists).isTrue();

        service.deleteCostumeWishlist(id);

        exists = false;
        if(repository.findCostumeWishlistByName(nazov).isPresent())
        {
            exists = true;
        }
        assertThat(exists).isFalse();
    }
}
