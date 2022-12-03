package com.pdb_db.pdb_proj.domain.kostym;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdb_db.pdb_proj.utilities.rest_operationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class KostymService {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final KostymRepository kostymRepository;

    @Autowired
    public KostymService(KostymRepository kostymRepository) {
        this.kostymRepository = kostymRepository;
    }

    public List<Kostym> getKostymy()
    {
        return kostymRepository.findAll();
    }

    public Kostym getKostymById(Integer id)
    {
        Optional <Kostym> optionalKostym = kostymRepository.findById(id);
        if (!optionalKostym.isPresent())
        {
            throw new IllegalStateException("This Costume does not exist");
        }
        return optionalKostym.get();
    }

    public Optional<Kostym> getKostymByNazov(String nazov)
    {
        Optional <Kostym> optionalKostym = kostymRepository.findKostymByNazov(nazov);
        if (!optionalKostym.isPresent())
        {
            throw new IllegalStateException("This Costume does not exist");
        }
        return optionalKostym;
    }

    public List<Kostym> get_Kostymy_by_material(String material)
    {
        return  kostymRepository.findAllByMaterial(material);
    }

    public void addNewKostym(Kostym kostym)
    {
        //System.out.println(kostym);
        Optional<Kostym> kostymOptional =  kostymRepository.findKostymByNazov(kostym.getNazov());

        //Make sure there is not a costume with a same name
        if(kostymOptional.isPresent())
        {
            throw new IllegalStateException("Kostym already exists");
        }

        // Oracle
        kostymRepository.save(kostym);
        // Kafka -> MongoDB
        kostym.setOperation(rest_operationType.POST);
        this.kafka_sendMessage(kostym);
    }

    public void deleteKostym(Integer kostymId)
    {
        boolean exists = kostymRepository.existsById(kostymId);

        if (!exists)
        {
            throw new IllegalStateException("Kostym with this ID "+kostymId+" does not exist");
        }

        // Oracle
        kostymRepository.deleteById(kostymId);
        // Kafka -> MongoDB
        Kostym kostym = new Kostym(kostymId);
        kostym.setOperation(rest_operationType.DELETE);
        this.kafka_sendMessage(kostym);
    }

    @Transactional
    public void updateKostym(Integer kostymId, String nazov, String popis, String material, String kategoria, Integer velkost, java.util.Date vyroba)
    {
        Kostym kostym = kostymRepository.findById(kostymId)
                .orElseThrow(() -> new IllegalStateException("Kostym with ID "+kostymId+"does not exist"));

        if (nazov != null && nazov.length() > 0)
        {
            //Nazov cant be shared with two different objects
            Optional<Kostym> kostymOptional = kostymRepository.findKostymByNazov(nazov);
            if(kostymOptional.isPresent())
            {
                throw new IllegalStateException("Nazov of Kostym taken");
            }
            kostym.setNazov(nazov);
        }
        if (popis != null && popis.length() > 0)
        {
            kostym.setPopis(popis);
        }
        if (material != null && material.length() > 0)
        {
            kostym.setMaterial(material);
        }
        if (kategoria != null && kategoria.length() > 0)
        {
            kostym.setKategoria(kategoria);
        }
        if (velkost!= null )
        {
            kostym.setVelkost(velkost);
        }
        if (vyroba != null) //TODO mozno nieco pridat??
        {
            kostym.setVyroba(vyroba);
        }

        // Kafka -> MongoDB
        kostym.setOperation(rest_operationType.PUT);
        this.kafka_sendMessage(kostym);
    }

    @Autowired
    private KafkaTemplate<Long, String> kafkaTemplate;

    public void kafka_sendMessage(Kostym kostym) {
        try {
            String str_kostym = OBJECT_MAPPER.writeValueAsString(kostym);
            //SOT = Source of truth
            kafkaTemplate.send("kostymService_SOT_event", str_kostym);
        } catch (Exception e){
            System.out.println("Custom exception error [KafkaSender]: " + e.getMessage());
        }

    }
}
