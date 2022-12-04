package com.pdb_db.pdb_proj.domainMongo.doplnokMongo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import com.pdb_db.pdb_proj.domain.doplnok_rezervacia.DoplnokRezervacia;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class DoplnokServiceM {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final DoplnokRepositoryM doplnokRepositoryM;

    public List<DoplnokM> getAllDoplnokM()
    {
        return doplnokRepositoryM.findAll();
    }

    @KafkaListener(topics = "doplnokService_SOT_event", groupId = "group-id")
    public void kafka_receiveMessage(String message) {
        try {
            Doplnok doplnok = OBJECT_MAPPER.readValue(message, Doplnok.class);
//            System.out.println("Received Messasge in group - group-id: " + uzivatel.getMeno());
//            System.out.println("Received Messasge in group - group-id: " + uzivatel.getOperation());

            switch (doplnok.getOperation()){
                case PUT -> {
                    //Get doplnok (oracleDB) id
                    Integer id = doplnok.getId();

                    //Find object by doplnok (oracleDB) id in mongoDB
                    DoplnokM doplnokM = doplnokRepositoryM.findById(id
                    ).orElseThrow(() ->
                            new IllegalStateException("Unsuccessful UPDATE request in MongoDB. Record with id: "+id+" is NOT exists!"));

                    // Change mongoDB object properties
                    doplnokM.setNazov(doplnok.getNazov());
                    doplnokM.setPopis(doplnok.getPopis());
                    doplnokM.setMaterial(doplnok.getMaterial());
                    doplnokM.setKategoria(doplnok.getKategoria());
                    doplnokM.setVyroba(doplnok.getVyroba());

                    // Save mongoDB object
                    doplnokRepositoryM.save(doplnokM);
                    break;
                }
                case GET -> {
                    break;
                }
                case POST -> {
                    // Create object and init properties
                    DoplnokM doplnokM = new DoplnokM(
                            doplnok.getId(),
                            doplnok.getNazov(),
                            doplnok.getPopis(),
                            doplnok.getMaterial(),
                            doplnok.getKategoria(),
                            doplnok.getVyroba()
                    );
                    // Save object to MongoDB
                    doplnokRepositoryM.save(doplnokM);
                    break;
                }
                case DELETE -> {
                    // Create object and init id
                    DoplnokM doplnokM = new DoplnokM(
                            doplnok.getId()
                    );
                    // Delete object in MongoDB
                    doplnokRepositoryM.delete(doplnokM);
                    break;
                }
            }

        } catch (Exception e){
            System.out.println("Custom exception error [KafkaListener] " + e.getMessage());
        }
    }


    /*public DoplnokM getDoplnokMById(Integer id)
    {
        return doplnokRepositoryM.findDoplnokMById(id).get();
    }*/

    /*public List<DoplnokM> getAllDoplnokMByMaterial(String material)
    {
        return doplnokRepositoryM.findAllByMaterial(material);
    }

    public List<DoplnokM> getAllDoplnokMByKategoria(String kategoria)
    {
        return doplnokRepositoryM.findAllByKategoria(kategoria);
    }*/

}
