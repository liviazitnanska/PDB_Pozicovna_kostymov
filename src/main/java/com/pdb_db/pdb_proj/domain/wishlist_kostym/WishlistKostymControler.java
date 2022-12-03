package com.pdb_db.pdb_proj.domain.wishlist_kostym;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/wishlist_kostym")
public class WishlistKostymControler {

    private final WishlistKostymService wishlistKostymService;

    @Autowired
    public WishlistKostymControler(WishlistKostymService wishlistKostymService) {
        this.wishlistKostymService = wishlistKostymService;
    }

    @GetMapping
    public List<WishlistKostym> getWishlist(){
        return wishlistKostymService.getWishlist();
    }

    @PostMapping
    public void registerNewWishlist(@RequestBody WishlistKostym wishlistKostym){
        wishlistKostymService.addNewWishlist(wishlistKostym);
    }

    @DeleteMapping(path = "{id}")
    public void deleteWishlist(@PathVariable("id") Integer id){
        wishlistKostymService.deleteWishlist(id);
    }

    @PutMapping(path = "{id}")
    public void updateWishlist(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String nazov,
            @RequestParam(required = false) Integer uzivid,
            @RequestParam(required = false) Integer kostymid
    ){
        wishlistKostymService.updateWishlist(id, nazov, uzivid, kostymid);
    }

}
