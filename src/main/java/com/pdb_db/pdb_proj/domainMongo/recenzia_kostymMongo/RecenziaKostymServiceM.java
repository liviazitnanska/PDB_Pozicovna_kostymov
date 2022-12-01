package com.pdb_db.pdb_proj.domainMongo.recenzia_kostymMongo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class RecenziaKostymServiceM {

    private final RecenziaKostymRepositoryM recenziaKostymRepositoryM;
    public List<RecenziaKostymM> getAllRecenziaKostymM() {
        return recenziaKostymRepositoryM.findAll();
    }
}
