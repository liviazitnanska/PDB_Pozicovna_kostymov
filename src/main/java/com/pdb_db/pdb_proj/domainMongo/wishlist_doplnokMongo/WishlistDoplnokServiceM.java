package com.pdb_db.pdb_proj.domainMongo.wishlist_doplnokMongo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdb_db.pdb_proj.domain.wishlist_doplnok.WishlistDoplnok;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class WishlistDoplnokServiceM {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public final WishlistDoplnokRepositoryM wishlistDoplnokRepositoryM;

    public List<WishlistDoplnokM> getAllWishlistDoplnokM(){
        return wishlistDoplnokRepositoryM.findAll();
    }


    @KafkaListener(topics = "wishlistDoplnokService_SOT_event", groupId = "group-id")
    public void kafka_receiveMessage(String message) {
        try {
            WishlistDoplnok wishlistDoplnok = OBJECT_MAPPER.readValue(message, WishlistDoplnok.class);

            switch (wishlistDoplnok.getOperation()){
                case PUT -> {
                    //Get wishlistDoplnok (oracleDB) id
                    Integer id = wishlistDoplnok.getId();

                    //Find object by wishlistDoplnok (oracleDB) id in mongoDB
                    WishlistDoplnokM wishlistDoplnokM = wishlistDoplnokRepositoryM.findById(id
                    ).orElseThrow(() ->
                            new IllegalStateException("Unsuccessful UPDATE request in MongoDB. Record with id: "+id+" is NOT exists!"));

                    // Change mongoDB object properties
                    wishlistDoplnokM.setId(wishlistDoplnok.getId());
                    wishlistDoplnokM.setNazov(wishlistDoplnok.getNazov());
                    wishlistDoplnokM.setUzivid(wishlistDoplnok.getUzivid());
                    wishlistDoplnokM.setDoplnokid(wishlistDoplnok.getDoplnokid());

                    // Save mongoDB object
                    wishlistDoplnokRepositoryM.save(wishlistDoplnokM);
                    break;
                }
                case GET -> {
                    break;
                }
                case POST -> {
                    // Create object and init properties
                    WishlistDoplnokM wishlistDoplnokM = new WishlistDoplnokM(
                            wishlistDoplnok.getId(),
                            wishlistDoplnok.getNazov(),
                            wishlistDoplnok.getUzivid(),
                            wishlistDoplnok.getDoplnokid()
                    );
                    // Save object to MongoDB
                    wishlistDoplnokRepositoryM.save(wishlistDoplnokM);
                    break;
                }
                case DELETE -> {
                    // Create object and init id
                    WishlistDoplnokM wishlistDoplnokM = new WishlistDoplnokM(
                            wishlistDoplnok.getId()
                    );
                    // Delete object in MongoDB
                    wishlistDoplnokRepositoryM.delete(wishlistDoplnokM);
                    break;
                }
            }

        } catch (Exception e){
            System.out.println("Custom exception error [KafkaListener] " + e.getMessage());
        }
    }
}
