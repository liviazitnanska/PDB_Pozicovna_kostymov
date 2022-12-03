package com.pdb_db.pdb_proj.domain.kostym_rezervacia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import com.pdb_db.pdb_proj.utilities.rest_operationType;
import com.pdb_db.pdb_proj.domain.kostym.Kostym;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class KostymRezervaciaService {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final KostymRezervaciaRepository kostymRezervaciaRepository;

    @Autowired
    public KostymRezervaciaService(KostymRezervaciaRepository kostymRezervaciaRepository) {
        this.kostymRezervaciaRepository = kostymRezervaciaRepository;
    }

    public List<KostymRezervacia> getKostymRezervacie()
    {
        return kostymRezervaciaRepository.findAll();
    }

    public List<KostymRezervacia> getAllOngoing()
    {
        return kostymRezervaciaRepository.findAllByVratenie(0);
    }

    public List<KostymRezervacia> getAllEnded()
    {
        return kostymRezervaciaRepository.findAllByVratenie(1);
    }


    public void addNewKostymRezervacia(KostymRezervacia kostymRezervacia)
    {
        //Check user
        Optional<Uzivatel> uzivatelOptional = kostymRezervaciaRepository.findUzivatelById(kostymRezervacia.getUzivid());
        if(!uzivatelOptional.isPresent())
        {
            throw new IllegalStateException("Can not create costume reservation to non existent user");
        }

        //Check costume
        Optional<Kostym> kostymOptional = kostymRezervaciaRepository.findKostymById(kostymRezervacia.getKostymid());
        if(!kostymOptional.isPresent())
        {
            throw new IllegalStateException("Can not create costume reservation for non existent costume");
        }

        // Oracle
        kostymRezervaciaRepository.save(kostymRezervacia);
        // Kafka -> MongoDB
        kostymRezervacia.setOperation(rest_operationType.POST);
        this.kafka_sendMessage(kostymRezervacia);
    }

    public void deleteKostymRezervacia(Integer kostymRezervaciaId) {

        KostymRezervacia kostymRezervacia = kostymRezervaciaRepository.findById(kostymRezervaciaId)
                .orElseThrow(() -> new IllegalStateException("KostymRezervacia with ID "+kostymRezervaciaId+" does not exist"));

        // Oracle
        kostymRezervaciaRepository.deleteById(kostymRezervaciaId);
        // Kafka -> MongoDB
        kostymRezervacia.setOperation(rest_operationType.DELETE);
        this.kafka_sendMessage(kostymRezervacia);
    }

    @Transactional
    public void updateKostymRezervacia(Integer kostymRezervaciaId,
                                       Integer uzivid,
                                       Integer kostymid,
                                       java.util.Date casPozicania,
                                       java.util.Date casVratenia,
                                       Integer vratenie
                                       )
    {
        KostymRezervacia kostymRezervacia = kostymRezervaciaRepository.findById(kostymRezervaciaId)
                .orElseThrow(() -> new IllegalStateException("KostymRezervacia with ID "+kostymRezervaciaId+" does not exist"));

        if (uzivid != null)
        {
            kostymRezervacia.setUzivid(uzivid);
        }
        if (kostymid != null)
        {
            kostymRezervacia.setKostymid(kostymid);
        }
        if (casPozicania != null){
            kostymRezervacia.setCasPozicania(casPozicania);
        }
        if (casVratenia != null){
            kostymRezervacia.setCasVratenia(casVratenia);
        }
        if (vratenie != null && (vratenie == 0 || vratenie == 1)) {
            kostymRezervacia.setVratenie(vratenie);
        }
    }

    @Autowired
    private KafkaTemplate<Long, String> kafkaTemplate;

    public void kafka_sendMessage(KostymRezervacia kostymRezervacia) {
        try {
            String str_kostymRezervacia = OBJECT_MAPPER.writeValueAsString(kostymRezervacia);
            //SOT = Source of truth
            kafkaTemplate.send("kostymRezervaciaService_SOT_event", str_kostymRezervacia);
        } catch (Exception e){
            System.out.println("Custom exception error [KafkaSender]: " + e.getMessage());
        }

    }
}
