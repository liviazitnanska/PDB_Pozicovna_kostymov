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

    /*public DoplnokM getDoplnokMById(Integer id)
    {
        return doplnokRepositoryM.findDoplnokMById(id).get();
    }*/

    /*public List<DoplnokM> getAllDoplnokMByMaterial(String material)
    {
        return doplnokRepositoryM.findAllByMaterial(material);
    }

    public List<DoplnokM> getAllDoplnokMByKategoria(String kategoria)
    {
        return doplnokRepositoryM.findAllByKategoria(kategoria);
    }*/

}
