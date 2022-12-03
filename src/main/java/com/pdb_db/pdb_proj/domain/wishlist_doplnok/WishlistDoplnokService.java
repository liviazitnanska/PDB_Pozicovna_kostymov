package com.pdb_db.pdb_proj.domain.wishlist_doplnok;

import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import com.pdb_db.pdb_proj.domain.wishlist_kostym.WishlistKostym;
import com.pdb_db.pdb_proj.domain.wishlist_kostym.WishlistKostymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class WishlistDoplnokService
{
    private final WishlistDoplnokRepository wishlistDoplnokRepository;

    @Autowired
    public WishlistDoplnokService(WishlistDoplnokRepository wishlistDoplnokRepository) {
        this.wishlistDoplnokRepository = wishlistDoplnokRepository;
    }

    public List<WishlistDoplnok> getWishlist() {
        return wishlistDoplnokRepository.findAll();
    }

    public Optional<WishlistDoplnok> getWishByName(String name)
    {
        return wishlistDoplnokRepository.findWishByNazov(name);
    }

    //Operacia: Vytvorenie wishlistu
    public void addNewWishlist(WishlistDoplnok wishlistDoplnok)
    {
        Optional<Uzivatel> uzivatelOptional = wishlistDoplnokRepository.findUzivatelById(wishlistDoplnok.getUzivid());
        if(!uzivatelOptional.isPresent())
        {
            throw new IllegalStateException("Can not create wishlist to non existent user");
        }

        Optional<Doplnok> doplnokOptional = wishlistDoplnokRepository.findDoplnokById(wishlistDoplnok.getDoplnokid());
        if(!uzivatelOptional.isPresent())
        {
            throw new IllegalStateException("Can not create wishlist to non existent user");
        }

        wishlistDoplnokRepository.save(wishlistDoplnok);
    }

    //Operacia: Odstranenie wishlistu
    public void deleteWishlist(Integer id) {
        boolean exists = wishlistDoplnokRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Unsuccessful DELETE request. Record with id: "+id+" is NOT exists!");
        }
        wishlistDoplnokRepository.deleteById(id);
    }

    @Transactional
    public void updateWishlist(Integer id, String nazov, Integer uzivid, Integer doplnokid) {
        WishlistDoplnok wR = wishlistDoplnokRepository.findById(id
        ).orElseThrow(() ->
                new IllegalStateException("Unsuccessful UPDATE request. Record with id: "+id+" is NOT exists!"));

        wR.setId(id);
        if (nazov != null && nazov.length() > 0){
            wR.setNazov(nazov);
        }
        if (uzivid != null){
            wR.setUzivid(uzivid);
        }
        if (doplnokid != null){
            wR.setDoplnokmid(doplnokid);
        }
    }

}

