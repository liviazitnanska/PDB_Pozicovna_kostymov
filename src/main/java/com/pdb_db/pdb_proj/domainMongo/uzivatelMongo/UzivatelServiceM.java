package com.pdb_db.pdb_proj.domainMongo.uzivatelMongo;

import com.pdb_db.pdb_proj.domainMongo.doplnokMongo.DoplnokRepositoryM;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class UzivatelServiceM
{
    private final UzivatelRepositoryM uzivatelRepositoryM;
    public List<UzivatelM> getAllUzivatelM()
    {
        return uzivatelRepositoryM.findAll();
    }
}
