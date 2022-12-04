package com.pdb_db.pdb_proj.domainMongo.wishlist_kostymMongo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/v1/wishlist_kostymM")
@AllArgsConstructor
public class WishlistKostymControllerM {

    private final WishlistKostymServiceM wishlistKostymServiceM;

    @GetMapping
    public List<WishlistKostymM> fetchAllWishlistKostymM(){
        return wishlistKostymServiceM.getAllWishlistKostymM();
    }

}
