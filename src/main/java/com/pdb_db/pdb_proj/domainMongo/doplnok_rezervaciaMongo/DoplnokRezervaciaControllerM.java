package com.pdb_db.pdb_proj.domainMongo.doplnok_rezervaciaMongo;

import com.pdb_db.pdb_proj.domain.doplnok_rezervacia.DoplnokRezervacia;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdb_db.pdb_proj.domainMongo.recenzia_doplnokMongo.RecenziaDoplnokM;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/v1/doplnokrezervaciaM")
@AllArgsConstructor
public class DoplnokRezervaciaControllerM {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final DoplnokRezervaciaRepositoryM doplnokRezervaciaRepositoryM;

    @GetMapping
    public List<DoplnokRezervaciaM> fetchAllDoplnokRezervaciaM()
    {
        return doplnokRezervaciaRepositoryM.findAll();
    }

}
