package com.pdb_db.pdb_proj.domain.doplnok_rezervacia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import com.pdb_db.pdb_proj.domain.uzivatel.UzivatelRepository;
import com.pdb_db.pdb_proj.utilities.rest_operationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DoplnokRezervaciaService
{
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final DoplnokRezervaciaRepository doplnokRezervaciaRepository;
    private final UzivatelRepository uzivatelRepository;

    @Autowired
    public DoplnokRezervaciaService(DoplnokRezervaciaRepository doplnokRezervaciaRepository, UzivatelRepository uzivatelRepository) {
        this.doplnokRezervaciaRepository = doplnokRezervaciaRepository;
        this.uzivatelRepository = uzivatelRepository;
    }

    public List<DoplnokRezervacia> getDoplnokRezervacie()
    {
        return doplnokRezervaciaRepository.findAll();
    }


    public void addNewDoplnokRezervacia(DoplnokRezervacia doplnokRezervacia)
    {
        System.out.println("DEBUGDEBUG");
        System.out.println(doplnokRezervacia.getId());
        System.out.println(doplnokRezervacia.getUzivid());

        //Check user
        boolean uzivatelBool = uzivatelRepository.existsById(doplnokRezervacia.getUzivid());

        if(!uzivatelBool)
        {
            throw new IllegalStateException("Can not create doplnok reservation to non existent user");
        }

        //Check doplnok
        Optional<Doplnok> doplnokOptional = doplnokRezervaciaRepository.findDoplnokById(doplnokRezervacia.getDoplnokid());
        if(!doplnokOptional.isPresent())
        {
            throw new IllegalStateException("Can not create costume reservation for non existent costume");
        }

        // Oracle
        doplnokRezervaciaRepository.save(doplnokRezervacia);
        // Kafka -> MongoDB
        doplnokRezervacia.setOperation(rest_operationType.POST);
        this.kafka_sendMessage(doplnokRezervacia);

    }

    public void deleteDoplnokRezervacia(Integer doplnokRezervaciaId)
    {
        DoplnokRezervacia doplnokRezervacia = doplnokRezervaciaRepository.findById(doplnokRezervaciaId)
                .orElseThrow(() -> new IllegalStateException("DoplnokRezervacia with ID "+doplnokRezervaciaId+" does not exist"));

        //Oracle
        doplnokRezervaciaRepository.deleteById(doplnokRezervaciaId);
        // Kafka -> MongoDB
        doplnokRezervacia.setOperation(rest_operationType.DELETE);
        this.kafka_sendMessage(doplnokRezervacia);
    }

    @Transactional
    public void updateDoplnokRezervacia(Integer doplnokRezervaciaId,
                                        Integer uzivid,
                                        Integer doplnokid,
                                        java.util.Date casPozicania,
                                        java.util.Date casVratenia,
                                        Integer vratenie)
    {
        DoplnokRezervacia doplnokRezervacia = doplnokRezervaciaRepository.findById(doplnokRezervaciaId)
                .orElseThrow(() -> new IllegalStateException("DoplnokRezervacia with ID "+doplnokRezervaciaId+" does not exist"));

        if (uzivid != null)
        {
            doplnokRezervacia.setUzivid(uzivid);
        }
        if (doplnokid != null)
        {
            doplnokRezervacia.setDoplnokid(doplnokid);
        }
        if (casPozicania != null){
            doplnokRezervacia.setCasPozicania(casPozicania);
        }
        if (casVratenia != null){
            doplnokRezervacia.setCasVratenia(casVratenia);
        }
        if (vratenie != null && (vratenie == 0 || vratenie == 1)) {
            doplnokRezervacia.setVratenie(vratenie);
        }
    }

    @Autowired
    private KafkaTemplate<Long, String> kafkaTemplate;

    public void kafka_sendMessage(DoplnokRezervacia doplnokRezervacia) {
        try {
            String str_doplnokRezervacia = OBJECT_MAPPER.writeValueAsString(doplnokRezervacia);
            //SOT = Source of truth
            kafkaTemplate.send("doplnokRezervaciaService_SOT_event", str_doplnokRezervacia);
        } catch (Exception e){
            System.out.println("Custom exception error [KafkaSender]: " + e.getMessage());
        }

    }
}
