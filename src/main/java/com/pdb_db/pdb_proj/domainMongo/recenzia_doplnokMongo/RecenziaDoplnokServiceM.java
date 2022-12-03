package com.pdb_db.pdb_proj.domainMongo.recenzia_doplnokMongo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdb_db.pdb_proj.domain.recenzia_doplnok.RecenziaDoplnok;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class RecenziaDoplnokServiceM {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final RecenziaDoplnokRepositoryM recenziaDoplnokRepositoryM;
    public List<RecenziaDoplnokM> getAllRecenziaDoplnokM() {
        return  recenziaDoplnokRepositoryM.findAll();
    }

    @KafkaListener(topics = "recenziaDoplnokService_SOT_event", groupId = "group-id")
    public void kafka_receiveMessage(String message) {
        try {
            RecenziaDoplnok recenziaDoplnok = OBJECT_MAPPER.readValue(message, RecenziaDoplnok.class);

            switch (recenziaDoplnok.getOperation()){
                case PUT -> {
                    //Get recenziaDoplnok (oracleDB) id
                    Integer id = recenziaDoplnok.getId();

                    //Find object by recenziaDoplnok (oracleDB) id in mongoDB
                    RecenziaDoplnokM recenziaDoplnokM = recenziaDoplnokRepositoryM.findById(id
                    ).orElseThrow(() ->
                            new IllegalStateException("Unsuccessful UPDATE request in MongoDB. Record with id: "+id+" is NOT exists!"));

                    // Change mongoDB object properties
                    recenziaDoplnokM.setNazov(recenziaDoplnok.getNazov());
                    recenziaDoplnokM.setPopis(recenziaDoplnok.getPopis());
                    recenziaDoplnokM.setSuhlas(recenziaDoplnok.getSuhlas());
                    recenziaDoplnokM.setNesuhlas(recenziaDoplnok.getNesuhlas());
                    recenziaDoplnokM.setUzivid(recenziaDoplnok.getUzivid());
                    recenziaDoplnokM.setDoplnokid(recenziaDoplnok.getDoplnokid());

                    // Save mongoDB object
                    recenziaDoplnokRepositoryM.save(recenziaDoplnokM);
                    break;
                }
                case GET -> {
                    break;
                }
                case POST -> {
                    // Create object and init properties
                    RecenziaDoplnokM recenziaDoplnokM = new RecenziaDoplnokM(
                            recenziaDoplnok.getId(),
                            recenziaDoplnok.getNazov(),
                            recenziaDoplnok.getPopis(),
                            recenziaDoplnok.getSuhlas(),
                            recenziaDoplnok.getNesuhlas(),
                            recenziaDoplnok.getUzivid(),
                            recenziaDoplnok.getDoplnokid()
                    );
                    // Save object to MongoDB
                    recenziaDoplnokRepositoryM.save(recenziaDoplnokM);
                    break;
                }
                case DELETE -> {
                    // Create object and init id
                    RecenziaDoplnokM recenziaDoplnokM = new RecenziaDoplnokM(
                            recenziaDoplnok.getId()
                    );
                    // Delete object in MongoDB
                    recenziaDoplnokRepositoryM.delete(recenziaDoplnokM);
                    break;
                }
            }

        } catch (Exception e){
            System.out.println("Custom exception error [KafkaListener] " + e.getMessage());
        }
    }
}
