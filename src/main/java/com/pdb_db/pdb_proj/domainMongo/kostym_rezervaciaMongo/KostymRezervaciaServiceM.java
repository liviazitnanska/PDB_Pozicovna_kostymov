package com.pdb_db.pdb_proj.domainMongo.kostym_rezervaciaMongo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdb_db.pdb_proj.domain.kostym_rezervacia.KostymRezervacia;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class KostymRezervaciaServiceM {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final KostymRezervaciaRepositoryM kostymRezervaciaRepositoryM;

    public List<KostymRezervaciaM> getAllKostymRezervaciaM() {
        return kostymRezervaciaRepositoryM.findAll();
    }

    @KafkaListener(topics = "kostymRezervaciaService_SOT_event", groupId = "group-id")
    public void kafka_receiveMessage(String message) {
        try {
            KostymRezervacia kostymRezervacia = OBJECT_MAPPER.readValue(message, KostymRezervacia.class);

            switch (kostymRezervacia.getOperation()){
                case PUT -> {
                    //Get recenziaKostym (oracleDB) id
                    Integer id = kostymRezervacia.getId();

                    //Find object by recenziaKostym (oracleDB) id in mongoDB
                    KostymRezervaciaM kostymRezervaciaM = kostymRezervaciaRepositoryM.findById(id
                    ).orElseThrow(() ->
                            new IllegalStateException("Unsuccessful UPDATE request in MongoDB. Record with id: "+id+" is NOT exists!"));

                    // Change mongoDB object properties
                    kostymRezervaciaM.setId(kostymRezervacia.getId());
                    kostymRezervaciaM.setUzivid(kostymRezervacia.getUzivid());
                    kostymRezervaciaM.setKostymid(kostymRezervacia.getKostymid());
                    kostymRezervaciaM.setCasPozicania(kostymRezervacia.getCasPozicania());
                    kostymRezervaciaM.setCasVratenia(kostymRezervacia.getCasVratenia());
                    kostymRezervaciaM.setVratenie(kostymRezervacia.getVratenie());

                    // Save mongoDB object
                    kostymRezervaciaRepositoryM.save(kostymRezervaciaM);
                    break;
                }
                case GET -> {
                    break;
                }
                case POST -> {
                    // Create object and init properties
                    KostymRezervaciaM kostymRezervaciaM = new KostymRezervaciaM(
                            kostymRezervacia.getId(),
                            kostymRezervacia.getUzivid(),
                            kostymRezervacia.getKostymid(),
                            kostymRezervacia.getCasPozicania(),
                            kostymRezervacia.getCasVratenia(),
                            kostymRezervacia.getVratenie()
                    );
                    // Save object to MongoDB
                    kostymRezervaciaRepositoryM.save(kostymRezervaciaM);
                    break;
                }
                case DELETE -> {
                    // Create object and init id
                    KostymRezervaciaM kostymRezervaciaM = new KostymRezervaciaM(
                            kostymRezervacia.getId()
                    );
                    // Delete object in MongoDB
                    kostymRezervaciaRepositoryM.delete(kostymRezervaciaM);
                    break;
                }
            }

        } catch (Exception e){
            System.out.println("Custom exception error [KafkaListener] " + e.getMessage());
        }
    }

}
