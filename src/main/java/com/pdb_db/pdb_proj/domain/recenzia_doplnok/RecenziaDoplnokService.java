package com.pdb_db.pdb_proj.domain.recenzia_doplnok;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import com.pdb_db.pdb_proj.utilities.rest_operationType;
import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RecenziaDoplnokService {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final RecenziaDoplnokRepository recenziaDoplnokRepository;

    @Autowired
    public RecenziaDoplnokService(RecenziaDoplnokRepository recenziaDoplnokRepository) {
        this.recenziaDoplnokRepository = recenziaDoplnokRepository;
    }


    public List<RecenziaDoplnok> getRecenziaDoplnok() {
        return recenziaDoplnokRepository.findAll();
    }


    public void addNewRecenziaDoplnok(RecenziaDoplnok recenziaDoplnok) {

        //Check user
        Optional<Uzivatel> uzivatelOptional = recenziaDoplnokRepository.findUzivatelById(recenziaDoplnok.getUzivid());
        if(!uzivatelOptional.isPresent())
        {
            throw new IllegalStateException("Can not create doplnok reservation to non existent user");
        }

        //Check doplnok
        Optional<Doplnok> doplnokOptional = recenziaDoplnokRepository.findDoplnokById(recenziaDoplnok.getDoplnokid());
        if(!doplnokOptional.isPresent())
        {
            throw new IllegalStateException("Can not create costume reservation for non existent costume");
        }

        // Oracle
        recenziaDoplnokRepository.save(recenziaDoplnok);
        // Kafka -> MongoDB
        recenziaDoplnok.setOperation(rest_operationType.POST);
        this.kafka_sendMessage(recenziaDoplnok);
    }

    public void deleteRecenziaDoplnok(Integer id) {
        boolean exists = recenziaDoplnokRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Unsuccessful DELETE request. Record with id: "+id+" is NOT exists!");
        }

        // Oracle
        recenziaDoplnokRepository.deleteById(id);
        // Kafka -> MongoDB
        RecenziaDoplnok recenziaDoplnok = new RecenziaDoplnok(id);
        recenziaDoplnok.setOperation(rest_operationType.DELETE);
        this.kafka_sendMessage(recenziaDoplnok);
    }

    @Transactional
    public void updateRecenziaDoplnok(Integer id, String nazov, String popis, Integer suhlas, Integer nesuhlas, Integer uzivid, Integer doplnokid) {
        RecenziaDoplnok rdR = recenziaDoplnokRepository.findById(id
        ).orElseThrow(() ->
                new IllegalStateException("Unsuccessful UPDATE request. Record with id: "+id+" is NOT exists!"));

        rdR.setId(id);
        if (nazov != null && nazov.length() > 0){
            rdR.setNazov(nazov);
        }
        if (popis != null && popis.length() > 0){
            rdR.setPopis(popis);
        }
        if (suhlas != null && suhlas >= 0){
            rdR.setSuhlas(suhlas);
        }
        if (nesuhlas != null && nesuhlas >= 0){
            rdR.setNesuhlas(nesuhlas);
        }
        if (uzivid != null){
            rdR.setUzivid(uzivid);
        }
        if (doplnokid != null){
            rdR.setDoplnokid(doplnokid);
        }

        // Kafka -> MongoDB
        rdR.setOperation(rest_operationType.PUT);
        this.kafka_sendMessage(rdR);
    }

    @Autowired
    private KafkaTemplate<Long, String> kafkaTemplate;

    public void kafka_sendMessage(RecenziaDoplnok recenziaDoplnok) {
        try {
            String str_recenziaDoplnok = OBJECT_MAPPER.writeValueAsString(recenziaDoplnok);
            //SOT = Source of truth
            kafkaTemplate.send("recenziaDoplnokService_SOT_event", str_recenziaDoplnok);
        } catch (Exception e){
            System.out.println("Custom exception error [KafkaSender]: " + e.getMessage());
        }

    }
}
