package com.pdb_db.pdb_proj.domain.recenzia_kostym;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdb_db.pdb_proj.utilities.rest_operationType;
import com.pdb_db.pdb_proj.domain.kostym.Kostym;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RecenziaKostymService {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final RecenziaKostymRepository recenziaKostymRepository;

    @Autowired
    public RecenziaKostymService(RecenziaKostymRepository recenziaKostymRepository) {
        this.recenziaKostymRepository = recenziaKostymRepository;
    }


    public List<RecenziaKostym> getRecenziaKostym() {
        return recenziaKostymRepository.findAll();
    }

    //Operacia: Pridanie rezencie kostymu
    public void addNewRecenziaKostym(RecenziaKostym recenziaKostym)
    {
        //Check user
        Optional<Uzivatel> uzivatelOptional = recenziaKostymRepository.findUzivatelById(recenziaKostym.getUzivid());
        if(!uzivatelOptional.isPresent())
        {
            throw new IllegalStateException("Can not create costume reservation to non existent user");
        }

        //Check costume
        Optional<Kostym> kostymOptional = recenziaKostymRepository.findKostymById(recenziaKostym.getKostymid());
        if(!kostymOptional.isPresent())
        {
            throw new IllegalStateException("Can not create costume reservation for non existent costume");
        }

        // Oracle
        recenziaKostymRepository.save(recenziaKostym);
        // Kafka -> MongoDB
        recenziaKostym.setOperation(rest_operationType.POST);
        this.kafka_sendMessage(recenziaKostym);

    }

    //Operacia: Zmazanie rezencie kostymu
    public void deleteRecenziaKostym(Integer id) {
        boolean exists = recenziaKostymRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Unsuccessful DELETE request. Record with id: "+id+" is NOT exists!");
        }

        // Oracle
        recenziaKostymRepository.deleteById(id);
        // Kafka -> MongoDB
        RecenziaKostym recenziaKostym = new RecenziaKostym(id);
        recenziaKostym.setOperation(rest_operationType.DELETE);
        this.kafka_sendMessage(recenziaKostym);
    }

    //Operiacia: Pridanie hodnotenia (suhlas/Nesuhlas) k recenzii
    @Transactional
    public void updateRecenziaKostym(Integer id, String nazov, String popis, Integer suhlas, Integer nesuhlas, Integer uzivid, Integer kostymid) {
        RecenziaKostym rkR = recenziaKostymRepository.findById(id
        ).orElseThrow(() ->
                new IllegalStateException("Unsuccessful UPDATE request. Record with id: "+id+" is NOT exists!"));

        rkR.setId(id);
        if (nazov != null && nazov.length() > 0){
            rkR.setNazov(nazov);
        }
        if (popis != null && popis.length() > 0){
            rkR.setPopis(popis);
        }
        if (suhlas != null && suhlas >= 0){
            rkR.setSuhlas(suhlas);
        }
        if (nesuhlas != null && nesuhlas >= 0){
            rkR.setNesuhlas(nesuhlas);
        }
        if (uzivid != null){
            rkR.setUzivid(uzivid);
        }
        if (kostymid != null){
            rkR.setKostymid(kostymid);
        }

        // Kafka -> MongoDB
        rkR.setOperation(rest_operationType.PUT);
        this.kafka_sendMessage(rkR);
    }

    @Autowired
    private KafkaTemplate<Long, String> kafkaTemplate;

    public void kafka_sendMessage(RecenziaKostym recenziaKostym) {
        try {
            String str_recenziaKostym = OBJECT_MAPPER.writeValueAsString(recenziaKostym);
            //SOT = Source of truth
            kafkaTemplate.send("recenziaKostymService_SOT_event", str_recenziaKostym);
        } catch (Exception e){
            System.out.println("Custom exception error [KafkaSender]: " + e.getMessage());
        }

    }
}
