package com.pdb_db.pdb_proj.domain.wishlist_kostym;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import com.pdb_db.pdb_proj.domain.kostym.Kostym;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import com.pdb_db.pdb_proj.utilities.rest_operationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class WishlistKostymService {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final WishlistKostymRepository wishlistKostymRepository;

    @Autowired
    public WishlistKostymService(WishlistKostymRepository wishlistKostymRepository) {
        this.wishlistKostymRepository = wishlistKostymRepository;
    }

    public List<WishlistKostym> getWishlist() {
        return wishlistKostymRepository.findAll();
    }

    public Optional<WishlistKostym> getWishByName(String name)
    {
        return wishlistKostymRepository.findWishByNazov(name);
    }


    //Operacia: Vytvorenie wishlistu
    public void addNewWishlist(WishlistKostym wishlistKostym)
    {
       Optional<Uzivatel> uzivatelOptional = wishlistKostymRepository.findUzivatelById(wishlistKostym.getUzivid());
        if(!uzivatelOptional.isPresent())
        {
            throw new IllegalStateException("Can not create wishlist to non existent user");
        }

        Optional<Kostym> doplnokOptional = wishlistKostymRepository.findKostymById(wishlistKostym.getKostymid());
        if(!uzivatelOptional.isPresent())
        {
            throw new IllegalStateException("Can not create wishlist to non existent user");
        }

        // Oracle
        wishlistKostymRepository.save(wishlistKostym);
        // Kafka -> MongoDB
        wishlistKostym.setOperation(rest_operationType.POST);
        this.kafka_sendMessage(wishlistKostym);
    }


    //Operacia: Odstranenie wishlistu
    public void deleteWishlist(Integer id) {
        boolean exists = wishlistKostymRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Unsuccessful DELETE request. Record with id: "+id+" is NOT exists!");
        }

        // Oracle
        wishlistKostymRepository.deleteById(id);
        // Kafka -> MongoDB
        WishlistKostym wishlistKostym = new WishlistKostym(id);
        wishlistKostym.setOperation(rest_operationType.DELETE);
        this.kafka_sendMessage(wishlistKostym);
    }

    //Operacia: Uprava wishlistu
    @Transactional
    public void updateWishlist(Integer id, String nazov, Integer uzivid, Integer kostymid) {
        WishlistKostym wR = wishlistKostymRepository.findById(id
        ).orElseThrow(() ->
                new IllegalStateException("Unsuccessful UPDATE request. Record with id: "+id+" is NOT exists!"));

        wR.setId(id);
        if (nazov != null && nazov.length() > 0){
            wR.setNazov(nazov);
        }
        if (uzivid != null){
            wR.setUzivid(uzivid);
        }
        if (kostymid != null){
            wR.setKostymid(kostymid);
        }

        // Kafka -> MongoDB
        wR.setOperation(rest_operationType.PUT);
        this.kafka_sendMessage(wR);
    }

    @Autowired
    private KafkaTemplate<Long, String> kafkaTemplate;

    public void kafka_sendMessage(WishlistKostym wishlistKostym) {
        try {
            String str_wishlistKostym = OBJECT_MAPPER.writeValueAsString(wishlistKostym);
            //SOT = Source of truth
            kafkaTemplate.send("wishlistKostymService_SOT_event", str_wishlistKostym);
        } catch (Exception e){
            System.out.println("Custom exception error [KafkaSender]: " + e.getMessage());
        }

    }
}
