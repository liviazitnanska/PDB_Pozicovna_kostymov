package com.pdb_db.pdb_proj.domain.wishlist_kostym;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WishlistKostymConfig {

    @Bean
    CommandLineRunner commandLineRunnerWishlist(
            WishlistKostymRepository repository
    ){
        return args -> {
            WishlistKostym Rec4 = new WishlistKostym("Wish1",1,2);
            WishlistKostym Rec5 = new WishlistKostym("Wish2",2,1);

            repository.saveAll(List.of(Rec4, Rec5));
        };
    }

}
