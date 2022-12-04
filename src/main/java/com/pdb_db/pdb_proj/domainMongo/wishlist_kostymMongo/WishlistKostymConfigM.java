package com.pdb_db.pdb_proj.domainMongo.wishlist_kostymMongo;

import com.pdb_db.pdb_proj.domain.wishlist_kostym.WishlistKostym;
import com.pdb_db.pdb_proj.domain.wishlist_kostym.WishlistKostymRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WishlistKostymConfigM {

    @Bean
    CommandLineRunner commandLineRunnerWishlistM(
            WishlistKostymRepositoryM repository
    ){
        return args -> {
            WishlistKostymM Rec4 = new WishlistKostymM(1,"Wish1",1,2);
            WishlistKostymM Rec5 = new WishlistKostymM(2,"Wish2",2,1);

            repository.saveAll(List.of(Rec4, Rec5));
        };
    }
}
