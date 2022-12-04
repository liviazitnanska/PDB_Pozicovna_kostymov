package com.pdb_db.pdb_proj.domainMongo.wishlist_kostymMongo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdb_db.pdb_proj.domain.wishlist_kostym.WishlistKostym;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class WishlistKostymServiceM {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public final WishlistKostymRepositoryM wishlistKostymRepositoryM;

    public List<WishlistKostymM> getAllWishlistKostymM(){
        return wishlistKostymRepositoryM.findAll();
    }


    @KafkaListener(topics = "wishlistKostymService_SOT_event", groupId = "group-id")
    public void kafka_receiveMessage(String message) {
        try {
            WishlistKostym wishlistKostym = OBJECT_MAPPER.readValue(message, WishlistKostym.class);

            switch (wishlistKostym.getOperation()){
                case PUT -> {
                    //Get wishlistKostymM (oracleDB) id
                    Integer id = wishlistKostym.getId();

                    //Find object by wishlistKostymM (oracleDB) id in mongoDB
                    WishlistKostymM wishlistKostymM = wishlistKostymRepositoryM.findById(id
                    ).orElseThrow(() ->
                            new IllegalStateException("Unsuccessful UPDATE request in MongoDB. Record with id: "+id+" is NOT exists!"));

                    // Change mongoDB object properties
                    wishlistKostymM.setId(wishlistKostym.getId());
                    wishlistKostymM.setNazov(wishlistKostym.getNazov());
                    wishlistKostymM.setUzivid(wishlistKostym.getUzivid());
                    wishlistKostymM.setKostymid(wishlistKostym.getKostymid());

                    // Save mongoDB object
                    wishlistKostymRepositoryM.save(wishlistKostymM);
                    break;
                }
                case GET -> {
                    break;
                }
                case POST -> {
                    // Create object and init properties
                    WishlistKostymM wishlistKostymM = new WishlistKostymM(
                            wishlistKostym.getId(),
                            wishlistKostym.getNazov(),
                            wishlistKostym.getUzivid(),
                            wishlistKostym.getKostymid()
                    );
                    // Save object to MongoDB
                    wishlistKostymRepositoryM.save(wishlistKostymM);
                    break;
                }
                case DELETE -> {
                    // Create object and init id
                    WishlistKostymM wishlistKostymM = new WishlistKostymM(
                            wishlistKostym.getId()
                    );
                    // Delete object in MongoDB
                    wishlistKostymRepositoryM.delete(wishlistKostymM);
                    break;
                }
            }

        } catch (Exception e){
            System.out.println("Custom exception error [KafkaListener] " + e.getMessage());
        }
    }
}
