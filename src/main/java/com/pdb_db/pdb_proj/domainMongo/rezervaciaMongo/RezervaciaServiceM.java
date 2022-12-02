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
/*
    public List<RezervaciaM> getSkonceneRezervacieM()
    {
        return rezervaciaRepositoryM.findAllbyVratenie(1);
    }

    public List<RezervaciaM> getOtvoreneRezervacieM()
    {
        return rezervaciaRepositoryM.findAllbyVratenie(0);
    }


    public RezervaciaM getRezervaciaByID(Integer id)
    {
        return rezervaciaRepositoryM.findRezervaciaMById(id).get();
    }*/
}


