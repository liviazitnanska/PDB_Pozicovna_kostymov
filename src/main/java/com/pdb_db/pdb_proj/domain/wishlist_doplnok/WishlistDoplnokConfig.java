package com.pdb_db.pdb_proj.domain.wishlist_doplnok;

import com.pdb_db.pdb_proj.domain.wishlist_kostym.WishlistKostym;
import com.pdb_db.pdb_proj.domain.wishlist_kostym.WishlistKostymRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WishlistDoplnokConfig
{
    @Bean
    CommandLineRunner commandLineRunnerWishlistDoplnok(
            WishlistDoplnokRepository repository
    ){
        return args -> {
            WishlistDoplnok Rec4 = new WishlistDoplnok("Wish1",1,2);
            WishlistDoplnok Rec5 = new WishlistDoplnok("Wish2",2,1);

            repository.saveAll(List.of(Rec4, Rec5));
        };
    }
}
