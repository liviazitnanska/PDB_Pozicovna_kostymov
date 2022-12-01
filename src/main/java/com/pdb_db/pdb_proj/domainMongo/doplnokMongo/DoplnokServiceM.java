package com.pdb_db.pdb_proj.domainMongo.doplnokMongo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DoplnokServiceM {

   private final DoplnokRepositoryM doplnokRepositoryM;

    public List<DoplnokM> getAllDoplnokM()
    {
        return doplnokRepositoryM.findAll();
    }
}
