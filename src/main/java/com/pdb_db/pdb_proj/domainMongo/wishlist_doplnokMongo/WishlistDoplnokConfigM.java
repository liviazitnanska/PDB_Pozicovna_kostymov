package com.pdb_db.pdb_proj.domainMongo.wishlist_doplnokMongo;

import com.pdb_db.pdb_proj.domain.wishlist_doplnok.WishlistDoplnok;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WishlistDoplnokConfigM {
    @Bean
    CommandLineRunner commandLineRunnerWishlistDoplnokM(
            WishlistDoplnokRepositoryM repository
    ){
        return args -> {
            WishlistDoplnokM Rec4 = new WishlistDoplnokM(1,"Wish1",1,2);
            WishlistDoplnokM Rec5 = new WishlistDoplnokM(2,"Wish2",2,1);

            repository.saveAll(List.of(Rec4, Rec5));
        };
    }
}
