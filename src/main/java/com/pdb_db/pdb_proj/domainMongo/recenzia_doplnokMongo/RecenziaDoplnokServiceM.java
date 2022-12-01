package com.pdb_db.pdb_proj.domainMongo.recenzia_doplnokMongo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class RecenziaDoplnokServiceM {

    private final RecenziaDoplnokRepositoryM recenziaDoplnokRepositoryM;
    public List<RecenziaDoplnokM> getAllRecenziaDoplnokM() {
        return  recenziaDoplnokRepositoryM.findAll();
    }
}
