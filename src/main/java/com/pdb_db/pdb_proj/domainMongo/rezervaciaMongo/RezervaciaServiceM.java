package com.pdb_db.pdb_proj.domainMongo.rezervaciaMongo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class RezervaciaServiceM
{

    private final RezervaciaRepositoryM rezervaciaRepositoryM;
    public List<RezervaciaM> getAllRezervaciaM()
    {
        return rezervaciaRepositoryM.findAll();
    }
}
