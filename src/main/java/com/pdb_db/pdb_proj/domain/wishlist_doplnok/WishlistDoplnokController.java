package com.pdb_db.pdb_proj.domain.wishlist_doplnok;

import com.pdb_db.pdb_proj.domain.wishlist_kostym.WishlistKostym;
import com.pdb_db.pdb_proj.domain.wishlist_kostym.WishlistKostymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/wishlist_doplnok")
public class WishlistDoplnokController
{
    private final WishlistDoplnokService wishlistDoplnokService;

    @Autowired
    public WishlistDoplnokController(WishlistDoplnokService wishlistDoplnokService) {
        this.wishlistDoplnokService = wishlistDoplnokService;
    }

    @GetMapping
    public List<WishlistDoplnok> getWishlist(){
        return wishlistDoplnokService.getWishlist();
    }

    @PostMapping
    public void registerNewWishlist(@RequestBody WishlistDoplnok wishlistDoplnok){
        wishlistDoplnokService.addNewWishlist(wishlistDoplnok);
    }

    @DeleteMapping(path = "{id}")
    public void deleteWishlist(@PathVariable("id") Integer id){
        wishlistDoplnokService.deleteWishlist(id);
    }

    @PutMapping(path = "{id}")
    public void updateWishlist(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String nazov,
            @RequestParam(required = false) Integer uzivid,
            @RequestParam(required = false) Integer doplnokid
            ){
        wishlistDoplnokService.updateWishlist(id, nazov, uzivid, doplnokid);
    }
}
