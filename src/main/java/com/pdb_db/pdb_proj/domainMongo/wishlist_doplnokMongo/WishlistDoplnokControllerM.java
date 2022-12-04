package com.pdb_db.pdb_proj.domainMongo.wishlist_doplnokMongo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/wishlist_doplnokM")
@AllArgsConstructor
public class WishlistDoplnokControllerM {

    private final WishlistDoplnokServiceM wishlistDoplnokServiceM;

    @GetMapping
    public List<WishlistDoplnokM> fetchAllWishlistDoplnokM()
    {
        return wishlistDoplnokServiceM.getAllWishlistDoplnokM();
    }
}
