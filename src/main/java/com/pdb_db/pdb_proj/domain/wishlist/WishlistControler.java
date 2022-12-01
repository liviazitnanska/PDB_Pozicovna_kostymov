package com.pdb_db.pdb_proj.domain.wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/wishlist")
public class WishlistControler {

    private final WishlistService wishlistService;

    @Autowired
    public WishlistControler(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping
    public List<Wishlist> getWishlist(){
        return wishlistService.getWishlist();
    }

    @PostMapping
    public void registerNewWishlist(@RequestBody Wishlist wishlist){
        wishlistService.addNewWishlist(wishlist);
    }

    @DeleteMapping(path = "{id}")
    public void deleteWishlist(@PathVariable("id") Integer id){
        wishlistService.deleteWishlist(id);
    }

    @PutMapping(path = "{id}")
    public void updateWishlist(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String nazov,
            @RequestParam(required = false) Integer uzivid
    ){
        wishlistService.updateWishlist(id, nazov, uzivid);
    }


}
