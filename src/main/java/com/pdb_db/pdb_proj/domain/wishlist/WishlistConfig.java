package com.pdb_db.pdb_proj.domain.wishlist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WishlistConfig {

    @Bean
    CommandLineRunner commandLineRunnerWishlist(
            WishlistRepository repository
    ){
        return args -> {
            Wishlist Rec4 = new Wishlist(1,
                    "Wish1",
                    1);
            Wishlist Rec5 = new Wishlist(2,
                    "Wish2",
                    2);

            repository.saveAll(List.of(Rec4, Rec5));
        };
    }

}
