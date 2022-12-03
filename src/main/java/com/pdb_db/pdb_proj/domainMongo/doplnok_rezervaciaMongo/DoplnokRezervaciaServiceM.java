package com.pdb_db.pdb_proj.domainMongo.doplnok_rezervaciaMongo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdb_db.pdb_proj.domain.doplnok_rezervacia.DoplnokRezervacia;
import com.pdb_db.pdb_proj.domain.recenzia_doplnok.RecenziaDoplnok;
import com.pdb_db.pdb_proj.domainMongo.recenzia_doplnokMongo.RecenziaDoplnokM;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DoplnokRezervaciaServiceM {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final DoplnokRezervaciaRepositoryM doplnokRezervaciaRepositoryM;

    public List<DoplnokRezervaciaM> getAllDoplnokRezervaciaM() {
        return doplnokRezervaciaRepositoryM.findAll();
    }

    @KafkaListener(topics = "doplnokRezervaciaService_SOT_event", groupId = "group-id")
    public void kafka_receiveMessage(String message) {
        try {
            DoplnokRezervacia doplnokRezervacia = OBJECT_MAPPER.readValue(message, DoplnokRezervacia.class);

            switch (doplnokRezervacia.getOperation()){
                case PUT -> {
                    //Get recenziaDoplnok (oracleDB) id
                    Integer id = doplnokRezervacia.getId();

                    //Find object by recenziaDoplnok (oracleDB) id in mongoDB
                    DoplnokRezervaciaM doplnokRezervaciaM = doplnokRezervaciaRepositoryM.findById(id
                    ).orElseThrow(() ->
                            new IllegalStateException("Unsuccessful UPDATE request in MongoDB. Record with id: "+id+" is NOT exists!"));

                    // Change mongoDB object properties
                    doplnokRezervaciaM.setId(doplnokRezervacia.getId());
                    doplnokRezervaciaM.setUzivid(doplnokRezervacia.getUzivid());
                    doplnokRezervaciaM.setDoplnokid(doplnokRezervacia.getDoplnokid());
                    doplnokRezervaciaM.setCasPozicania(doplnokRezervacia.getCasPozicania());
                    doplnokRezervaciaM.setCasVratenia(doplnokRezervacia.getCasVratenia());
                    doplnokRezervaciaM.setVratenie(doplnokRezervacia.getVratenie());

                    // Save mongoDB object
                    doplnokRezervaciaRepositoryM.save(doplnokRezervaciaM);
                    break;
                }
                case GET -> {
                    break;
                }
                case POST -> {
                    // Create object and init properties
                    DoplnokRezervaciaM doplnokRezervaciaM = new DoplnokRezervaciaM(
                            doplnokRezervacia.getId(),
                            doplnokRezervacia.getUzivid(),
                            doplnokRezervacia.getDoplnokid(),
                            doplnokRezervacia.getCasPozicania(),
                            doplnokRezervacia.getCasVratenia(),
                            doplnokRezervacia.getVratenie()
                    );
                    // Save object to MongoDB
                    doplnokRezervaciaRepositoryM.save(doplnokRezervaciaM);
                    break;
                }
                case DELETE -> {
                    // Create object and init id
                    DoplnokRezervaciaM doplnokRezervaciaM = new DoplnokRezervaciaM(
                            doplnokRezervacia.getId()
                    );
                    // Delete object in MongoDB
                    doplnokRezervaciaRepositoryM.delete(doplnokRezervaciaM);
                    break;
                }
            }

        } catch (Exception e){
            System.out.println("Custom exception error [KafkaListener] " + e.getMessage());
        }
    }
}
