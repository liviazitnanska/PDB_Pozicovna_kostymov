package com.pdb_db.pdb_proj.domain.wishlist_doplnok;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import com.pdb_db.pdb_proj.domain.wishlist_kostym.WishlistKostym;
import com.pdb_db.pdb_proj.domain.wishlist_kostym.WishlistKostymRepository;
import com.pdb_db.pdb_proj.utilities.rest_operationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class WishlistDoplnokService
{
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
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

        // Oracle
        wishlistDoplnokRepository.save(wishlistDoplnok);
        // Kafka -> MongoDB
        wishlistDoplnok.setOperation(rest_operationType.POST);
        this.kafka_sendMessage(wishlistDoplnok);
    }

    //Operacia: Odstranenie wishlistu
    public void deleteWishlist(Integer id) {
        boolean exists = wishlistDoplnokRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Unsuccessful DELETE request. Record with id: "+id+" is NOT exists!");
        }
        // Oracle
        wishlistDoplnokRepository.deleteById(id);
        // Kafka -> MongoDB
        WishlistDoplnok wishlistDoplnok = new WishlistDoplnok(id);
        wishlistDoplnok.setOperation(rest_operationType.DELETE);
        this.kafka_sendMessage(wishlistDoplnok);
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
        // Kafka -> MongoDB
        wR.setOperation(rest_operationType.PUT);
        this.kafka_sendMessage(wR);
    }

    @Autowired
    private KafkaTemplate<Long, String> kafkaTemplate;

    public void kafka_sendMessage(WishlistDoplnok wishlistDoplnok) {
        try {
            String str_wishlistDoplnok = OBJECT_MAPPER.writeValueAsString(wishlistDoplnok);
            //SOT = Source of truth
            kafkaTemplate.send("wishlistDoplnokService_SOT_event",  str_wishlistDoplnok);
        } catch (Exception e){
            System.out.println("Custom exception error [KafkaSender]: " + e.getMessage());
        }

    }
}

