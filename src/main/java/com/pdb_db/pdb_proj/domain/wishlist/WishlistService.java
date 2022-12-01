package com.pdb_db.pdb_proj.domain.wishlist;

import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import com.pdb_db.pdb_proj.domain.uzivatel.UzivatelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;

    @Autowired
    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }


    public List<Wishlist> getWishlist() {
        return wishlistRepository.findAll();
    }

    //Operacia: Vytvorenie wishlistu
    public void addNewWishlist(Wishlist wishlist)
    {
       Optional<Uzivatel> uzivatelOptional = wishlistRepository.findUzivatelById(wishlist.getUzivid());
        if(!uzivatelOptional.isPresent())
        {
            throw new IllegalStateException("Can not create wishlist to non existent user");
        }
        wishlistRepository.save(wishlist);
    }


    //Operacia: Odstranenie wishlistu
    public void deleteWishlist(Integer id) {
        boolean exists = wishlistRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Unsuccessful DELETE request. Record with id: "+id+" is NOT exists!");
        }
        wishlistRepository.deleteById(id);
    }

    //Operacia: Uprava wishlistu
    @Transactional
    public void updateWishlist(Integer id, String nazov, Integer uzivid) {
        Wishlist wR = wishlistRepository.findById(id
        ).orElseThrow(() ->
                new IllegalStateException("Unsuccessful UPDATE request. Record with id: "+id+" is NOT exists!"));

        wR.setId(id);
        if (nazov != null && nazov.length() > 0){
            wR.setNazov(nazov);
        }
        if (uzivid != null){
            wR.setUzivid(uzivid);
        }



    }

}
