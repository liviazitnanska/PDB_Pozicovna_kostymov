package com.pdb_db.pdb_proj.domainMongo.recenzia_kostymMongo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdb_db.pdb_proj.domain.recenzia_kostym.RecenziaKostym;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class RecenziaKostymServiceM {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final RecenziaKostymRepositoryM recenziaKostymRepositoryM;
    public List<RecenziaKostymM> getAllRecenziaKostymM() {
        return recenziaKostymRepositoryM.findAll();
    }

    @KafkaListener(topics = "recenziaKostymService_SOT_event", groupId = "group-id")
    public void kafka_receiveMessage(String message) {
        try {
            RecenziaKostym recenziaKostym = OBJECT_MAPPER.readValue(message, RecenziaKostym.class);

            //TODO otestovat
            //TODO pridat aj do oracle triedy volania pred testovanim
            switch (recenziaKostym.getOperation()){
                case PUT -> {
                    //Get recenziaKostym (oracleDB) id
                    Integer id = recenziaKostym.getId();

                    //Find object by recenziaKostym (oracleDB) id in mongoDB
                    RecenziaKostymM recenziaKostymM = recenziaKostymRepositoryM.findById(id
                    ).orElseThrow(() ->
                            new IllegalStateException("Unsuccessful UPDATE request in MongoDB. Record with id: "+id+" is NOT exists!"));

                    // Change mongoDB object properties
                    recenziaKostymM.setNazov(recenziaKostym.getNazov());
                    recenziaKostymM.setPopis(recenziaKostym.getPopis());
                    recenziaKostymM.setSuhlas(recenziaKostym.getSuhlas());
                    recenziaKostymM.setNesuhlas(recenziaKostym.getNesuhlas());
                    recenziaKostymM.setUzivid(recenziaKostym.getUzivid());
                    recenziaKostymM.setKostymid(recenziaKostym.getKostymid());

                    // Save mongoDB object
                    recenziaKostymRepositoryM.save(recenziaKostymM);
                    break;
                }
                case GET -> {
                    break;
                }
                case POST -> {
                    // Create object and init properties
                    RecenziaKostymM recenziaKostymM = new RecenziaKostymM(
                            recenziaKostym.getId(),
                            recenziaKostym.getNazov(),
                            recenziaKostym.getPopis(),
                            recenziaKostym.getSuhlas(),
                            recenziaKostym.getNesuhlas(),
                            recenziaKostym.getUzivid(),
                            recenziaKostym.getKostymid()
                    );
                    // Save object to MongoDB
                    recenziaKostymRepositoryM.save(recenziaKostymM);
                    break;
                }
                case DELETE -> {
                    // Create object and init id
                    RecenziaKostymM recenziaKostymM = new RecenziaKostymM(
                            recenziaKostym.getId()
                    );
                    // Delete object in MongoDB
                    recenziaKostymRepositoryM.delete(recenziaKostymM);
                    break;
                }
            }

        } catch (Exception e){
            System.out.println("Custom exception error [KafkaListener] " + e.getMessage());
        }
    }
}
