package com.pdb_db.pdb_proj.domainMongo.uzivatelMongo;

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
/*
    public UzivatelM getUzivatelMById(Integer id)
    {
        return uzivatelRepositoryM.findUzivatelMById(id).get();
    }

    public UzivatelM getUzivatelByAdresa(Integer cislodomu,
                                          String mesto,
                                          String stat,
                                          String ulica,
                                          Integer psc)
    {
        return uzivatelRepositoryM.findUzivatelMByByCislodomuAndMestoAndStatAndUlicaAndPsc(cislodomu, mesto, stat, ulica, psc);
    }

    public List<UzivatelM> getAllUzivatelbyAdresa(Integer cislodomu,
                                                  String mesto,
                                                  String stat,
                                                  String ulica,
                                                  Integer psc)
    {
        return uzivatelRepositoryM.findAllByCislodomuAndMestoAndStatAndUlicaAndPsc(cislodomu, mesto, stat, ulica, psc);
    }

    public UzivatelM getUzivatelByEmail(String email)
    {
        return uzivatelRepositoryM.findUzivatelMByEmail(email).get();
    }*/


}
