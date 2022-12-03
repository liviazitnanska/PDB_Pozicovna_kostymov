package com.pdb_db.pdb_proj.domainMongo.kostymMongo;

import com.pdb_db.pdb_proj.domain.kostym.Kostym;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdb_db.pdb_proj.domain.kostym_rezervacia.KostymRezervacia;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class KostymServiceM
{
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final KostymRepositoryM kostymRepositoryM;
    public List<KostymM> getAllKostymM()
    {
        return kostymRepositoryM.findAll();
    }

    @KafkaListener(topics = "kostymService_SOT_event", groupId = "group-id")
    public void kafka_receiveMessage(String message) {
        try {
            Kostym kostym = OBJECT_MAPPER.readValue(message, Kostym.class);

            switch (kostym.getOperation()){
                case PUT -> {
                    //Get kostym (oracleDB) id
                    Integer id = kostym.getId();

                    //Find object by kostym (oracleDB) id in mongoDB
                    KostymM kostymM = kostymRepositoryM.findById(id
                    ).orElseThrow(() ->
                            new IllegalStateException("Unsuccessful UPDATE request in MongoDB. Record with id: "+id+" is NOT exists!"));

                    // Change mongoDB object properties
                    kostymM.setNazov(kostym.getNazov());
                    kostymM.setPopis(kostym.getPopis());
                    kostymM.setMaterial(kostym.getMaterial());
                    kostymM.setKategoria(kostym.getKategoria());
                    kostymM.setVelkost(kostym.getVelkost());
                    kostymM.setVyroba(kostym.getVyroba());

                    // Save mongoDB object
                    kostymRepositoryM.save(kostymM);
                    break;
                }
                case GET -> {
                    break;
                }
                case POST -> {
                    // Create object and init properties
                    KostymM kostymM = new KostymM(
                            kostym.getId(),
                            kostym.getNazov(),
                            kostym.getPopis(),
                            kostym.getMaterial(),
                            kostym.getKategoria(),
                            kostym.getVelkost(),
                            kostym.getVyroba(),
                            new ArrayList<>()
                            );
                    // Save object to MongoDB
                    kostymRepositoryM.save(kostymM);
                    break;
                }
                case DELETE -> {
                    // Create object and init id
                    KostymM kostymM = new KostymM(
                            kostym.getId()
                    );
                    // Delete object in MongoDB
                    kostymRepositoryM.delete(kostymM);
                    break;
                }
            }

        } catch (Exception e){
            System.out.println("Custom exception error [KafkaListener] " + e.getMessage());
        }
    }


   /* public KostymM getKostym(Integer id) {
        return kostymRepositoryM.findKostymMById(id).get();
    }*/

   /* public List<KostymM> getAllKostymMbyKategoria(String kategoria)
    {

        return kostymRepositoryM.findAllByKategoria(kategoria);
    }*/

   /* public List<KostymM> getAllKostymMByMaterial(String material)
    {
        return kostymRepositoryM.findAllByMaterial(material);
    }*/


}
